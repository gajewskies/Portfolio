import socket
import threading
import hashlib
import MySQLdb

ip = "0.0.0.0"
port = 8421
banner = "**Welcome to a simple tcp server**"
db = MySQLdb.connect(host="127.0.0.1", user="Tyler", passwd="Robskate1", db="safeBus")
cur = db.cursor()

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.bind((ip, port))
sock.listen(10)

print "[*] Server listening on port %i" % port

def encrypt(data):
	return hashlib.sha256(data.encode()).hexdigest()

def connection_handler(sock, addr):
	sock.send(banner)
	while True:
		data = sock.recv(4096)
		print "[*] Received from %s: %s" % (addr[0], data)
		if data == encrypt("login"):
			login(sock, addr)
		elif data == encrypt("register"):
			register(sock, addr)
		elif data == encrypt("quit"):
			sock.close()
			break
		else:
			print "[!] Unrecognized command"
			sock.send("[!] Unrecognized command")
			break
	print "[!] Closed connection from: %s:%s" % (addr[0], addr[1])
	sock.close()

invalid = 0
def register(sock, addr):
	while True:
		print "[*] Sending username request"
		sock.send("Desired Username")
		username = sock.recv(4096)
		print "[*] Received " + username
		sql = "select * from accounts where username = '%s';" % username
		cur.execute(sql)
		results = cur.fetchall()
		if not results:
			print "[*] Username not found, Okay to register"
			invalid = 1
		else:
			print "[!] Username found, already taken"
			invalid = 0
			continue
		print "[*] Sending password request"
		sock.send("Password: ")
		password = sock.recv(4096)
		print "[*] Received %s" % password
		sql = "insert into accounts values('%s','%s');" % (username, password)
		cur.execute(sql)
		db.commit()
		sql = "select * from accounts where username='%s' and password='%s';" % (username, password)
		cur.execute(sql)
		results = cur.fetchall()
		if not results:
			print "[!] Failed registration"
			invalid = 0
		for row in results:
			print row[0] + " " + row[1]
			print "[*] Succesful login"
			invalid = 1
		if invalid != 0:
			connection_handler(sock, addr)
			break

invalid = 0
def login(sock, addr):
	while True:
		print "[*] Sending username request"
		sock.send("Username")
		username = sock.recv(4096)
		print "[*] Recieved " + username
		sql = "select * from accounts where username = '%s';" % username
		cur.execute(sql)
		results = cur.fetchall()
		if not results:
			print "[!] Username not found"
			invalid = 0
			continue
		for row in results:
			print "[*] Username found"
			invalid = 1
		print "[*] Sending password request"
		sock.send("Password: ")
		password = sock.recv(4096)
		print "[*] Received: " + password
		sql = "select * from accounts where username = '%s' and password = '%s';" % (username, password)
		cur.execute(sql)
		results = cur.fetchall()
		if not results:
			print "[!] Invalid login"
			sock.send("[!] Invalid login\n")
			invalid = 0
			continue
		for row in results:
			print "[*] Login succesful from: %s:%s" % (addr[0],addr[1])
			sock.send("[*] Login succesful\n")
			invalid = 1
		if invalid != 0:
			after_login(sock)
			break

def after_login(sock):
	# Do commands after succesful login here
	print "[*] Other commands to do with the server"
	sock.send("[*] Other commands to do with the server")

while True:
	client, client_address = sock.accept()
	print "[*] Client connected from %s:%s" % (client_address[0], client_address[1])
	
	t = threading.Thread(target=connection_handler, args=(client, client_address))
	t.start()
