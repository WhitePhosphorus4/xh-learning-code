#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>

void* child(void *arg){
    printf("hello,I am th %1d\n",*(int*)arg);
    int sum = 123;
    pthread_exit((void*)sum); 
}

int main(int argc,const char *argv[])
{
    int num = atoi(argv[1]);    // 线程数
    int thread_id[num];
    pthread_t tid[num];
    void *back; //按我理解，这个操作相当于初始化一个空间，用于存放返回值本身（而不是它的地址）
    int i,result = 0;
    long long ans = 0;
    for(int i = 0;i<num;i++){
        thread_id[i] = i;
        result = pthread_create(&tid[i],NULL,child,&thread_id[i]);
    }
    for(int i = 0;i<num;i++){
        pthread_join(tid[i],&back); // 第二个参数为二级指针，表示指针指向位置的值，进行转换时返回的为正常的返回值
        ans = ans + (long long)back;    // void*好像只能转long long，不然会报丢失精度的错误
        // ans = ans + temp;
    }   
    printf("the sum is : %d\n",ans);
    printf("clc th exit\n");
    return 0;
}