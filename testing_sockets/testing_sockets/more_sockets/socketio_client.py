from flask import Flask, render_template
from flask.ext.socketio import socketio, send, emit

# recieve data event
@socketio.on('data')
def handle_message(data):
	print '[*] Received: ' + data

# recieve json event
@socketio.on('json')
def handle_json(json):
	print '[*] Received json: ' + str(json)

# recieve custom event
@socketio.on('my event')
def handle_custom_event(json):
	print '[*] Received json: ' + str(json)

# send data
@socketio.on('data')
def handle_data_send(data):
	send(data)

# send json
@socketio.on('json')
def handle_json_send(json):
	send(data, json=True)	# send used for unamed events

# send custom event
@socketio.on('my event')
	def handle_custom_send(json):
		emit('my response', json) # emit used fot named events

def ack():
	print "[*] Data received by server"

@socketio.on('my event')
	def handle_custom_send(json):
		emit('my response', json, callback=ack))