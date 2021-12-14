import java.util.Scanner;
import java.io.*;

//串中的字串逆置
public class lab3_4{
    public static void main(String []args)throws FileNotFoundException{
        //输入流类
        Scanner sc=new Scanner(new File("invertsub.in"));
        //输出流类
        PrintStream ps=System.out;
        System.setOut(new PrintStream("invertsub.out"));
        //程序实现
        String s=sc.nextLine();
        String t=sc.nextLine();
        //删除串末尾的#
        s=s.substring(0,s.length()-1);
        t=t.substring(0,t.length()-1);
        int leng=t.length()-1;
        int inde=s.indexOf(t);
        StringBuilder sb=new StringBuilder(s);
        while(leng>=0)
        {
            sb.setCharAt(inde,t.charAt(leng));
            leng--;
            inde++;
        }
        String st=sb.toString();
        System.out.println(st);
        //恢复输出
        System.setOut(ps);
    }
}
