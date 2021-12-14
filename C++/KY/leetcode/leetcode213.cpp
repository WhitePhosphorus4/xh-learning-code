#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int func(vector<int> &nums)
{
    // code here
        int n = nums.size();
    if(n <= 3){
        nums.push_back(nums[0]);
        nums.push_back(nums[0]);
        return max(nums[0],max(nums[1],nums[2]));
    }
    vector<int> dp(n);
    dp[0] = nums[0];
    dp[1] = nums[1];
    // dp[2] = nums[2];
    for(int i = 2;i<nums.size();i++){
        if(i == 4){
            dp[i] = max(max(dp[0],dp[1]),dp[2]) + nums[i];
        }else{
            dp[i] = max(((i - 2 >= 0) ? dp[i-2] : 0) + nums[i],dp[i-1]);
        }
    }
    if(n%2 == 0){
        return max(dp[n-1],dp[n-2]);
    }else{
        return max(max(dp[n-1]-nums[n-1],dp[n-1]-nums[0]),dp[n-2]);
    }
    // return max(dp[n-1],dp[n-2]);
    return 0;
}

int main()
{
    vector<int> data {200,3,140,20,10};
    // int n = 0;
    // function here
    int ret = func(data);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
