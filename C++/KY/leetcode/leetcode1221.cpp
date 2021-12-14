#include <iostream>
#include <vector>

using namespace std;

int func(string s)
{
    // code here
    if(s.size()<2){
        return 0;
    }
    int ans = 0;
    int n = s.size();
    int CL = 0;
    int CR = 0;
    int i = 0;
    while(i<n){
        if(s[i] == 'L'){
            CL++;
        }else{
            CR++;
        }
        if(CL==CR){
            CL=0;
            CR=0;
            ans++;
            i++;
            continue;
        }
        i++;
    }
    return ans;
}

int main()
{
    vector<int> data {};
    string s = "LR";
    int n = 0;
    // function here
    int ret = func(s);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
