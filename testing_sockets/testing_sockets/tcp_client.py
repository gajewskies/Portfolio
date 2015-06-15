import socket 											# import the socket library
import urllib2

ip = "127.0.0.1"										# ip to connect to 
port = 3000												# port to connect to 
banner = "Python client to server"
#urllib2.urlopen("http://127.0.0.1:8421").read()

my_list = []
for i in range(1, 4000, 200):
	my_list.append("A" * i)

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)	# set up the socket
try:
	s.connect((ip, port))								# connect to the socket
	print "[*] Connection Accepted"		
	s.send(banner)										# send the banner to the socket
except:
	print "[!] Connection Failed"

while True:
	command = raw_input()								# accept input from command line user
	if command == "exit":
		s.close()
	else:
		for item in my_list:
			s.send(item)									# send the command over to the server
	data = s.recv(4096)									# print the servers response

s.close()
