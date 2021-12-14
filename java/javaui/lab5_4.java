import java.util.*;

public class lab5_4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //键入数组
        int N=sc.nextInt();
        int dataN[][]=new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                dataN[i][j]=sc.nextInt();
            }
        }
        int M=sc.nextInt();
        int dataM[][]=new int[M][M];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<M;j++)
            {
                dataM[i][j]=sc.nextInt();
            }
        }
        //search
        int marki=0;
        int markj=0;
        int flag=0;
        for(int i=0;i<=N-M;i++)
        {
            for(int j=0;j<=N-M;j++)
            {
                if(dataN[i][j]==dataM[0][0])
                {
                    flag=1;
                    marki=i+1;
                    markj=j+1;
                    for(int a=0;a<M;a++)
                    {
                        for(int b=0;b<M;b++)
                        {
                            if(dataN[i+a][j+b]!=dataM[a][b])
                            {
                                flag=0;
                                break;
                            }
                        }
                        if(flag==0)
                        {
                            break;
                        }
                    }
                }
                if(flag==1)
                {
                    break;
                }
            }
            if(flag==1)
            {
                break;
            }
        }
        //print
        if(flag==0)
        {
            System.out.print(-1);
        }
        else
        {
            System.out.print(marki+","+markj);
        }
        
    }
}