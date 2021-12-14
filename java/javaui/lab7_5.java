import java.util.*;
import java.io.*;


//这里貌似文件内容不止一行，所以需要判断是否还有下一行来判断是否结束输入
public class lab7_5{
    public static void main(String[] args)throws FileNotFoundException{
        //文件
        Scanner sc = new Scanner(new File("in.txt"));
        //输入
        String[] ordata=new String[10];     //用于接收数据的String
        int sizeline=0;             //文件行数
        while(sc.hasNextLine())     //判断是否还有下一行
        {
            ordata[sizeline]=new String(sc.nextLine());
            sizeline++;
        }
        //判断
        int wor=0;
        int cha=0;
        for(int j=0;j<sizeline;j++)
        {
            char[] data=ordata[j].toCharArray();
            int size=data.length;
            cha+=size;
            for(int i=0;i<size;i++)
            {
                if(jud(data[i])==1)
                {
                    wor++;
                    while(i<size)
                    {
                        if(jud(data[i])==0)
                        {
                            break;
                        }
                        i++;
                    }
                }
            }
            //测试输出
            // for(int i=0;i<size;i++)
            // {
            //     System.out.print(data[i]);       
            // }
            // System.out.println();
        }
        cha+=sizeline-1;    //兄弟，回车也是符号
        //输出
        System.out.print(wor+" "+cha);
    }

    //判断是否为字母
    public static int jud(char str)
    {
        int x=(int)str;
        if((x>=65&&x<=90)||(x>=97&&x<=122))
        {
            return 1;
        }
        return 0;
    }
}