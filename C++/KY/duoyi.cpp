#include<iostream>
#include<vector>
using namespace std;

int main()
{
    int n;
    cin>>n;
    vector<int> x;
    for(int i = 0;i<n;i++){
        int val;
        cin>>val;
        x[i] = val;
    }
    vector<int> sta;
    while(x.size()!=0){
        sta.push_back(x[x.size()-1]);
        x.pop_back();
        cout<<sta[sta.size()-1]<<' ';
        // for(int i = 0;i<)
    }
    return 0;
}