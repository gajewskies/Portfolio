from pygsr import Pygsr
speech = Pygsr()
# duration in seconds (3)
speech.record(3)
# select the language and obtain the result
phrase, complete_response = speech.speech_to_text('es_ES')
print phrase
