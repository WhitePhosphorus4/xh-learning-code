#include <iostream>
#include <vector>
#include <stack>
#include <unordered_map>

using namespace std;

// 测试一下map

int main()
{
    // add your code here
    unordered_map<char, char> pairs = {
        {')', '('},
        {']', '['},
        {'}', '{'}
    };
    cout<<pairs['{']<<endl;
    cout<<pairs.size()<<endl;
    pairs.insert({'?','!'});
    cout<<pairs['?']<<endl;
    cout<<pairs.size()<<endl;
    system("pause");
    return 0;
}
