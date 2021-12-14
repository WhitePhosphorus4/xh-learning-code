import java.util.Scanner;

public class lab6_3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=0;
        int base=1;
        int tot=0;
        for(int i=0;i<n;i++)
        {
            tot+=base;
            s+=tot;
            base++;
        }
        n=s;
        System.out.print(n);
    }
}