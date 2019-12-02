from imutils.video import VideoStream
import argparse
import datetime
import imutils
import time
import cv2

from videos.modules import KeyClipWriter

vs = VideoStream().start()
green_lower = (29,86,6)
green_upper = (64, 255, 255)

kcw = KeyClipWriter(bufSize=32)
consecFrames = 0

while True:
    frame = vs.read()
    frame = imutils.resize(frame, width=600)
    updateConsecFrames = True

    blurred = cv2.GaussianBlur(frame, (11, 11), 0)
    hsv = cv2.cvtColor(blurred, cv2.COLOR_BGR2HSV)

    # construct a mask for the color "green", then perform
    # a series of dilations and erosions to remove any small
    # blobs left in the mask
    mask = cv2.inRange(hsv, green_lower, green_upper)
    mask = cv2.erode(mask, None, iterations=2)
    mask = cv2.dilate(mask, None, iterations=2)

    # find contours in the mask
    cnts = cv2.findContours(mask.copy(), cv2.RETR_EXTERNAL,
                            cv2.CHAIN_APPROX_SIMPLE)
    cnts = imutils.grab_contours(cnts)

    # only proceed if at least one contour was found
    if len(cnts) > 0:
        # find the largest contour in the mask, then use it
        # to compute the minimum enclosing circle
        c = max(cnts, key=cv2.contourArea)
        ((x, y), radius) = cv2.minEnclosingCircle(c)
        updateConsecFrames = radius <= 10

        # only proceed if the redius meets a minimum size
        if radius > 10:
            # reset the number of consecutive frames with
            # *no* action to zero and draw the circle
            # surrounding the object
            consecFrames = 0
            cv2.circle(frame, (int(x), int(y)), int(radius),
                       (0, 0, 255), 2)

            # if we are not already recording, start recording
            if not kcw.recording:
                timestamp = datetime.datetime.now()
                p = "{}/{}.avi".format("output",
                                       timestamp.strftime("%Y%m%d-%H%M%S"))
                kcw.start(p, cv2.VideoWriter_fourcc("MJPG"),20)

    if updateConsecFrames:
        consecFrames += 1

        # update the key frame clip buffer
    kcw.update(frame)

    # if we are recording and reached a threshold on consecutive
    # number of frames with no action, stop recording the clip
    if kcw.recording and consecFrames == 32:
        kcw.finish()

    # show the frame
    cv2.imshow("Frame", frame)
    key = cv2.waitKey(1) & 0xFF

    # if the `q` key was pressed, break from the loop
    if key == ord("q"):
        break

    if kcw.recording:
        kcw.finish()

    # do a bit of cleanup
    cv2.destroyAllWindows()
    vs.stop()