#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

// 学习内容: auto ,string ,to_string

static bool cmp(string &a,string &b){
    return a+b > b+a;
}

string func(vector<int> &nums,int x)
{
    // code here
    // 先转换为字符串
    vector<string> temp;
    for(auto x : nums){
        temp.push_back(to_string(x));
    }
    // 然后定义比较函数，并进行比较
    sort(temp.begin(),temp.end(),cmp);
    // 先导0
    if(temp[0]=="0"){
        return string("0");
    }
    // 然后将最后结果转换为字符串，并返回结果
    string answer;
    for(auto x : temp){
        answer += x;
    }
    return answer;

}

int main()
{
    vector<int> data {3,10,478,299,875,0,42};
    int x = 0;
    // function here
    string ret = func(data,x);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
