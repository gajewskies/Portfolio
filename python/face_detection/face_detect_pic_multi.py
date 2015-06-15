import cv2
import sys
import os

imagePath = sys.argv[1]
cascPath = sys.argv[2]
#cascPath = "haarcascade_frontalface_alt.xml"

# Create the haar cascade
faceCascade = cv2.CascadeClassifier(cascPath)

# declare empty list to hold images in directory supplied
pics = []
# append images in dir to image list
for pic in os.listdir(imagePath):
	pics.append(pic)

print pics

# specify exact path the the directory holding images
path = "/home/Tyler/Documents/face_detection/pics/"

i = 0
while True:
	if i >= len(pics):
		sys.exit()

	# read an image
	image = cv2.imread(path+pics[i])
	gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
	
	# Detect faces in the image
	faces = faceCascade.detectMultiScale(gray,scaleFactor=1.1,minNeighbors=5,minSize=(30, 30),flags = cv2.cv.CV_HAAR_SCALE_IMAGE)

	print "[*] Found %i faces in %s" % (len(faces), pics[i])

	# Draw a rectangle around the faces
	for (x, y, w, h) in faces:
	    cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)

	cv2.imshow("Faces found", image)
	i = i + 1

	# if you dont want the window to pop up comment out the below line
	cv2.waitKey(0)
