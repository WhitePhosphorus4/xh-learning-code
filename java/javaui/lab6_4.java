import java.util.*;

public class lab6_4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String datastring=sc.nextLine();
        char data[]=datastring.toCharArray();
        int size=data.length;
        int flag=0;
        if(size!=3)
        {
            System.out.print(-1);
        }
        else
        {
            for(int i=2;i>=0;i--)
            {
                if(data[i]!='0')
                {
                    flag=1;
                }
                if(flag==1)
                {
                    System.out.print(data[i]);
                }
            }
        }
    }
}