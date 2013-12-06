/**
 * Cria um servidor de acesso para obtenção da geolocalização do usuário e a localização de uma determinada cidade.
 */

// definição do protocolo de conexão
var http = require('http');
// inclusão do módulo node-static
var Static = require('node-static');
var app = http.createServer(handler);
// cria um socket
var io = require('socket.io').listen(app);
// porta do serviço
var port = 8000;

// definição da pasta dos arquivos do site
var files = new Static.Server('./public');

// método para lidar com as requisições http
function handler (request, response) {
	request.on('end', function() {
		files.serve(request, response);
	}).resume();
}

// logs do socket
io.set('log level', 1);

// executa ações quando uma conexão for estabelecida
io.sockets.on('connection', function (socket) {

	socket.on('send:coords', function (data) {
		socket.broadcast.emit('load:coords', data);
	});
});

// inicia o servidor na porta específica
app.listen(port);
console.log('servidor rodando em: localhost:' + port);
