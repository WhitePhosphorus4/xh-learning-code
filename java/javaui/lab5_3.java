import java.util.Scanner;

public class lab5_3{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        double half=n;
        double total=-n;
        for(int i=0;i<m;i++)
        {
            total+=(double)(2*half);
            half/=(double)4;
        }
        System.out.printf("%.2f\n",total);
        System.out.printf("%.2f\n",half);
    }
}