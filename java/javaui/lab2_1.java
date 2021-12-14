import java.util.Scanner;

public class lab2_1{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        long sizeone = sc.nextInt();
        long[] jud = new long[101];
        for(int i=0;i<101;i++)
        {
            jud[i]=0;
        }
        for(int i=0;i<sizeone;i++)
        {
            int ad = sc.nextInt();
            jud[ad]++;
        }
        long sizetwo = sc.nextInt();
        for(int i=0;i<sizetwo;i++)
        {
            int ad = sc.nextInt();
            jud[ad]++;
        }
        for(int i=0;i<101;i++)
        {
            if(jud[i]!=0)
            {
                System.out.print(i+" ");
            }
        }
    }
}