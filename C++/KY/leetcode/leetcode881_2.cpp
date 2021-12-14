#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int func(vector<int> &people,int limit)
{
    // code here
    int ans = 0;
    sort(people.begin(),people.end());
    int i = 0;  //头指针
    int j = people.size()-1;    //尾指针
    while(i<=j){
        ans++;
        if(people[i] + people[j] <= limit){
            i++;
            j--;
        }
        else{
            j--;
        }
    }
    return ans;
}

int main()
{
    vector<int> data {3,4,5,4};
    int n = 5;
    // function here
    int ret = func(data,n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
