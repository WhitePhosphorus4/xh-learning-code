import java.util.Scanner;

public class lab2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int sum=0;
        sum+=day;
        switch (month) {
            case 12:sum+=30;
            case 11:sum+=31;
            case 10:sum+=30;
            case 9:sum+=31;
            case 8:sum+=31;
            case 7:sum+=30;
            case 6:sum+=31;
            case 5:sum+=30;
            case 4:sum+=31;
            case 3:sum+=28;
            case 2:sum+=31;
            case 1:sum+=0;
        }
        if((year%4==0&&year%100!=0||year%400==0)&&month>2)
        {sum+=1;}
        // System.out.println(day);
        // System.out.println(month);
        // System.out.println(year);
        System.out.println(sum);
    }
}