#include <iostream>
#include <vector>

using namespace std;

int func(vector<int> &parents)
{
    // code here
    int n = parents.size();
    vector<int> child(n,1); // 存放i节点拥有子树的数量
    for(int x = 0;x<n;x++){
        // 对于一个节点，他的每一个父节点的子树节点数都要+1
        int p = x;
        while(p != -1){
            child[parents[p]] ++;
            p = parents[p];
        }
    }
    // 统计删去每个节点后的得分
    vector<int> score(n,1);
    for(int i = 0;i<n;i++){
        int temp = 0;
        for(int j = 0 ;j<n;j++){
            if(parents[j] == i){
                score[i] *= child[j];
                temp += child[j];
            }
        }
        int k = n - temp - 1;
        if(k!=0){
            score[i] *= k;
        }
    }
    int max = INT_MIN;
    for(auto x : score){
        max = x>max ? x : max;
    }
    int count = 0;
    for(auto x : score){
        // cout<<x<<endl;
        if(x == max){
            count++;
        }
    }
    return count;
}

int main()
{
    vector<int> data {-1,2,0,2,0};
    int n = 0;
    // function here
    int ret = func(data);
    cout<<ret<<endl;
    system("pause");
    return 0;
}
