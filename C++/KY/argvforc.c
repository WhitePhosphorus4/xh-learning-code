#include<stdio.h>
#include<stdlib.h>
long sb(int);

// C语言使用传入参数进行调用
// 使用vscode调试的话，需要在launch.json的args[]中添加相应的传入参数
int main(int argc,const char *argv[])
{
        int t = 100;
        if(argc > 1){
                for(int i = 1;i<argc;i++){
                        t = atoi(argv[i]);
                        printf("%d\n",sb(t));
                }
        }else{
                printf("%d\n",sb(t));
        }
        return 0;
}

long sb(int n)
{
        int i = 1;
        long sum = 0;
        for(i = 1;i<=n;i++){
                sum += i;
        }
        return sum;
}