const bodyParser = require('body-parser');

const jsonParser = bodyParser.json();
const urlEncParser = bodyParser.urlencoded({ extended: true });

const { Pool } = require('pg');

const dbc = new Pool({
	user: 'dbwa',
	password: 'awbdawbd',
	host: 'localhost',
	port: 5432,
	database: 'edm',
	max: 20,
	min: 0,
	connectionTimeoutMillis: 3000,
	idleTimeoutMillis: 0
});

dbc.on('connect', (client) => {
	client.query('SET search_path = dbw');
});

doTx = (txProc, reject, resolve) => {
	return (err, conn, done) => {
		conn
			.query('BEGIN')
			.then((z) => txProc(conn))
			.then((txr) =>
				conn.query('COMMIT').then((z) => {
					if (resolve) resolve(txr);
				})
			)
			.catch((err) => {
				console.error('Error in transaction:' + err.stack);
				conn.query('ROLLBACK', (err) => {
					if (err) {
						console.error('Error rolling back client', err.stack);
					}
				});
				if (reject) reject(err);
			})
			.finally((r) => done());
	};
};

module.exports = function(app) {
	/*
    app.get('/login', function(req, res){
        res.render('login', {
            title: 'Express Login'
        });
    });
*/
	app.get('/databases/types', (req, res) => {
		dbc
			.query('select type, name from dbw.r_database_type order by i_order desc')
			.then((rs) => {
				res.send({ rowCount: rs.rowCount, rows: rs.rows });
			})
			.catch((err) => {
				res.status(500).send(err);
				console.error(err);
			});
	});

	app.post('/databases', jsonParser, (req, res) => {
		const item = req.body;
		dbc.connect(
			doTx(
				(conn) => {
					if (item.id) {
						return conn.query(
							`
							update c_database set type=$2, alias=$3, url=$4 where id=$1 returning id
							`,
							[ item.id, item.type, item.alias, item.url ]
						);
					} else {
						return conn.query(
							`
                            insert into c_database(type,alias,url) values ($1, $2, $3) returning id
                            `,
							[ item.type, item.alias, item.url ]
						);
					}
				},
				(err) => res.status(500).send({ success: false, error: err }),
				(r) =>
					res.status(item.id ? 202 : 201).send({
						success: true,
						rowCount: r.rowCount,
						id: r.rows.length ? parseInt(r.rows[0].id) : undefined
					})
			)
		);
	});

	app.get('/databases', jsonParser, (req, res) => {
		const filters = req.body;
		dbc
			.query(
				`
                select t.*,
				   (select row_to_json(r) as r_database_type from r_database_type r where r.type = t.type)	
				     from c_database t
                    where cast($1 as text) is null or 
                        t.alias like '%'||cast($1 as text)||'%'
                    `,
				[ filters.searchString || null ]
			)
			.then((rs) => {
				res.send({ rowCount: rs.rowCount, rows: rs.rows });
			})
			.catch((err) => {
				res.status(500).send(err);
				console.error(err);
			});
	});

	app.get('/databases/groupedByType',jsonParser, (req,res) => {
		const filters = req.body;
		dbc.query(`
		select * from (
			select r.type, r.name,
				(select json_agg(d) as c_databases 
					from dbw.c_database d 
					where d.type = r.type 
					and d.is_deleted = false
					and (cast($1 as text) is null or 
						d.alias like '%'||cast($1 as text)||'%') )
			from r_database_type r
			where cast($1 as text) is null or 
				r.name like '%'||cast($1 as text)||'%'
		)  as t 
		where t.c_databases is not null
		`,[filters.searchString || null])
		.then((rs) => {
			res.send({ rowCount: rs.rowCount, rows: rs.rows });
		})
		.catch((err) => {
			res.status(500).send(err);
			console.error(err);
		});
	});
	//other routes..
};
