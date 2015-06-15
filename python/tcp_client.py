import socket
import sys
import hashlib

def encrypt(command):
	return hashlib.sha256(command.encode()).hexdigest()

ip = sys.argv[1]
port = int(sys.argv[2])

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
	sock.connect((ip, port))
	print "[*] Connection succeded"
except:
	print "[!] Connection failed"
	

while True:
	data = sock.recv(4096)
	print "[*] Received %s" % data
	command = raw_input()
	enc_command = encrypt(command)
	sock.send(enc_command)
	
	print "[*] Sent %s" % enc_command
	if command == "quit":
		break

sock.close()
