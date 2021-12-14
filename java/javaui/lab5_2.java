import java.util.Scanner;

class Date{
    public int year;
    public int month;
    public int day;
    Date()
    {
        this.day=0;
        this.month=0;
        this.year=0;
    }

}

//编写一个程序，用户输入出生日期和当前日期，计算出实际年龄。
public class lab5_2{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Date birth=new Date();
        Date now=new Date();
        //获取日期
        //每次处理这种莫名其妙的输入数据方式就想砍人
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
            while(i1>=0&&data1[i1]!='.')
            {
                birth.day+=((int)data1[i1]-(int)'0')*y;
                y*=10;
                i1--;
            }
            y=1;    
            i1--;
            while(i1>=0&&data1[i1]!='.')
            {
                birth.month+=((int)data1[i1]-(int)'0')*y;
                y*=10;
                i1--;
            }
            y=1;
            i1--;
            while(i1>=0&&data1[i1]!='.')
            {
                birth.year+=((int)data1[i1]-(int)'0')*y;
                y*=10;
                i1--;
            }
            i1--;
        }
        while(i2>=0)
        {
            y=1;
            while(i2>=0&&data2[i2]!='.')
            {
                now.day+=((int)data2[i2]-(int)'0')*y;
                y*=10;
                i2--;
            }
            y=1;    
            i2--;
            while(i2>=0&&data2[i2]!='.')
            {
                now.month+=((int)data2[i2]-(int)'0')*y;
                y*=10;
                i2--;
            }
            y=1;
            i2--;
            while(i2>=0&&data2[i2]!='.')
            {
                now.year+=((int)data2[i2]-(int)'0')*y;
                y*=10;
                i2--;
            }
            i2--;
        }
        int result=now.year-birth.year;
        if(birth.month>now.month)
        {
            result--;
        }
        else if(birth.month==now.month&&birth.day>now.day)
        {
            result--;
        }
        // test
        // System.out.println(da1);
        // System.out.println(da2);
        //print
        System.out.print(result);
    }
}