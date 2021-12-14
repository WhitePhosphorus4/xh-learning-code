import java.util.Scanner;

//实现全排列
public class lab6_1{

    //递归
    public static void resu(int[]data,int i,int N){  
        if(data==null||i<0 ||i>data.length)
        {
            return;  
        }
        
        if(i==data.length-1)
        {
            prin(data,N);
        }
        else
        {  
            for(int j=i;j<data.length;j++)
            {
                int temp=data[j];
                data[j]=data[i];  
                data[i]=temp;  
                resu(data,i+1,N);
                temp=data[j];  
                data[j]=data[i];  
                data[i]=temp;  
            }   
        }  
    }  

    public static void prin(int[] data,int N){
        for(int i=0;i<N;i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.print("\n");
    }

    //迭代回溯
    public static void back(int N){
        int k=0;
        int []data=new int[N];
        int count=0;
        while (k>=0) 
        {
            while(k<N&&data[k]<N)
            {
                data[k]=data[k]+1;
                if(jud(data,k,data[k]))
                {
                    if(k==N-1)
                    {
                        prin(data,N);
                        count++;
                        break;
                    }
                    else
                    {
                        k++;
                    }
                }
            }
            data[k]=0;
            --k;
        }   
    }

    //判断两元素是否相等
    public static boolean jud(int[] a, int k, int n) {
        for (int i = 0; i < k; i++) {
            if (a[i] == n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        // int data[]=new int[N];
        // for(int i=0;i<N;i++)
        // {
        //     data[i]=i+1;
        // }
        // resu(data,0,N);
        back(N);
    }
}




