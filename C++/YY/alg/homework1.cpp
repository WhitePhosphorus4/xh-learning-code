#include <iostream>
#include <algorithm>
#include <time.h>
#include <vector>

using namespace std;
long times = 0;

/* 
    辗转相除法：O(logn)
    递归表示alg1(m,n) = alg1(n,m%n)
*/
int alg1(int m,int n)
{
    if(m == n){
        return m;
    }
    // lar大，sma小
    int lar = max(m,n);
    int sma = min(m,n);
    int temp = lar%sma;
    while(temp!=0){
        lar = sma;
        sma = temp;
        temp = lar%sma;
        times++;    // 计数器
    }
    return sma;
}

/* 
    暴力法：O(n)
    从1开始遍历到min(n,m)，当发现m和n同时可以整除i时，令ans=i
    如此可以找到能被m和n同时整除的最大整数，即最大公约数
    若未找到，返回1
*/
int alg2(int m,int n)
{
    if(n==m){
        return m;
    }
    int ans = 1;
    for(int i = 1;i<=n;i++){
        if(m%i == 0 && n%i == 0){
            ans = i;
        }
        times++;    // 计数器
    }
    return ans;
}

/*
    辗转相减：O(n)
    用递归表示为alg3(m,n) = alg3(max(n,m-n),min(n,m-n))
*/
int alg3(int m,int n)
{
    // 保证m>n
    if(n>m){
        swap(m,n);
    }
    while(m != n){
        int temp = m - n;
        m = max(temp,n);
        n = min(temp,n);
        times++;    // 计数器
    }
    return m;
}

/*
    调用三个算法：
    sw = 1 ：辗转相除法
    sw = 2 ：暴力解法
    sw = 3 ：辗转相减法 
*/
int gcd(int m,int n,int sw)
{
    if(sw == 1){
        cout<<"algorithm 1"<<endl;
        return alg1(m,n);
    }else if(sw == 2){
        cout<<"algorithm 2"<<endl;
        return alg2(m,n);
    }else if(sw == 3){
        cout<<"algorithm 3"<<endl;
        return alg3(m,n);
    }else{
        return 0;
    }
}

/*
    vector数组求解,以（a，b）形式存放于vector中
*/
int gcd(vector<int> temp,int sw)
{
    if(sw == 1){
        cout<<"algorithm 1"<<endl;
        return alg1(temp[0],temp[1]);
    }else if(sw == 2){
        cout<<"algorithm 2"<<endl;
        return alg2(temp[0],temp[1]);
    }else if(sw == 3){
        cout<<"algorithm 3"<<endl;
        return alg3(temp[0],temp[1]);
    }else{
        return 0;
    }
}

/*
    多数组测试
*/
void gcd(vector<vector<int>> temp,int sw)
{
    if(sw == 1){
        cout<<"algorithm 1"<<endl;
        for(int i = 0;i<temp.size();i++){
            alg1(temp[i][0],temp[i][1]);
        }
    }else if(sw == 2){
        cout<<"algorithm 2"<<endl;
        for(int i = 0;i<temp.size();i++){
            alg2(temp[i][0],temp[i][1]);
        }
    }else if(sw == 3){
        cout<<"algorithm 3"<<endl;
        for(int i = 0;i<temp.size();i++){
            alg3(temp[i][0],temp[i][1]);
        }
    }

}

/* 
    产生n个测试数组
*/
vector<vector<int>> creat_test_data(int n)
{
    vector<vector<int>> test;
    for(int i=0;i<n;i++){
        vector<int> temp {rand()%1000+1,rand()%1000+1};   // 其实也可以手动处理0值，但这里直接给他避免了
        test.push_back(temp);
    }
    return test;
}

/*
    函数入口
*/
int main()
{
    // add your code here
    int a = 1000000;
    int b = 2132343;
    // cin>>a>>b;
    vector<int> data {a,b};
    vector<vector<int>> test_data = creat_test_data(100000);
    clock_t start,end;
    
    for(int i = 1;i<=3;i++){
        cout<<"---------------------"<<endl;
        times = 0;
        start = clock();
        // int ans = gcd(a,b,i);    // 双输入测试
        // int ans = gcd(data,i);   // vector单数组测试
        gcd(test_data,i);   // 多数据测试
        end = clock() - start;
        float tim = ((float)end)/CLOCKS_PER_SEC;

        // cout<<"result : "<<ans<<endl;
        cout<<"spend time : "<<tim<<"s"<<endl;  // 计时法结果
        cout<<"times : "<<times<<endl;  // 计数法结果
    }

    system("pause");
    return 0;
}
