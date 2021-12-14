import java.util.Scanner;

//输入一个自然数Ｎ（1<N<9），要求输出如下的魔方阵，即边长为2*N-1，Ｎ在中心出现一次，其余位置上的数字从外向中心逐渐增大。
public class lab5_1{
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int size=N*2-1;
        //定义一个输出数组
        int []data=new int[size];
        for(int i=0;i<size;i++)
        {
            data[i]=0;
        }
        //开始输出
        int change=0;
        int fla=1;
        int i=0;
        int j=0;
        int k=0;
        for(i=0;i<size;i++)
        {
            //改变输出数组
            for(j=change;j<size-change;j++)
            {
                data[j]+=fla;
            }
            //打印数据
            for(k=0;k<size;k++)
            {
                System.out.print(data[k]);
            }
            //
            change+=fla;
            if(change==N)
            {
                change--;
                fla=-1;
            }
            //换行
            System.out.print("\n");
        }
    }
}