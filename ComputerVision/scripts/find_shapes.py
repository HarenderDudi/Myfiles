import cv2
from helper_files import cv_utils

image = cv2.imread("images/shape1.png")

img_gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
img_blurred = cv2.GaussianBlur(img_gray, (7, 7), 0)
img_edged = cv2.Canny(img_blurred, 30, 150)

(_, cntrs, _) = cv2.findContours(img_edged.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

print("I have found %d objects" %(len(cntrs)))

# for c in cntrs:
#     cv2.drawContours(image, [c], -1, (0,0,255), 2)

cv2.drawContours(image, cntrs, -1, (0,0,255), 2)



cv_utils.show_image(image)