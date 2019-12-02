import cv2
import imutils

image = cv2.imread("images/extreme_points_input.jpg")

img_gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
img_blur = cv2.GaussianBlur(img_gray, (5,5), 0)

img_thrash = cv2.threshold(img_blur, 60, 255, cv2.THRESH_BINARY)[1]
img_erode = cv2.erode(img_thrash, None, iterations=2)
img_dilate = cv2.dilate(img_erode, None, iterations=2)

cnts = cv2.findContours(img_dilate.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

cnts = imutils.grab_contours(cnts)
c = max(cnts, key=cv2.contourArea)

# numpy.argmin(array, axis = None, out = None)
# Returns indices of the min element of the array in a particular axis.
extLeft = tuple(c[c[:, :, 0].argmin()][0])
extRight = tuple(c[c[:, :, 0].argmax()][0])
extTop = tuple(c[c[:, :, 1].argmin()][0])
extBot = tuple(c[c[:, :, 1].argmax()][0])

# draw the outline of the object, then draw each of the
# extreme points, where the left-most is red, right-most
# is green, top-most is blue, and bottom-most is teal
cv2.drawContours(image, [c], -1, (0, 255, 255), 2)
cv2.circle(image, extLeft, 8, (0, 0, 255), -1)
cv2.circle(image, extRight, 8, (0, 255, 0), -1)
cv2.circle(image, extTop, 8, (255, 0, 0), -1)
cv2.circle(image, extBot, 8, (255, 255, 0), -1)

cv2.imshow("dilate", image)
cv2.waitKey(0)


# cnts:
# [array([[[447, 595]],
#
#        [[446, 596]],
#
#        [[408, 596]], dtype=int32)
#
#
# c:
# [[[181  74]]
#
#  [[180  75]]
#
#  [[179  75]]]
#
#
# c[:, :, 0]:
# [[181]
#  [180]
#  [179]]
#
# c[:, :, 1]:
# [[ 74]
#  [ 75]
#  [ 75]]
#
# c[c[:, :, 0].argmin()	][0]:
# [[ 73 201]]




