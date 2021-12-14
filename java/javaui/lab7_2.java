import java.util.*;
import java.io.*;

public class lab7_2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int flag=0;
        int ans=0;
        for(int i=1;i<=9;i++)
        {
            for(int j=1;j<=9;j++)
            {
                int AB=j+i*10;
                int BA=i+j*10;
                if(AB*BA==N)
                {
                    flag=1;
                    ans=AB;
                    break;
                }
            }
            if(flag==1)
            {
                break;
            }
        }
        if(flag==1)
        {
            System.out.print(ans);
        }
        else
        {
            System.out.print("No Answer");
        }
    }
}