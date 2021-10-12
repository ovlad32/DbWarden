const express = require("express");
var cors = require('cors');
const {cookieSecret} = require('./credentials.js');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
var graphqlHTTP = require('express-graphql');
var { buildSchema } = require('graphql');
var schema = buildSchema(`
  type Query {
    hello: String
  }
`);



const app = express();
// 
app.use(cors())

app.set('port', process.env.PORT || 3005);

app.use(cookieParser(cookieSecret));





app.listen(app.get('port'), () => {
    console.log("Started!");
}
);

require("./api.js")(app);

app.use(function (req, res, next) { 
    res.locals.showTests = app.get('env') !== 'production' && req.query.test === '1'; 
    next(); 
});

app.use((err, req, res, next) => {
    console.error(err.stack);
    res.type('text/plain');
    res.status(500).send(err);
    res.send('500 - Server error');
});

var app = express();
app.use('/graphql', graphqlHTTP({
  schema: schema,
  rootValue: root,
  graphiql: true,
}));
