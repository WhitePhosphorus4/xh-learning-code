import java.util.Scanner;

import java.io.*;

public class lab2_2{
    public static void main(String []args)throws FileNotFoundException{
        //建立输入流类
        Scanner sc = new Scanner(new File("poly.in"));
        //建立输出流类
        PrintStream psold = System.out;
        System.setOut(new PrintStream(new File("poly.out")));
        //建立并初始化哈希表
        int[] data=new int[50];
        for(int i=0;i<50;i++)
        {
            data[i]=0;
        }
        //输入
        int add=0;
        int sec=0;
        String da1=sc.nextLine();
        char data1[]=da1.toCharArray();
        String da2=sc.nextLine();
        char data2[]=da2.toCharArray();
        int i1=da1.length()-1;
        int i2=da2.length()-1;
        int y=1;
        while(i1>=0)
        {
            y=1;
            while(i1>=0&&data1[i1]!=' ')
            {
                add+=((int)data1[i1]-(int)'0')*y;
                y*=10;
                i1--;
            }
            y=1;    
            i1--;
            while(i1>=0&&data1[i1]!=' ')
            {
                sec+=((int)data1[i1]-(int)'0')*y;
                y*=10;
                i1--;
            }
            data[add]+=sec;
            add=0;
            sec=0;
            i1--;
        }
        while(i2>=0)
        {
            y=1;
            while(i2>=0&&data2[i2]!=' ')
            {
                add+=((int)data2[i2]-(int)'0')*y;
                y*=10;
                i2--;
            }
            y=1;    
            i2--;
            while(i2>=0&&data2[i2]!=' ')
            {
                sec+=((int)data2[i2]-(int)'0')*y;
                y*=10;
                i2--;
            }
            data[add]+=sec;
            add=0;
            sec=0;
            i2--;
        }
        //输出
        
        for(int i=49;i>=0;i--)
        {
            if(data[i]!=0)
            {
                System.out.print(data[i]+" "+i+" ");
            }
        }
        System.out.print("\n");
        //test
        // System.out.println(data1);
        // System.out.println(data2);
        //恢复输出流
        System.setOut(psold);
    }
}
