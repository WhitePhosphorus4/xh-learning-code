#include <iostream>
#include <vector>

using namespace std;

// 丑数问题，动态规划解法

int func(int n)
{
    // code here
    vector<int> dp(n+1);
    // int dp[n+1];
    dp[1] = 1;
    int p2 = 1;
    int p3 = 1;
    int p5 = 1;
    for(int i = 2;i <= n;i++){
        int num2 = dp[p2]*2;
        int num3 = dp[p3]*3;
        int num5 = dp[p5]*5;
        dp[i] = min(min(num2,num3),num5);
        if(dp[i] == num2){
            p2++;
        }
        if(dp[i] == num3){
            p3++;
        }
        if(dp[i] == num5){
            p5++;
        }
    }
    return dp[n];
}

int main()
{
    // vector<int> data {};
    // int n = 10;
    int n;
    cin>>n;
    // function here
    int ret = func(n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
