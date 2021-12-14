#include<iostream>
using namespace std;

// 实现计算C++中一个接口被重载的次数
// 原理是根据派生类每次继承接口后都会调用一次接口类构造函数
// 因此定义一个静态成员变量，在接口类的构造函数中进行自增

class A {
    public:
        virtual void f(int a) = 0;
        virtual ~A() {}
        A()
        {
            count++;
        }
        static void outcount()
        {
            cout << count << endl;
        }
        static int getcount()
        {
            return count;
        }
        static int count;
};

// 类静态成员变量必须在类外分配内存空间
int A::count = 0;

class B : public A 
{
    public:
        void f(int a)
        {
            cout << "B" << endl;
        }
};

class C : public A 
{
    public:
        void f(int a)
        {
            cout << "C" << endl;
        }
};


int main()
{
    cout << A::count << endl;
    int x = 0;
    B b;
    b.f(x);
    b.outcount();
    C c;
    c.f(x);
    c.outcount();

    return 0;
}