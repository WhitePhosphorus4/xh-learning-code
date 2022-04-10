# env description

## USE
```bash
conda info --envs	// 查看所有虚拟环境
conda activate <环境名称>	// 激活环境
conda create -n <名称>	// 创建环境
conda create -n <名称> --clone <已有环境名称> // 拷贝环境，其实是以现有环境内容创建一个新环境
conda remove -n <名称> --all	// 删除环境
conda remove -n <环境名称> <包名>	// 删除环境中的特定包
conda env remove -n <环境名称> 	// 如果上一条报错，采用这个格式
conda env remove -p <环境位置>	// 如果创建环境时未指定名称，则采用此格式
```

## base

normal env



## TEST

- openCV
- pyqt5
- pytorch1.8.1+cpu



## testkeras

- tensorflow - gpu
- keras



## evnforpy2

> I don't know why I created this...

- python 2.8



## torch17

- pytorch1.7.0



## torch180

- pytorch1.8.0



## torch190

- pytorch1.9.1



## torch-graph

- pytorch1.7.0
- 图神经网络的相关包
- ogb1.3.2