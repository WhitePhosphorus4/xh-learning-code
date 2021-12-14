#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int xcha(int x)
{
    string str = to_string(x);
    if(x<0){
        str.erase(str.begin());
        str.push_back('-');
    }
    reverse(str.begin(),str.end());
    // cout<<str<<endl;
    int y = atof(str.c_str());
    // cout<<y<<endl;
    return (y>=INT_MAX||y<=INT_MIN) ? 0 : y;
}

int reint(int x)
{
    double n = 0;
    while(x){
        n = n*10 + x%10;
        x /= 10;
    }
    return (n>INT_MAX||n<INT_MIN) ? 0 : n;
}

// 暴力string反转完成整数反转
int main()
{
    // add your code here
    int x = 1534236469;
    cout<<xcha(x)<<endl;
    cout<<reint(x)<<endl;
    system("pause");
    return 0;
}
