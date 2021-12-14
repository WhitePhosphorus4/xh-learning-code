#include <iostream>
#include <vector>
// #include<algorithm>
#include <unordered_map>

using namespace std;

int func(vector<vector<int>> &points,int n)
{
    // code here
    // 计算量两点之间的距离，因为本题只需要返回个数而非回旋镖组，所以可以直接用哈希表存储
    // 算完之后，计算大于0的排列数就行。
    // 这个先用vector模拟哈希表的用法,但这里需要考虑表的最大值，由于存储的是平方数据，因此数据量巨大，很容易直接超时
    // 所以使用哈希表，也就是unordered_map
    int num = points.size();
    int ans = 0;
    for(int i = 0;i<num;i++){
        unordered_map<int,int> hash;
        for(int j = 0;j<num;j++){
            // 因为实际距离没有意义，不用开根号了
            int x = points[i][0] - points[j][0];
            int y = points[i][1] - points[j][1];
            int index = x*x + y*y;
            hash[index]++;
        }
        for(auto x : hash){
            ans += x.second*(x.second-1);
        }
    }
    // 最后再遍历一次这个哈希表，来查找数量大于等于2的值，然后计算数值的全排列
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
