import java.util.Scanner;


//编写一个函数strrindex(s,t)实现String.lastIndexOf(t)的功能。。
public class lab4_4{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();
        int index= strrindex(s, t);
        System.out.println(index);
    }

    public static int strrindex(String s, String t) {
        return s.lastIndexOf(t);
    }
}