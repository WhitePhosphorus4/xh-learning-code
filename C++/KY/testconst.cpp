#include<iostream>
using namespace std;

int main()
{
    int a = 5;
    int b = 20;
    // 常量指针
    int const *p1 = &a;
    const int *p2 = &a;
    // 指针常量
    int * const p3 = &a;
    // 指向常量的指针常量
    const int * const p4 = &a;
    // a=10;   // 可修改

    // p1 = &b;    // 可修改
    // *p1 = 10;   // 不可修改

    // p2 = &b;    // 可修改
    // *p2 = 10;   //不可修改

    // p3 = &b;    // 不可修改
    // *p3 = 10;   // 可修改

    // p4 = &b;    // 不可修改
    // *p4 = 10;   // 不可修改

    cout<<*p3<<endl<<a;
    return 0;
}