var http = require('http');

ip = "127.0.0.1";														//define ip to listen to
port = 8421; 															//define a port to listen to


function handleRequest(request, response){								//function to handles requests and send response
    response.end('[*] Welcome to the html server with nodejs' + request.url);
}
var server = http.createServer(handleRequest);							//Create a server

server.listen(port, function(){											//Lets start our server
    console.log("Server listening on: http://" + ip + ":" + port);
});