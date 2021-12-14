import java.util.Scanner;

class Node{
    public int data;
    public Node next = null;
    public Node(final int data){
        this.data = data;
    }
}

//单向链表
public class lab4_3 {
    //建立一个单链表，头名为head
    public static Node head = null;

    //向链表头部插入节点的方法
    public static void addNode(int d){
        //新建一个节点
        final Node newNode = new Node(d);
        //链表为空,将该节点的下一节点设为空
        if(head == null)
        {
            head = newNode;
            head.next = null;
            return;
        }
        //将新节点插入链表头部
        newNode.next = head;
        head = newNode;
    }

    //查询链表长度方法
    public static int length() {
        int length = 0;
        Node tmp = head;
        while (tmp.next != null) 
        {
            length ++;
            tmp = tmp.next;
        }
        return length;
    }

    //删除对应元素
    public static void deleteNode(int data){
        Node tmp = head;
        if(head.data == data)
        {
            head = head.next;
        }
        else
        {
            while (tmp.next.data != data)
            {
                tmp = tmp.next;
            }
            //跳出循环，说明当前节点的后继节点值为所查找的值
            //删除后继节点，即将本节点的后继指向后继节点的后继
            tmp.next = tmp.next.next;
        }
        
    }

    //判断链表是否为空
    public static boolean isEmpty(){
        return null == head ? true : false;
    }

    //打印链表
    public static void printList(){
        Node tmp = head;
        while(tmp != null)
        {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) 
        {
            int s = sc.nextInt();
            if(s == -1) 
            {
                break;  //输入以-1结束
            }
            else 
            {
                addNode(s);
            }
        }
        int t = sc.nextInt();
        deleteNode(t);
        printList();
    }
}
