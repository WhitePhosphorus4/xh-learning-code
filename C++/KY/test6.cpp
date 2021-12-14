#include <iostream>
#include <vector>

using namespace std;

class test
{
    public:
        test* next[26];
};

int main()
{
    // add your code here
    test t;
    if(t.next[0]==NULL){
        cout<<"true"<<endl;
    }
    else{
        cout<<"false"<<endl;
    }
    system("pause");
    return 0;
}
