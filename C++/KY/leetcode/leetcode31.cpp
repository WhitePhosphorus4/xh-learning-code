#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int func(vector<int> &nums,int n)
{
    // code here
    int maxsize = nums.size()-1;
    int i = maxsize-1;
    int j = maxsize;
    int flag = 0;
    // 循环寻找主元素
    while(i>=0){
        if(nums[i]<nums[i+1]){
            flag = 1;
            break;
        }
        i--;
    }
    if(flag == 0){
        sort(nums.begin(),nums.end());
    }else{
        while(j>=0){
            if(nums[i]<nums[j]){
                break;
            }
            j--;
        }
        // 交换
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        // 升序排列，注意，这个要求是交换的左指针的右边一位进行排列，否则将会无效化算法
        sort(nums.begin()+i+1,nums.end());
    }

}

int main()
{
    vector<int> data {1,2,3};
    int n = 0;
    // function here
    int ret = func(data,n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
