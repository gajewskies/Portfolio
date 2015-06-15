import numpy as np
import cv2

cap = cv2.VideoCapture(0)

# Define the codec and create VideoWriter object
fourcc = cv2.cv.CV_FOURCC(*'XVID')
# 20.0 is the speed
out = cv2.VideoWriter('output.avi',fourcc, 20.0, (320,240))

while(cap.isOpened()):
    ret, frame = cap.read()
    out.write(frame)
    cv2.imshow('frame',frame)
    c = cv2.waitKey(1)
    if c != -1:
        cv2.imwrite("f" + ".jpg", frame)
        print "[*] Picture taken"
        
    if c & 0xFF == ord('q'):
        print "[*] Video recorded"
        break

cap.release()
cv2.destroyAllWindows()
