import java.util.Scanner;
import java.io.*;

public class lab1_5 {
    //添加了抛出声明
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(new File("correct.in"));
        PrintStream psold = System.out;
        System.setOut(new PrintStream(new File("correct.out")));
        String str = scan.nextLine();
        boolean cha;
        cha = jud(str);
        if(cha)
        {
            System.out.print("True\n");
        }
        else
        {
            System.out.print("False\n");
        }
        System.setOut(psold);
    }

    //判断函数
    private static boolean jud(String str) {
        boolean jud = false;
        int len = str.length();
        if (null == str || len <= 1) {
            return jud;
        }
        char[] charArray = str.toCharArray();
        int smallLeft = 0, smallRight = 0, midLeft = 0, midRight = 0, bigLeft = 0, bigRight = 0;
        for (int i = 0; i < len; i++) {
            switch (charArray[i]) {
            case '(':
                smallLeft++;
                break;
            case ')':
                smallRight++;
                break;
            case '[':
                midLeft++;
                break;
            case ']':
                midRight++;
                break;
            case '{':
                bigLeft++;
                break;
            case '}':
                bigRight++;
                break;
            default:
                break;
            }
        }
        if ((smallLeft == smallRight)
                && str.lastIndexOf("(") <= str.lastIndexOf(")")) {
            jud = true;
        } 
        if ((midLeft == midRight) && jud
                && str.lastIndexOf("[") <= str.lastIndexOf("]")) {
            jud = true;
        } else {
            jud = false;
        }
        if ((bigLeft == bigRight) && jud
                && str.lastIndexOf("{") <= str.lastIndexOf("}")) {
            jud = true;
        } else {
            jud = false;
        }
        return jud;
    }
}