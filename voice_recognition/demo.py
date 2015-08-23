import os
import subprocess
import speech_recognition
import pyttsx

engine = pyttsx.init()
rate = engine.getProperty('rate')
engine.setProperty('rate', rate-20)
subprocess.call(['clear'], shell=True)


while True:
	r = speech_recognition.Recognizer(language='en-AU')
	r.energy_threshold = 4000
	# use the default microphone as the audio source

	with speech_recognition.Microphone() as source:    
		#subprocess.call(["tput cup 0; tput dl 8"], shell=True)           
		print "[*] Listening..."
		audio = r.adjust_for_ambient_noise(source)
		audio = r.listen(source)                  

	try:
		#un-comment the following lines to show confidence levels
		#list = r.recognize(audio, True)
		#print "Possible transcriptions: "
		#for prediction in list:
		#	print " " + prediction["text"] + " (" + str(prediction["confidence"] * 100) + "%)"
		
		spoken = r.recognize(audio)
		print "[*] [YOU] %s" % spoken
		engine.say("You said " + spoken)
		if "open terminal" in spoken:
			subprocess.call(["gnome-terminal"], shell=True)
			print "[*] [ME] Opening the terminal" 
		elif "close terminal" in spoken:
			subprocess.call(['gnome-terminal -e=exit'], shell=True)

	except LookupError:                       
		engine.say("Could not understand audio")
		print "[!] Could not understand audio"
	
	engine.runAndWait()

#subprocess.call(["tput cup 2; tput dl 8"], shell=True)
