#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <algorithm>

using namespace std;

// 最长匹配括号问题,我麻了

int func(string s)
{
    // code here
    if(s.size() == 0){
        return 0;
    }
    // 动态规划解法
    int answer = 0;
    int dp[s.size()+1] = {0};
    dp[0] = 0;
    for(int i = 1;i<s.size();i++){
        if(s[i] == ')'){
            if(s[i-1] == '('){
                dp[i] = ((i-2)>0 ? dp[i-2] : 0) + 2;
            }else if((i - dp[i-1] > 0) && (s[i - dp[i-1] - 1] == '(')){
                dp[i] = ((i - dp[i-1] - 2)>=0 ? dp[i - dp[i-1] - 2] : 0)+ dp[i-1] + 2;
            }
            answer = max(answer,dp[i]);
        }else{
            dp[i] = 0;
        }
    }
    return answer;
}

int main()
{
    // vector<int> data {};
    // int n = 0;
    string s = "()(())";
    // function here
    int ret = func(s);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
