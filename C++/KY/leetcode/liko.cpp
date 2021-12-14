#include<iostream>
#include<stack>
#include<vector>
using namespace std;



    int findCircleNum(int isConnected[3][3],int size) {
        //邻接矩阵表示法，无向图，问连通分量个数
        int visited[size];
        for(int i=0;i<size;i++){
            visited[i]=0;
        }
        stack<int> s;
        int j=0,rount=0,k;
        while(j<size||rount!=size){
            if(visited[j]==1){
                j++;
                continue;
            }
            s.push(j);
            while(!s.empty()){
                k=s.top();
                s.pop();
                for(int i=0;i<size;i++){
                    if(isConnected[k][i]==1){
                        if(visited[i]==0){
                            visited[i]=1;
                            s.push(i);
                            // cout<<i<<endl;
                        }
                        
                    }
                }
            }
            j++;
            rount++;
            // cout<<rount<<endl;
        }
        return rount;
    }

int main()
{
    int isConnected[3][3] = {1,0,0,
    0,1,0,
    0,0,1};

    int x = findCircleNum(isConnected,3);
    cout<<x<<endl;
    return 0;
}