#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int func(vector<int> &weights,int D)
{
    // code here
    int n = weights.size();
    int sum = 0;
    for(int x : weights){
        sum += x;
    }
    int avg = sum/D;
    // avg = avg/D;
    int maxi = 0;
    int maxload = avg;
    int day = 0;
    for(int i = 0;i<n;i++){
        int load = 0;
        for(int j = i;j<n;j++){
            load += weights[j];
            if(load>=avg){
                maxload = max(maxload,load);
                i = j;
                break;
            }
        }
        day++;
    }
    return maxload;
}

int main()
{
    vector<int> data {1,2,3,4,5,6,7,8,9,10};
    int n = 5;
    // function here
    int ret = func(data,n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
