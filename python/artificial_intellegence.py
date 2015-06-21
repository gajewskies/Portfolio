import getpass
import time
import calendar
import random
import sys
import os

attempts = 0;


def login(attempts):
	if attempts == 3:
		print "[!] Too many failed attempts! Exiting..."
		sys.exit()
	else:
		user = raw_input("User: ")
		passwd = getpass.getpass("Pass: ")
		if not user:
			if not passwd:
				attempts = attempts + 1
				login(attempts)	
		greeting(user)

def greeting(user):
	history = []
	tasks =  []
	print "Hello %s" % user
	print "How can I help you today?"
	while True:
		command = raw_input("$ ")
		command = command.lower()
		history.append(command)
		listener(command, user, history, tasks)

def listener(command, user, history, tasks):
	local_time = time.asctime(time.localtime(time.time()))
	year = local_time.split(' ', 5)
	cal = calendar.TextCalendar(calendar.SUNDAY).formatyear(int(year[5]), 2, 1, 1, 2)
	clear = os.system('clear')

	unk_a = "[!] I'm sorry %s, I don't know what you're asking of me" % user
	unk_b = "[!] %s, I am not familiar with that, try asking me in another way" % user
	unk_c = "[!] What did you just say to me %s" % user
	unknown_command = [unk_a, unk_b, unk_c]

	welcome_1 = "[*] You're most welcome %s" % user
	welcome_2 = "[*] I do my best to please you"
	welcome_3 = "[*] I'm awesome, I know"
	welcome = [welcome_1, welcome_2, welcome_3]

	if "date" in command:
		print "[*] %s, today's date and time is %s" % (user, local_time)
	elif "thank" in command:
		print random.choice(welcome)
	elif "time" in command:
		print "[*] It is currently %s, anything else I can do for you" % local_time
	elif "calendar" in command:
		print "[*] Here is the calender for %s" % year[5]
		print cal
	elif "history" in command:
		for comm in history:
			print "[*] " + comm
	elif "schedule" in command:
		print "[*] What would you like me to schedule for you"
		apointment = raw_input("$ ")
		tasks.append(apointment)
	elif "apointments" in command:
		for apt in tasks:
			print "[*] " + apt
	elif "clear" in command:
		clear
	elif "help" in command:
		print "[*] I am serberus, Artificial intellegence."
		print
		print "[*] My accepted command's are currently:"
		print "[*]          date			today's date"
		print "[*]          time 			the current time"
		print "[*]      calendar 			this year's calendar"
		print "[*] 	     history 			print recent command history"
		print "[*]      schedule			schedule apointments"
		print "[*]   apointments			view apointments"
		print "[*] 		   clear            clear the screen"
		print "[*]     thank you 			if you would like to be polite"
	else:
		print random.choice(unknown_command)

login(attempts)
