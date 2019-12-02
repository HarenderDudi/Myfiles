import numpy as np
import cv2
import imutils

image = cv2.imread("images/image2.jpeg")

avgblurred = np.hstack([cv2.blur(image, (3,3)),
                     cv2.blur(image, (5,5)),
                     cv2.blur(image, (7,7))])
cv2.imshow("avgblurred", avgblurred)

gaussianblurred = np.hstack([cv2.GaussianBlur(image, (3,3),0),
                     cv2.GaussianBlur(image, (5,5),0),
                     cv2.GaussianBlur(image, (7,7),0)])
cv2.imshow("Gaussian", gaussianblurred)

medianblurred = np.hstack([cv2.medianBlur(image, 3),
                     cv2.medianBlur(image, 5),
                     cv2.medianBlur(image, 7)])
cv2.imshow("medianblurred", medianblurred)
cv2.waitKey(0)

