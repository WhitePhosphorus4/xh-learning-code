import java.util.Scanner;

public class lab1_1 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int i = a,j = b;
		int x =0,y =0;
		//比较大小
		if(a < b)
		{
            x = b;
            b = a;
            a = x;
        }
		while(b != 0)
		{
            y = a % b;
            a = b;
            b = y;
        }
        int t = i * j / a;
		System.out.print(a);
		System.out.print(" ");
        System.out.print(t+"\n");  
    }
}
