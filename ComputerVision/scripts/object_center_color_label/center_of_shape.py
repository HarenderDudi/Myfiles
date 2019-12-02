import cv2
import imutils

image = cv2.imread("../images/shape2.png")

img_gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
img_blur = cv2.GaussianBlur(img_gray, (5,5), 0)

img_thrash = cv2.threshold(img_blur, 70, 255, cv2.THRESH_BINARY)[1]
img_erode = cv2.erode(img_thrash, None, iterations=2)
img_dilate = cv2.dilate(img_erode, None, iterations=2)

cnts = cv2.findContours(img_dilate.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

cnts = imutils.grab_contours(cnts)

for c in cnts:
    M = cv2.moments(c)
    cX = int(M["m10"]/M["m00"])
    cY = int(M["m01"]/M["m00"])

    cv2.drawContours(image, [c], -1, (0,255,255),2)
    cv2.circle(image, (cX,cY), 5, (255,255,255), -1)
    cv2.putText(image,"center", (cX-20, cY-20), cv2.FONT_HERSHEY_SIMPLEX, 0.3, (255,255,255), 1)

cv2.imshow("image", image)
cv2.waitKey(0)
