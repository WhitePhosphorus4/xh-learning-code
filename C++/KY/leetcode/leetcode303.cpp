#include <iostream>
#include <vector>

using namespace std;

class NumArray {
public:
    // 优化算法，记忆搜索
    vector<int> data;

    NumArray(vector<int>& nums){
        // vector<int> data;
        // 当下标为0的时候，应该返回0，因此手动添加了一个值
        data.push_back(0);
        for(int i = 0;i<nums.size();i++){
            auto it = data.end() - 1;
            int x = *it + nums[i];
            data.push_back(x);
        }
        // this->data.push_back(0);
        // temp.assign(data.begin(),data.end());
    }
    
    int sumRange(int left, int right) {
        // 这里注意越界问题
        // return this->temp[right+1] - this->temp[left];
        return data[right+1] - data[left];
    }
};

int main()
{
    vector<int> data {-2,0,3,-5,2,-1};
    // int n = 0;
    // function here
    // int ret = func(data,n);
    NumArray test(data);
    int ret = test.sumRange(2,5);
    int ret2 = test.sumRange(0,5);
    cout<<ret<<endl;
    cout<<ret2<<endl;
    system("pause");
    return 0;
}
