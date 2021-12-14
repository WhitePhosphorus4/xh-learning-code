import java.util.Scanner;

public class lab1_2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long arr = sc.nextLong();
		String str = String.valueOf(arr);
		char[] ch = str.toCharArray();
		for(int i=ch.length-1;i>=0;i--)
		{
			System.out.print(ch[i]);
		}
	}
}

