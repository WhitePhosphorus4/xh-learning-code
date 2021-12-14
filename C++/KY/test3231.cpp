#include<iostream>
#include<vector>
using namespace std;

int test(vector<int> coins,int amount)
{
        vector<int> f(amount+1);
        vector<int> func(amount+1);
        f[0] = 1;
        func[0] = 0;

        for(int i = 1;i<f.size();i++){
            func[i] = INT_MAX;
            f[i] = 0;
            int count = 0;
            int flag[amount+1] = {0};
            for(int j = 0;j<coins.size();j++){
                if(flag[j]!=0 && flag[coins[j]]!=0 && flag[j] == flag[coins[j]]){
                    continue;
                }
                if(i-coins[j]>=0 && func[i-coins[j]] != INT_MAX){
                    flag[i-coins[j]] = j;
                    f[coins[j]] = j;
                    func[i] = min(func[i],func[i - coins[j]]+1);
                    f[i] += f[i - coins[j]];
                    // if(f[i - coins[j]] != 0){
                    //     count++;
                    // }
                }
            }
            // f[i] += count;
        }
        if(f[amount] == INT_MAX){
            return 0;
        }
        return f[amount];
}

int main()
{
    int amount = 5;
    int a[3] = {1,2,5};
    vector<int> coins(a,a+3);
    int x = test(coins,amount);
    cout<<x<<endl;
    return 0;
}