import cv2
import imutils

from scripts.modules.ShapeDetector import ShapeDetector

image = cv2.imread("../images/shape2.png")

resized = imutils.resize(image, 300)
ratio = image.shape[0]/resized.shape[0]

img_gray = cv2.cvtColor(resized, cv2.COLOR_BGR2GRAY)
img_blur = cv2.GaussianBlur(img_gray, (5,5), 0)

img_thrash = cv2.threshold(img_blur, 70, 255, cv2.THRESH_BINARY)[1]

cnts = cv2.findContours(img_thrash.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
cnts = imutils.grab_contours(cnts)

sd = ShapeDetector()

for c in cnts:
    M = cv2.moments(c)
    cX = int((M["m10"]/M["m00"]) * ratio)
    cY = int((M["m01"] / M["m00"]) * ratio)

    shape = sd.detect(c)

    c = c.astype('float')
    c *= ratio
    c = c.astype('int')

    cv2.drawContours(image, [c], -1, (0,0,255), 2)
    cv2.putText(image, shape, (cX, cY), cv2.FONT_HERSHEY_SIMPLEX, 0.3, (255,255,255), 1)

cv2.imshow("shapes",image)
cv2.waitKey(0)