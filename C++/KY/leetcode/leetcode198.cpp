#include <iostream>
#include <vector>

using namespace std;

int func(vector<int> &nums)
{
    // code here
    /* 状态转移方程为
       dp[i] = max(dp[i-1],nums[i] + dp[i-2])
    */
    int n = nums.size();
    vector<int> dp(n);
    for(int i = 0;i<n;i++){
        if(i<2){
            dp[i] = nums[i];
        }else{
            dp[i] = max(dp[i-1],nums[i] + dp[i-2]);
        }
    }
    return dp[n-1];
}

int main()
{
    vector<int> data {1,2,3,1};
    // int n = 0;
    // function here
    int ret = func(data);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
