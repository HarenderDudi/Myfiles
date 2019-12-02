import numpy as np
import cv2
import imutils

image = cv2.imread("images/color_detection_pokemon.jpeg")

boundaries = [
              ([10,10,100],[70,70,255]),
              ([80,30,5],[250,70,50]),
              ([20,140,180],[100,205,255]),
              ([70,60,60],[150,130,130])
             ]

imagestack = []

for (lower, upper) in boundaries:

    lower = np.array(lower, dtype="uint8")
    upper = np.array(upper, dtype="uint8")

    mask = cv2.inRange(image, lower, upper)
    # imagestack.append(mask)
    output = cv2.bitwise_and(image, image, mask=mask)
    imagestack.append(output)
    # cv2.imshow("img", output)
    # cv2.waitKey(0)

# cv2.imshow("img", np.hstack(imagestack))
# cv2.waitKey(0)

montages = imutils.build_montages(imagestack, (150,150),(2,2))

for montage in montages:
    print("---")
    cv2.imshow("montage", montage)
    cv2.waitKey(0)