#include <iostream>
#include <vector>

using namespace std;

int func(string haystack,string needle)
{
    // code here
    int n1 = haystack.size();
    int n2 = needle.size();
    if(n2>n1){
        return -1;
    }
    if(n2 == 0){
        return 0;
    }
    int i = 0;
    for(i = 0;i<=n1-n2;i++){
        int j = i;
        while((j-i) < n2){
            if(haystack[j]!=needle[j-i]){
                break;
            }
            j++;
        }
        if(j == n2 + i){
            return i;
        }
    }
    if(i >n1-n2){
        return -1;
    }else{
        return i-1;
    }
    return 0;
}

int main()
{
    // vector<int> data {};
    // int n = 0;
    string haystack = "aaaaa";
    string needle = "bba";
    // function here
    int ret = func(haystack,needle);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
