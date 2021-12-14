#include<iostream>
#include<vector>
using namespace std;


int main()
{
    int n;
    cin>>n;
    vector<int> mount;
    int sum = 0;
    int count = 0;
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        sum += a;
        mount.push_back(a);
    }
    float avg = (float)sum/(float)n;
    for(int i=0;i<n;i++){
        if(avg>mount[i]){
            count++;
        }
    }
    cout<<count;
    return 0;
}