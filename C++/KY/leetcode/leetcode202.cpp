#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 快慢指针解决快乐数问题

int happy(int n)
{
    int num = 0;
    while(n>0){
        int dig = n%10;
        num += pow(dig,2);
        n /= 10;
    }
    return num;
}

int func(int n)
{
    // code here
    int slow = n;
    int fast = happy(n);
    while(slow != fast){
        slow = happy(slow);
        fast = happy(happy(fast));
    }
    return slow == 1;
}

int main()
{
    // vector<int> data {};
    int n;
    cin>>n;
    // function here
    int ret = func(n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
