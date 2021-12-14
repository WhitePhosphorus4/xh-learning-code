#include <iostream>
#include <vector>

using namespace std;
// 这里构造算法还比较容易写，比较难写的是数据结构
// 在这里，其实很容易直接算出他的长度，但具体结构需要使用树的遍历算法求解



// 习惯以前数据结构的写法了，这里明显用类更好写
typedef struct Htree{
    struct Htree *Lchild,*Rchild;   //左子和右子
    int var;   // 节点权值
}*TreeNode;

TreeNode creatNode(int wieght){
    TreeNode T;
    T->Lchild = NULL;
    T->Rchild = NULL;
    T->var = 
}

void creatHtree(TreeNode T,int n)
{
    // 贪心算法
}

int main()
{
    // add your code here
    vector<char> data {'a','b','c'};
    vector<int> weight {10,20,30};

    system("pause");
    return 0;
}
