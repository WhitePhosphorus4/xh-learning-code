#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

int main()
{
    int n;
    vector<int> number;
    vector<char> opera;
    cin>>n;
    for(int i=0;i<n;i++){
        int x;
        cin>>x;
        number.push_back(x);
    }

    for(int i=0;i<n-1;i++){
        char x;
        cin>>x;
        opera.push_back(x);
    }
    unordered_map<char,int> test;
    return 0;
}