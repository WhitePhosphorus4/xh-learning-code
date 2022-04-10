#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<time.h>

pthread_mutex_t mutex;
long long sum = 0;

void* cul(void *arg){
    int low = *((int*)arg);
    int high = *((int*)arg +1);
    for(int i = low;i<=high;i++){
        pthread_mutex_lock(&mutex); // 加锁
        sum += i;
        pthread_mutex_unlock(&mutex);   // 解锁
    }
    printf("Add from %d to %d results, now sum = %d\n",low,high,sum);
    pthread_exit(NULL);
}

int main(int argc,const char *argv[])
{
    if(argc<3){
        printf("input error\n");
        return 0;
    }
    pthread_mutex_init(&mutex,NULL);    // 初始化互斥锁

    clock_t start,end;
    start = clock();
    int num = atoi(argv[1]);    // 线程数
    int maxnum = atoi(argv[2]); // 求和最大数
    int thread_id[num];
    int tempinput[num][2];
    int per = maxnum/num + 1;   // 每个线程求和的值
    pthread_t tid[num];         // 创建线程
    int i,result = 0;
    for(int i = 0;i<num;i++){
        thread_id[i] = i;
        tempinput[i][0] = i*per<1 ? 1 : i*per;
        tempinput[i][1] = ((i+1)*per-1)>maxnum ? maxnum : ((i+1)*per-1);
        result = pthread_create(&tid[i],NULL,cul,&tempinput[i]);
    }
    for(int i = 0;i<num;i++){
        pthread_join(tid[i],NULL);
    }
    end = clock();
    printf("The sum is : %d\n",sum);
    printf("Calculate th exit in %fs\n",(double)(end-start));
    pthread_mutex_destroy(&mutex);    // 销毁互斥锁
    return 0;
}