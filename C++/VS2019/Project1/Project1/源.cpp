#include<iostream>
#include<vector>
using namespace std;

bool search(vector<int>& nums, int target) {
    if (target >= nums[0]) {
        int i = 0;
        while (i < nums.size() - 1 && nums[i + 1] >= nums[i]) {
            if (target == nums[i]) {
                return true;
            }
            i++;
        }
    }
    else {
        int i = nums.size() - 1;
        nums.push_back(nums[0]);
        while (i >= 0 && nums[i] <= nums[i+1]) {
            if (target == nums[i]) {
                return true;
            }
            i--;
        }
    }
    return false;
}
int main()
{
    vector<int> ivec{ 10, 11, 12 };
    int data[5] = { 1,0,1,1,1 };
    vector<int> nums(data,data+5);
    int target = 0;
    cout << search(nums, target) << endl;
    return 0;
}