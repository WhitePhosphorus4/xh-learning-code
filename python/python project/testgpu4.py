import tensorflow as tf
print(tf.test.is_gpu_available())
gpus = tf.config.experimental.list_physical_devices(device_type='GPU')
cpus = tf.config.experimental.list_physical_devices(device_type='CPU')
print(gpus, cpus)


#打印结果为 
#False   
#[] [PhysicalDevice(name='/physical_device:CPU:0', device_type='CPU')]
