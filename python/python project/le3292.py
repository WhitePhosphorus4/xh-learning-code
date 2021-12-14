import cv2

im = cv2.imread('./imagetest/test.jpg')
h,w = im.shape[:2]
print(h,w)
print(im)

cv2.namedWindow('test',cv2.WINDOW_FREERATIO)
cv2.imshow('test',im)
cv2.waitKey(0)
cv2.destroyAllWindows()
