import java.util.*;

//建立一个节点类，存储每个点的坐标
class point{
	public int x;
	public int y;
	point(){
		this.x=0;
		this.y=0;
	}
}

public class lab4_2 {
    public static void main(String args[]) 
    {
    	point[] data=new point[100];
    	int num=0;
    	Scanner sc = new Scanner(System.in);
    	for(int i=0;i<100;i++)
    	{
    		data[i]= new point();
    	}
    	num=sc.nextInt();
    	for(int i=0;i<num;i++)
    	{
    		data[i].x = sc.nextInt();
    		data[i].y = sc.nextInt();
		}
		int i=0;
    	double temp=0;
		//利用到了百度到的多边形面积公式。
		//s=1/2*[(x1*y2-x2*y1)+(x2*y3-x3*y2)+...... +(Xk*Yk+1-Xk+1*Yk)+...+(Xn*y1-x1*Yn) ]
		for(i=0;i<num-1;i++)
    	{
    		temp+=(data[i].x-data[i+1].x)*(data[i].y+data[i+1].y);
    	}
		temp+=(data[i].x-data[0].x)*(data[i].y+data[0].y);
        System.out.printf("%.2f",Math.abs(temp/2));
    }
}