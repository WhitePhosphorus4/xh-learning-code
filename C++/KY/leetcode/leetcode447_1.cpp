#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int func(vector<vector<int>> &points,int n)
{
    // code here
    int ans = 0;
    for (auto &p : points) {
        unordered_map<int, int> cnt;
        for (auto &q : points) {
            int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
            ++cnt[dis];
        }
        for (auto x : cnt) {
            ans += x.second * (x.second - 1);
        }
    }
    return ans;
}

int main()
{
    vector<vector<int>> data {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
    int n = 0;
    // function here
    int ret = func(data,n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
