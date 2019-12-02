import numpy as np
import cv2
import imutils

image = cv2.imread("images/image2.jpeg")
image = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)

def laplacian():
    lap = cv2.Laplacian(image,cv2.CV_64F)
    lap = np.uint8(np.absolute(lap))
    cv2.imshow("Laplacian",lap)
    cv2.waitKey(0)

def sobel():
    sobelX = cv2.Sobel(image, cv2.CV_64F, 1, 0)
    sobelY = cv2.Sobel(image, cv2.CV_64F, 0, 1)

    sobelX = np.uint8(np.absolute(sobelX))
    sobelY = np.uint8(np.absolute(sobelY))

    sobelCombined = cv2.bitwise_or(sobelX, sobelY)
    cv2.imshow("Sobel", sobelCombined)
    cv2.waitKey(0)

def canny():
    imageBlurred = cv2.GaussianBlur(image, (5,5), 0)
    canny = cv2.Canny(imageBlurred, 150,200)
    cv2.imshow("Canny", canny)
    cv2.waitKey(0)

laplacian()
sobel()
canny()