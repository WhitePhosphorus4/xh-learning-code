import java.util.*;

public class lab6_5{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        int sum=x+y+z;
        double avg=(double)sum/(double)3;
        System.out.println(sum);
        System.out.printf("%.2f",avg);
    }
}