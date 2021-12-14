import java.util.Scanner;
import java.math.BigInteger;

//超长整数操作 BigInteger类
public class lab3_1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BigInteger A=new BigInteger(sc.nextLine());
        BigInteger B=new BigInteger(sc.nextLine());
        System.out.println(A.subtract(B));
    }
}