#include<iostream>
#include<vector>
using namespace std;

// 动态规划解决环问题
// 求任意个X星人手牌数字和的最大值
int max(int a,int b)
{
    if(a>b){
        return a;
    }
    else{
        return b;
    }
}

int sea(vector<int> data,int n,int i,int j,int mi,int sum)
{
    if(i == j){
        return 0;
    }
    if(data[i]<data[j]){
        if(i == mi && j == mi){
            return 0;
        }
        sum -= data[i];
        return max(sea(data,n,(i+1)%n,j,mi,sum),sum);
    }else{
        if(i == mi && j == mi){
            return 0;
        }
        sum -= data[j];
        j--;
        if(j<0){
            j = n-1;
        }
        return max(sea(data,n,i,j,mi,sum),sum);
    }
    return 0;
}

int main()
{
    int n;
    int mi = -1;
    int sum = 0;
    cin>>n;
    vector<int> data;
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        data.push_back(a);
        sum += a;
        if(a<0){
            mi = i;
        }
    }
    for(int i = 0;i<n;i++){
        mi = data[mi]>data[i] ? mi : i;
    }
    cout<<sea(data,n,(mi+1)%n,mi,mi,sum);
    return 0;
}

