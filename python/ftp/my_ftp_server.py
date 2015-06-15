import socket
import threading
import MySQLdb
import os

ip = "127.0.0.1"
port = 190

db = MySQLdb.connect(host="localhost", user="root", db="ftp")
cur = db.cursor()


s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((ip, port))
s.listen(10)

def listen(ns):
	while True:
		c = ns.recv(4096)
		c_split = c.split(' ', 2)
		print c
		if c_split[0] == "CREATE":
			create(c_split[1],c_split[2])
		elif c_split[0] == "SHOW":
			show(c_split[1],ns)
		elif c == "quit":
			ns.close()
			break
		else:
			print "[*]Invalid Command"


def create(filename, contents):
	fd = open(filename, "w")
	fd.write(contents)
	fd.close()

def show(filename,ns):
	if os.path.isfile(filename):
		fd = open(filename, "r")
		myfile = fd.read()
		ns.send(myfile)


def conn_handler(ns, addr):
	ns.send("Server demo banner")
	while True:
		user = ns.recv(4096)
		passwd = ns.recv(4096)
		u_name = user.split(' ',1)
		p_word = passwd.split(' ', 1)
		if u_name[0] != "USER":
			ns.send("[*] Invalid input")
			continue
		else:
			sql = "select * from account where user = '%s';" % u_name[1]
			cur.execute(sql)
			results = cur.fetchall()
			if not results:
				ns.send("[*] User does not exist")
				continue
			for row in results:
				print "USER: %s FOUND" % row[0]
		if p_word[0] != "PASSWD":
			ns.send("[*] Invalid input")
			continue
		else:
			sql = "select * from account where user = '%s' and passwd = '%s';" % (u_name[1], p_word[1])
			cur.execute(sql)
			results = cur.fetchall()
			if cur.rowcount != 0:
				print "USER: %s FOUND" % row[0]
				print "PASSWD: %s FOUND" % row[1]
				ns.send("OK")
				break
			else:
				ns.send("[*] Invalid Password")
				continue

			break
	print "%s sent me %s" % (addr[0], u_name[1])	
	print "%s sent me %s" % (addr[0], p_word[1])

	listen(ns)
	ns.close()

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((ip, port)) # this line opens the port on the operating system
s.listen(10)

while True:
	new_socket, client_addr_info = s.accept()
	print "**********************************************"
	print client_addr_info
	print "**********************************************"

	c = threading.Thread(target = conn_handler, args=(new_socket, client_addr_info))
	c.start()
