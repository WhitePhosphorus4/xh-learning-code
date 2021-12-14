#include<iostream>
using namespace std;

#define product(x)((x)*(x))

int main()
{
    int i = 3;
    int j,k;
    j = product(i++);
    k = product(++i);
    cout<<j<<endl<<k;
    return 0;
}