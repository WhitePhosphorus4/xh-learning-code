import java.math.BigDecimal;
import java.util.Scanner;

public class lab3_2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        atof(str);
    }
    //字符串转换为相应的双精度浮点数
    public static void atof(String str){
        if(str.indexOf("a")==-1)
        {
            chone(str);
        }
        else
        {
            chtwo(str);
        }
    }
    //处理第一种输入形式
    public static void chone(String str){
        double data=Double.valueOf(str.toString());
        System.out.printf("%f",data);
    }
    //处理第二种输入形式
    public static void chtwo(String str){
        BigDecimal bd=new BigDecimal(str.toString());
        System.out.printf("%f",bd);
    }
}