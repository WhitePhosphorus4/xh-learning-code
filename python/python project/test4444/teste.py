import cv2

img = cv2.imread('./fine.jpg')
h,w = img.shape[:2]
print(h,w)

cv2.namedWindow('test',cv2.WINDOW_NORMAL)
cv2.imshow('test',img)
cv2.waitKey(0)
cv2.destroyAllWindows()