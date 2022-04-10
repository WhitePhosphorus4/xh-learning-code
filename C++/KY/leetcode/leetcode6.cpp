#include <iostream>
#include <vector>

using namespace std;

string func(string s,int numRows)
{
    // code here
    string ans;
    vector<vector<char>> temp(numRows,vector<char>(0));
    int i = 0;
    while(i < s.length()){
        int j = 0;
        for(j = 0;j<numRows;j++){
            if(i >= s.length()){
                break;
            }
            temp[j].emplace_back(s[i]);
            i++;
        }
        j -= 2;
        if(i >= s.length()){
            break;
        }
        for(;j>0;j--){
            if(i >= s.length()){
                break;
            }
            temp[j].emplace_back(s[i]);
            i++;                
        }
        if(i >= s.length()){
            break;
        }
    }
    for(int k=0;k<numRows;k++){
        string tem;
        tem.assign(temp[k].begin(),temp[k].end());
        cout<<tem<<endl;
        ans += tem;
    }
    return ans;
}

int main()
{
    string data = "PAYPALISHIRING";
    int n = 3;
    // function here
    string ret = func(data,n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
