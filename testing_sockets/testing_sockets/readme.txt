In order to run the .js files you must first have nodejs:
apt-get install nodejs

Then to run the html_server.js or tcp_server.js run:
node html_server.js
or
node tcp_server.js

To run the python clients run:
python tcp_client.py
or
python html_client.py

the node_modules folder is required by the tcp and html server for importing libraries
the modules needed for the servers are socket.io and exppress
npm install socket.io
npm install express

