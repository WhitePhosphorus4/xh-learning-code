#include <iostream>
#include <vector>

using namespace std;

int search(vector<int>& nums, int target) {
    // 二分解法
    if(nums[0]==target){
        return 0;
    }else if(nums.size()==1){
        return -1;
    }
    int low = 0;
    int high = nums.size()-1;
    int mid = 0;
    while(low<=high){
        mid = (low+high)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[high] == target){
            return high;
        }else if(nums[low] == target){
            return low;
        }else if(nums[0]<=nums[mid]){
            // 左半部分有序
            if(target>=nums[0]&&target<nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }else{
            // 右半部分有序
            if(target<=nums[nums.size()-1]&&target>nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    }
    return -1;
}

int main()
{
    vector<int> data {3,1};
    int target = 1;
    // function here
    int a = search(data,target);
    cout<<a<<endl;
    system("pause");
    return 0;
}


