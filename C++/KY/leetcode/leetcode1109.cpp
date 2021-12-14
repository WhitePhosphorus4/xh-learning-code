#include <iostream>
#include <vector>

using namespace std;

vector<int> func(vector<vector<int>> &bookings,int n)
{
    // code here
    vector<int> sub(n+1,0);
    for(auto op : bookings){
        sub[op[0]-1] += op[2];
        sub[op[1]] -= op[2];
    }
    int temp = 0;
    vector<int> ans;
    for(auto x : sub){
        temp += x;
        ans.push_back(temp);
    }
    ans.pop_back();
    return ans;
}


int main()
{
    vector<vector<int>> data;
    data.push_back({1,2,10});
    data.push_back({2,3,20});
    data.push_back({2,5,25});
    int n = 5;
    // function here
    vector<int> ret = func(data,n);
    for(int x : ret){
        cout<<x<<endl;
    }
    // cout<<ret<<endl;
    system("pause");
    return 0;
}
