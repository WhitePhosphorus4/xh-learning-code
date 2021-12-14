#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main()
{
	int num[10],p=0,max=INT_MIN,*q,min=INT_MAX,sum=0;
	srand((int)time(0));
	for (int i = 0; i <= 9; i++)
	{
		p = rand() % 100 + 1;
		printf("%d\t", p);
		num[i] = p;
	}
	q = num+1;
	max = *num;
	for (int n = 0; n <= 9; n++)
		if (*(q + n) >=max)
			max = *(q + n);
	printf("\n最大值是%d\n",max);
	min = *num;
	for (int m = 0; m <= 9; m++)
		if (*(q + m) <= min)
			min = *(q + m);
	printf("最小值是%d\n",min);
	for(int i=0;i<=9;i++)
		sum = sum + *(num+i);
	printf("和为%d", sum);
	return 0;
}
    
