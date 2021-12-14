#include <iostream>
#include <vector>

using namespace std;

int func(string s)
{
    // code here
    // 状态转移方程 dp[i] = (() ? dp[i-2] : 0) + (() ? dp[i-1] : 0)
    vector<int> dp(s.size()+1);
    dp[0] = 1;
    for(int i = 0;i<s.size();i++){
        int k = (int)(s[i] - '0');
        // int x = (int)(s[i-1] - '0');
        int n = (i==0) ? (int)(s[i] - '0') : ((int)(s[i] - '0') + (int)(s[i-1] - '0')*10);
        if(k!=0){
            dp[i+1] += dp[i];
        }
        if(i>0 && (int)(s[i-1] - '0')!=0 && n<=26){
            dp[i+1] += dp[i-1];
        }
    }
    return dp[s.size()];
}

int main()
{
    // vector<int> data {};
    // int n = 0;
    string s = "28";
    // function here
    int ret = func(s);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
