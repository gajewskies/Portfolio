import pyttsx
engine = pyttsx.init()
# change voicees
voices = engine.getProperty('voices')
# change speech rate
rate = engine.getProperty('rate')
engine.setProperty('rate', rate-50)
# change volume
#volume = engine.getProperty('volume')
#engine.setProperty('volume', volume+25)
for voice in voices:
	engine.setProperty('voice', voice.id)
	engine.say("My name is tyler")
engine.runAndWait()