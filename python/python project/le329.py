# 依次输出文件夹中的所有图片

import cv2
import os
import time
#  查看openCV版本号
# print(cv2.__version__)

path = './imagetest/'

imagelist = os.listdir(path)

for imname in imagelist:
    if(imname.endswith('.jpg') or imname.endswith('.JPG')):
        image = cv2.imread(path + imname)
        #  WINDOW_NOMAL参数用于表示窗口大小可自动调节
        # 默认参数为WINDOW_AUTOSIZE,表示窗口自适应图片大小
        cv2.namedWindow('test',cv2.WINDOW_GUI_NORMAL)   
        # cv2.imshow('test-' + imname,image)
        cv2.imshow('test',image)
        # time.sleep(1)
        # 等待命令，k获取的是按下的键值，27为“ESC”
        k = cv2.waitKey(0)
        if k == 27:
            break

cv2.destroyAllWindows()

