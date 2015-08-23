"""
Simple way to access google api for speech recognition with python

Copyright (c) 2013, Carlos Ganoza Plasencia
url: http://about.me/drneox
"""
from pyaudio import PyAudio, paInt16
from wave import open as open_audio
from urllib2 import Request, urlopen
from os import system
from json import loads


class Pygsr:
    def __init__(self, file="audio"):
        self.format = paInt16
        self.rate = 8000
        self.channel = 1
        self.chunk = 1024
        self.file = file

    def convert(self):
        system("sox %s -t wav -r 8000 -t flac %s.flac" % (self.file, self.file))

    def record(self, time):
        audio = PyAudio()
        stream = audio.open(format=self.format, channels=self.channel,
                            rate=self.rate, input=True,
                            frames_per_buffer=self.chunk)
        print "REC: "
        frames = []
        for i in range(0, self.rate / self.chunk * time):
            data = stream.read(self.chunk)
            frames.append(data)
        stream.stop_stream()
        stream.close()
        audio.terminate()
        write_frames = open_audio(self.file, 'wb')
        write_frames.setnchannels(self.channel)
        write_frames.setsampwidth(audio.get_sample_size(self.format))
        write_frames.setframerate(self.rate)
        write_frames.writeframes(''.join(frames))
        write_frames.close()
        self.convert()

    def speech_to_text(self, language):
        url = "http://www.google.com/speech-api/v1/recognize?lang=%s" % language
        file_upload = "%s.flac" % self.file
        audio = open(file_upload, "rb").read()
        header = {"Content-Type": "audio/x-flac; rate=8000"}
        data = Request(url, audio, header)
        post = urlopen(data)
        response = post.read()
        phrase = loads(response)['hypotheses'][0]['utterance']
        return phrase, response