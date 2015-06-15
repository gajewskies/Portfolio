var http = require('http');
var ip = '0.0.0.0'
var port = 8421

http.createServer(function (request, response) {
	response.writeHead(200, {'Content-Type': 'text/plain'});
	response.end('Hello World\n');
}).listen(port, ip);

console.log('Server running at http://' + ip + ":" + port);
