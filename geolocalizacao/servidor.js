var http = require('http');
var Static = require('node-static');
var app = http.createServer(handler);
var io = require('socket.io').listen(app);
var port = 8000;

var files = new Static.Server('./public');

function handler (request, response) {
	request.on('end', function() {
		files.serve(request, response);
	}).resume();
}

// logs do socket
io.set('log level', 1);

io.sockets.on('connection', function (socket) {

	socket.on('send:coords', function (data) {
		socket.broadcast.emit('load:coords', data);
	});
});

// inicia o servidor na porta específica
app.listen(port);
console.log('servidor rodando em: localhost:' + port);
