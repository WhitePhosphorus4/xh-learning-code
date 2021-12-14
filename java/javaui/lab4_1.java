import java.util.Scanner;

public class lab4_1{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int []A=new int[110];
        int []B=new int[110];
        int []flag=new int[110];
        for(int i=0;i<110;i++)
        {
            //将A与B比较，如果该位不想等则为0
            flag[i]=0;  
        }
        //输入数据个数计数器
        int num=0; 
        //输入数组A
        while(true)
        {
            int s=sc.nextInt();
            if(s==-1)
            {
                break;
            }
            else
            {
                A[num]=s;
                num++;
            }
        }
        //输入数组B
        while(true)
        {
            int s=sc.nextInt();
            if(s==-1)
            {
                break;
            }
            else
            {
                B[num]=s;
                num++;
            }
        }
        //循环位检测
        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num;j++)
            {
                if(flag[i]!=1&&A[i]==B[j])
                {
                    flag[i]=1;
                    break;
                }
            }
        }
        //输出
        for(int i=0;i<num;i++)
        {
            if(flag[i]==0)
            {
                System.out.print(A[i]+" ");
            }
        }
    }
}