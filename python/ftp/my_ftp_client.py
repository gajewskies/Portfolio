import socket
import sys
import hashlib
import uuid

def hash_password(password):
    return hashlib.sha256(password.encode()).hexdigest()

ip = sys.argv[1]
port = int(sys.argv[2])
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

s.connect((ip, port))

banner = s.recv(4096)
print banner

invalid = "[*] Invalid input"
while True:
	print "Username"
	user = raw_input()
	s.send(user)
	print "password"
	passwd = raw_input()
	passwd_split = passwd.split(' ', 1)
	if len(passwd_split) <= 1:
		print "No password entered"
		continue
	hash_passwd = hash_password(passwd_split[1])
	s.send(passwd_split[0] + ' ' + hash_passwd)
	invalid = s.recv(4096)
	print invalid
	if invalid != "[*] Invalid input":
		if invalid != "[*] User does not exist":
			if invalid != "[*] Invalid Password":
				break

while True:
	print "Enter a command"
	command = raw_input()
	s.send(command)
	parsed_command = command.split(' ', 1)
	if parsed_command[0] == "SHOW":
		test = s.recv(4096)
		print test
	if command == "quit":
		break

s.close()