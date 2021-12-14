#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 快慢指针

int func(vector<int> &nums)
{
    // code here
    int slow = 0;
    int fast = 0;
    do{
        slow = nums[slow];
        fast = nums[nums[fast]];
    }while(slow != fast);
    slow = 0;
    while(slow != fast){
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
}

int main()
{
    vector<int> data {4,3,1,4,2};
    // int x = 0;
    // function here
    int ret = func(data);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
