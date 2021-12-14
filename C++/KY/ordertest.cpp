#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

static bool cmp(int a,int b){
    return a>b;
}

int main()
{
    // add your code here
    vector<int> temp {3,4,1,7,2,9};
    sort(temp.begin(),temp.end(),cmp);
    for(auto x : temp){
        cout<<x<<endl;
    }
    // for(int i=0;i<temp.size();i++){
    //     cout<<temp[i]<<endl;
    // }
    system("pause");
    return 0;
}
