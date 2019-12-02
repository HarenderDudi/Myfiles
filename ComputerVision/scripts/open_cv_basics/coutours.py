import numpy as np
import cv2
import imutils

image = cv2.imread("images/image2.jpeg")
grey = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)

blurred = cv2.GaussianBlur(grey, (5,5), 0)

edged = cv2.Canny(blurred, 30,200)
# cv2.imshow("canny", edged)
# cv2.waitKey(0)
(_,cnts, _) = cv2.findContours(edged.copy(),
                             cv2.RETR_EXTERNAL,
                             cv2.CHAIN_APPROX_SIMPLE)
print("I count: %d in this image" %(len(cnts)))

dinos = image.copy()
cv2.drawContours(dinos, cnts, -1, (0,255,0), 1)
# cv2.imshow("Dinos", dinos)
# cv2.waitKey(0)

for (i,c) in enumerate(cnts):
    (x,y,w,h) = cv2.boundingRect(c)

    print("Dino #%d" %(i+1))
    dino = image[y:y+h, x:x+w]
    cv2.imshow("dino", dino)
    cv2.waitKey(0)