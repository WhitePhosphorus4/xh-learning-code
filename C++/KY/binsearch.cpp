#include<iostream>
#include<vector>
using namespace std;

//二分查找代码模板

int binsearch(vector<int> &data,int key)
{
    int low = 0;
    int high = data.size()-1;
    int mid = 0;
    while(high>=low){
        mid = (high+low)/2;
        if(data[mid] == key){
            return mid;
        }else if(data[mid] < key){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
    }
    return -1;
}

int main()
{
    vector<int> data;
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int x;
        cin>>x;
        data.push_back(x);
    }
    int key;
    cin>>key;
    int index = binsearch(data,key);
    cout<<index<<endl;
    system("pause");
    return 0;
}