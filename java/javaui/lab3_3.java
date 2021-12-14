import java.util.Scanner;

public class lab3_3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt();
        if(x<0)
        {
            System.out.println("0");
        }
        else if(y<0)
        {
            System.out.println(mat(x));
        }
        else if(z<0)
        {
            System.out.println(mat(x,y));
        }
        else
        {
            System.out.println(mat(x,y,z));
        }
    }

    public static int mat(int x){
        return x*x;
    }
    public static int mat(int x,int y){
        return x*x+y*y;
    }
    public static int mat(int x,int y,int z){
        return x*x+y*y+z*z;
    }
}