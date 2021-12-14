#include<iostream>
using namespace std;

class A
{
    public:
        int a = 1;
    virtual ~A(){};
};
class B:public A
{
    public:
        int b = 2;
    virtual void fine(){};
};

int main()
{
    // A *tes; //创建一个基类A的对象
    // B *cha1 = static_cast<B*>(tes);
    // B *cha2 = dynamic_cast<B*>(tes);
    // int test1 = cha1->b;
    // int test2 = (cha2==NULL) ? 1 : 0;
    // cout<<test1<<endl<<test2;
    int b = 1;
    const int* a = &b;
    a++;
    int *c = const_cast<int *>(a);
    *c = 100;
    cout<<*c<<endl;
    return 0;
}