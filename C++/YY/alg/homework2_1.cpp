#include <iostream>
#include <vector>
#include <string>
using namespace std;

// 哈夫曼树类
class HTree
{
private:
    HTree* Lchild;  // 左子
    HTree* Rchild;  // 右子
    int val;    // 权重
    char data;  // 节点名称
    int index;  // 索引
public:
    HTree();
    HTree(int weight,char data,int index);
    HTree(int weight,HTree *Lchild,HTree *Rchild);
    ~HTree();

    void setLchild(HTree* L){this->Lchild = L;}
    void setRchild(HTree* R){this->Rchild = R;}
    HTree* getLchild(){return this->Lchild;}
    HTree* getRchild(){return this->Rchild;}
    int getval(){return this->val;}
    int getindex(){return this->index;}
};

HTree::HTree()
{
}

// 叶子节点的构造函数
// 自定义的判别方法： index != -1
HTree::HTree(int weight,char data,int index)
{
    Lchild = NULL;
    Rchild = NULL;
    val = weight;
    this->data = data;
    this->index = index;
}

// 树枝节点的构造函数
// 自定义的判别方法： index = -1
HTree::HTree(int weight,HTree *Lchild,HTree *Rchild)
{
    this->Lchild = Lchild;
    this->Rchild = Rchild;
    val = weight;
    this->data = '0';
    this->index = -1;
}

HTree::~HTree()
{
}

// 创建初始节点表，返回一个vector
vector<HTree*> createNode(vector<int> weight,vector<char> data)
{
    int n = weight.size();
    vector<HTree*> temp;
    for(int i = 0;i<n;i++){
        HTree* tempTree = new HTree(weight[i],data[i],i);
        temp.push_back(tempTree);
    }
    return temp;
}

// 使用贪心算法，构建哈夫曼树.
// weight：权重 ；  data：节点
HTree* createHtree(vector<int> weight,vector<char> data)
{
    // 节点数量小于3的时候，求解哈夫曼树没有意义，返回NULL
    if(weight.size() < 3){
        return NULL;
    }
    vector<HTree*> temp = createNode(weight,data);
    // 循环，贪心求解
    while(temp.size() != 1){
        // 遍历temp，找到值最小的两个节点first,second
        vector<HTree*>::iterator first = temp.begin();
        vector<HTree*>::iterator second = temp.begin()+1;
        for(vector<HTree*>::iterator i = temp.begin()+2 ; i!=temp.end() ; i++){
            // 确保first指向两个节点中的最大值
            if((*first)->getval() < (*second)->getval()){
                auto temp = first;
                first = second;
                second = temp;
            }
            if((*i)->getval() < (*first)->getval()){
                first = i;
            }
        }
        // 创建这两个节点的父节点，加入temp中，并从temp中删除这两个节点
        int total = (*first)->getval() + (*second)->getval();
        HTree* tempnode = new HTree(total,*first,*second);
        // 这个erase()必须先删后面的，不然这个下标会变
        if(first < second){
            temp.erase(second);
            temp.erase(first);
        }else{
            temp.erase(first);
            temp.erase(second);
        }
        temp.push_back(tempnode);
    }
    return temp[0];
}

// 前序遍历，向左为1向右为0
// 遍历到叶子结点的时候，更新对应的哈夫曼编码值
void HcodeOutput(HTree* T,vector<string> &Hcode,string tcode)
{
    if(T == NULL){
        return;
    }
    if(T->getindex() != -1){    
        // 判断是叶子节点，则更新对应的哈夫曼编码值，然后返回
        Hcode[T->getindex()] = tcode;
        return;
    }

    HcodeOutput(T->getLchild(),Hcode,tcode + '1');
    HcodeOutput(T->getRchild(),Hcode,tcode + '0');
}

int main()
{
    // add your code here
    vector<char> data {'a','b','c','d','e','f'};
    vector<int> weight {10,20,30,40,50,60};
    // vector<char> data {'a','b','c','d','e'};
    // vector<int> weight {5,4,3,2,1};
    HTree* T = createHtree(weight,data);
    vector<string> Hcode (data.size()); //存储哈夫曼编码
    HcodeOutput(T,Hcode,"");
    cout<<"-----------Huffman Code-----------"<<endl;
    for(int i=0;i<data.size();i++){
        cout<<"Node "<<data[i]<<" could be decode as : "<<Hcode[i]<<endl;
    }
    system("pause");
    return 0;
}
