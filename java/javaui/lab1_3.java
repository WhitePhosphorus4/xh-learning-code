import java.util.Scanner;

public class lab1_3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long arr = sc.nextLong();
		String str = String.valueOf(arr);
		char[] ch = str.toCharArray();
		int jud=ch.length%3-1;
		int nu=ch.length/3;
		if(jud<0)
		{
			jud+=3;
			nu--;
		}
		for(int i=0;i<ch.length;i++)
		{
			System.out.print(ch[i]);
			if(i==jud&&nu!=0)
			{
				System.out.print(',');
				jud+=3;
				nu--;
			}
		}
	}
}
