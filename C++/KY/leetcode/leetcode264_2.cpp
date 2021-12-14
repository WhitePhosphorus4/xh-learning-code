#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

// 丑数问题，小根堆+set解法
// 学习 ： set ,priority_queue ,auto

int func(int n)
{
    // code here
    int fec[3] = {2,3,5};
    int answer = 1;
    priority_queue<double,vector<double>,greater<double>> q;
    set<double> s;
    // 首元素放入容器
    q.push(1);
    s.insert(1);
    // 循环生成丑数，第n论即为结果
    for(int i=0;i<n;i++){
        double temp = q.top();
        q.pop();
        answer = (int)temp;
        for(int x : fec){
            double y = x*temp;
            if(s.count(y)!=1){
                q.push(y);
                s.insert(y);
            }
        }
    }
    return answer;
}

int main()
{
    // vector<int> data {};
    int n = 1407;
    // function here
    int ret = func(n);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
