const express = require("express");
var cors = require('cors');
const {cookieSecret} = require('./credentials.js');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');


const app = express();
// 
app.use(cors())

app.set('port', process.env.PORT || 3001);

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

