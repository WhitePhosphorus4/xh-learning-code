import java.util.*;

class Student{
    public int number;
    public String name;
    public int age;

    public Student(int number,String name,int age)
    {
        this.number=number;
        this.name=name;
        this.age=age;
    }

    public void outprint()
    {
        System.out.printf("%3d",this.number);
        System.out.printf("%6s",this.name);
        System.out.printf("%3d",this.age);
    }
}

public class lab6_2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        Student data[]=new Student[N];
        int orderone[]=new int[N];
        int ordertwo[]=new int[N];
        for(int i=0;i<N;i++)
        {
            orderone[i]=i;
            ordertwo[i]=i;
        }
        //输入数据
        int nu=0;
        String na=null;
        int age=0;
        for(int i=0;i<N;i++)
        {
            nu=sc.nextInt();
            na=sc.next();
            age=sc.nextInt();
            data[i]=new Student(nu,na,age);
        }
        //姓名排序
        String minname="zzzzzzzzzz";
        int minindex=N-1;
        int flag=0;
        for(int i=0;i<N-1;i++)
        {
            for(int j=N-1;j>=i;j--)
            {
                if(data[orderone[j]].name.compareTo(minname)<0)
                {
                    minname=data[orderone[j]].name;
                    minindex=j;
                    flag=1;
                }
            }
            if(flag==1)
            {
                flag=0;
                int xx=orderone[i];
                orderone[i]=orderone[minindex];
                orderone[minindex]=xx;
                minname="zzzzzzzzzz";
                minindex=N-1;
            }
        }
        //年龄排序
        //在姓名排序完成的基础上进行年龄排序，使用一个稳定的排序算法
        for(int i=0;i<N;i++)
        {
            ordertwo[i]=orderone[i];
        }
        int maxage=0;
        for(int i=0;i<N-1;i++)
        {
            if(data[i].age>maxage)
            {
                maxage=data[i].age;
            }
        }
        int min=maxage;
        minindex=N-1;
        flag=0;
        //下面使用了改进的选择排序算法，是稳定的
        for(int i=0;i<N-1;i++)
        {
            for(int j=N-1;j>=i;j--)
            {
                if(data[ordertwo[j]].age<min)
                {
                    min=data[ordertwo[j]].age;
                    minindex=j;
                    flag=1;
                }
            }
            if(flag==1)
            {
                flag=0;
                int xx=ordertwo[i];
                ordertwo[i]=ordertwo[minindex];
                ordertwo[minindex]=xx;
                min=10000;
                minindex=N-1;
            }
        }
        //格式化输出
        for(int i=0;i<N;i++)
        {
            data[orderone[i]].outprint();
            System.out.print("\n");
        }
        System.out.print("\n");
        for(int i=0;i<N;i++)
        {
            data[ordertwo[i]].outprint();
            System.out.print("\n");
        }
    }
}