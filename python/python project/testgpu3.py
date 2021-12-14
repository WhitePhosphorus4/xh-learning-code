import os
os.environ["TF_CPP_MIN_LOG_LEVEL"]="2"
#上述两行用来取消tensorflow显卡输出日志,要放到开头两行,否则取消显卡日志会失败
import tensorflow as tf
gpuisAvailable=tf.config.list_physical_devices("GPU")
print(gpuisAvailable)