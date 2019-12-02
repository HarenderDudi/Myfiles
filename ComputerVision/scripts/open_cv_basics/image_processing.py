import numpy as np
import cv2
import imutils

# image = cv2.imread("images/images.png")
image = cv2.imread("images/image2.jpeg")
def shift():
    shifted = imutils.translate(image, 20, 50)
    cv2.imshow('shifted', shifted)
    cv2.waitKey(0)

# shift()

def rotation():
    rotated = imutils.rotate(image,180,scale=1)
    imutils.show_image(rotated)

# rotation()

def resize():
    resized = imutils.resize(image, width=image.shape[1]*.5)
    imutils.show_image(resized)

# resize()

# 1 -> horizontal
# 0 -> Vertical
def filp():
    fliped1 = cv2.flip(image, 1)
    fliped0 = cv2.flip(image, 0)
    imutils.show_image(fliped1)
    imutils.show_image(fliped0)

# flip()

# Cropping
def crop():
    cropped = image[0:50, 100:250]
    imutils.show_image(cropped)

crop()
