import numpy as np
import cv2

canvas = np.zeros((300, 300, 3), dtype="uint8")

# Lines
green = (0, 255, 0) # BGR
cv2.line(canvas, (0,0), (300,300), green, 1)
# cv2.line(canvas, (10,0), (300,300), green, 1)
# cv2.line(canvas, (0,10), (300,300), green, 1)
cv2.imshow("Canvas", canvas)
cv2.waitKey(0)


# Rectangle
red = (0,0,255)
cv2.rectangle(canvas, (50,50), (100,60), red, 2)
cv2.rectangle(canvas, (150,50), (250,80), green, -1)
cv2.imshow("Canvas", canvas)
cv2.waitKey(0)

# Circles
canvas = np.zeros((300,300,3), dtype="uint8")
cX, cY = int(canvas.shape[1]/2), int(canvas.shape[0]/2)
white = (255,255,255)

for r in range(0, 175, 25):
    cv2.circle(canvas, (cX, cY), r, white, 2)
    # cv2.circle(canvas, (150, 0), r, white, 2)

cv2.imshow("Canvas", canvas)
cv2.waitKey(0)
