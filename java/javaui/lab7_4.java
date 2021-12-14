import java.util.*;

//利用ArrayList类实现动态数组并进行排序
public class lab7_4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList data=new ArrayList();
        int a1=sc.nextInt();
        for(int i=0;i<a1;i++)
        {
            data.add(sc.nextInt());
        }
        int a2=sc.nextInt();
        for(int i=0;i<a2;i++)
        {
            data.add(sc.nextInt());
        }
        Collections.sort(data); //调用Collections.sort()进行排序
        int size=a1+a2;
        for(int i=0;i<size;i++)
        {
            System.out.print(data.get(i)+" ");  //输出数据
        }
    }
}