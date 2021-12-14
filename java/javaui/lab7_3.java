import java.util.*;
import java.io.*;

//通过String.split分割，通过compareTo()去重
public class lab7_3{
    public static void main(String[] args)throws FileNotFoundException{
        //文件
        Scanner sc = new Scanner(new File("sort.in"));
        PrintStream psold = System.out;
        System.setOut(new PrintStream(new File("sort.out")));
        //排序
        String ordata=sc.nextLine();        //读入
        String[] data=ordata.split(" ");    //空格分割
        Arrays.sort(data);                  //排序
        int arrsize=data.length;
        for(int i=0;i<arrsize;i++)
        {
            System.out.print(data[i]+" ");  //输出
            while(i+1<arrsize)              //查重
            {
                if(data[i].compareTo(data[i+1])!=0)
                {
                    break;
                }
                i++;
            }
        }
        //恢复
        System.setOut(psold);
    }
}