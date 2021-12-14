import java.util.Scanner;

public class lab1_4 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N=scan.nextInt();
		for(int i=100;i<=N;i++)
		{
			if((Math.pow(i/100, 3)+Math.pow((i/10)%10, 3)+Math.pow((i%10), 3))==i)
			{
				System.out.println(i);
			}
		}
	}
}