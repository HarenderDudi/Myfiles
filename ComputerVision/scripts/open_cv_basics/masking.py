import numpy as np
import cv2
import imutils

image = cv2.imread("images/image2.jpeg")
print(image.shape)
mask = np.zeros(image.shape[:2], dtype="uint8")
cv2.rectangle(mask, (130,0),(217,70),255,-1)

masked = cv2.bitwise_and(image, image, mask=mask)
imutils.show_image(masked)