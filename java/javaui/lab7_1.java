import java.util.*;


//其实我们很容易直接看出结果。。。
//这里直接使用了我们看出的结果，但实际上，我们也可以通过使用否定式将结果判断出来
public class lab7_1{

    public static int A=0;
    public static int B=0;
    public static int C=0;
    public static int X=0;
    public static int Y=0;
    public static int Z=0;

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        //judge
        jud();
        //output
        String tes=sc.next();
        char sss=tes.toCharArray()[0];
        if(sss=='a')
        {
            System.out.print('z');
        }
        else if(sss=='b')
        {
            System.out.print('x');
        }
        else if(sss=='c')
        {
            System.out.print('y');
        }
        else if(sss=='x')
        {
            System.out.print('b');
        }
        else if(sss=='y')
        {
            System.out.print('c');
        }
        else if(sss=='z')
        {
            System.out.print('a');
        }
    }

    //数字转换
    public static int se(int sd)
    {
        switch (sd)
        {
        case 1:
            return X;
        case 2:
            return Y;
        case 3:
            return Z;
        case 4:
            return A;
        case 5:
            return B;
        case 6:
            return C;
        default:
            return 0;
        }
    }

    //输出转换
    public static char re(int sd)
    {
        switch (sd)
        {
        case 1:
            return 'x';
        case 2:
            return 'y';
        case 3:
            return 'z';
        case 4:
            return 'a';
        case 5:
            return 'b';
        case 6:
            return 'c';
        default:
            return '?';
        }
    }


    public static int cha(int A,int B,int C)
    {
        //先排除题目给出的条件
        if(A==X||C==X||C==Z)
        {
            return 0;
        }
        //然后排除重复的情况
        if(A==B||B==C||A==C)
        {
            return 0;
        }
        //都条件都满足的时候返回1
        return 1;
    }

    public static int jud()
    {
        int A=0,B=0,C=0;
        for(int i=1;i<4;i++)
        {
            for(int j=1;j<4;j++)
            {
                for(int k=1;k<4;k++)
                {
                    A=se(i);
                    B=se(j);
                    C=se(k);
                    if(cha(A,B,C)==1)
                    {
                        return 1;
                    }
                }
            }
        }    
        return 0;
    }

}