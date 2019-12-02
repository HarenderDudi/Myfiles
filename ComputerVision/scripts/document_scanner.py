import cv2
import numpy as np
from skimage.filters import threshold_adaptive
import imutils

from helper_files import cv_utils


image = cv2.imread("../resources/images/whole shop bill.jpg")
# image = imutils.resize(image,width=300, height=500)
# cv2.imshow("original", image)
# cv2.waitKey(0)
print(image.shape)
# ratio = image.shape[0]/500
orig = image.copy()
# image = imutils.resize(image, height=500)

img_gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
img_blur = cv2.GaussianBlur(img_gray, (3,3), 0)
edged = cv2.Canny(img_blur, 60, 200)

# cv2.imshow("edged", edged)
# cv2.waitKey(0)
# cv2.destroyAllWindows()

cnts = cv2.findContours(edged.copy(), cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)
cnts = imutils.grab_contours(cnts)
cnts = sorted(cnts, key=cv2.contourArea, reverse=True)[:5]

screenCont = None

for c in cnts:
    peri = cv2.arcLength(c, True)
    approx = cv2.approxPolyDP(c, 0.04*peri, True)
    print(len(approx))
    if len(approx) == 4 :
        print(type(approx))
        screenCont = approx
        break

cv2.drawContours(image, [screenCont], -1, (0,0,255), 2)
cv2.waitKey(0)
cv2.destroyAllWindows()

cv2.imshow("contour", image)
warped = cv_utils.four_point_transform1(orig, screenCont.reshape(4,2))

warped = cv2.cvtColor(warped, cv2.COLOR_BGR2GRAY)

warped = cv2.adaptiveThreshold(warped,
                               255,
                               cv2.ADAPTIVE_THRESH_GAUSSIAN_C,
                               cv2.THRESH_BINARY,9,6)
# T = threshold_adaptive(warped, 11, offset = 10, method = "gaussian")
# warped = (warped > T).astype("uint8") * 255

cv2.imshow("original", orig)
cv2.imshow("scanned", warped)
cv2.waitKey(0)
cv2.destroyAllWindows()


