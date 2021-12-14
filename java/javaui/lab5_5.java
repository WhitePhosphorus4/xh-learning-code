import java.util.Scanner;

//建立一个节点类，存储每个点的坐标
class point{
	public int x;
	public int y;
	point(){
		this.x=0;
		this.y=0;
	}
}

public class lab5_5{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        point A1=new point();
        point A2=new point();
        point B1=new point();
        point B2=new point();
        point Abig=null;
        point Asmall=null;
        point Bbig=null;
        point Bsmall=null;
        A1.x=sc.nextInt();
        A1.y=sc.nextInt();
        A2.x=sc.nextInt();
        A2.y=sc.nextInt();
        B1.x=sc.nextInt();
        B1.y=sc.nextInt();
        B2.x=sc.nextInt();
        B2.y=sc.nextInt();
        int area=0;
        int xpo=0;
        int ypo=0;
        int max=0;
        int min=0;
        //xpo
        if(A1.x>A2.x)
        {
            Abig=A1;
            Asmall=A2;
        }
        else
        {
            Abig=A2;
            Asmall=A1;
        }
        if(B1.x>B2.x)
        {
            Bbig=B1;
            Bsmall=B2;
        }
        else
        {
            Bbig=B2;
            Bsmall=B1;
        }
        max=(Abig.x<Bbig.x)?Abig.x:Bbig.x;
        min=(Asmall.x>Bsmall.x)?Asmall.x:Bsmall.x;
        xpo=max-min;
        //ypo
        if(A1.y>A2.y)
        {
            Abig=A1;
            Asmall=A2;
        }
        else
        {
            Abig=A2;
            Asmall=A1;
        }
        if(B1.y>B2.y)
        {
            Bbig=B1;
            Bsmall=B2;
        }
        else
        {
            Bbig=B2;
            Bsmall=B1;
        }
        max=(Abig.y<Bbig.y)?Abig.y:Bbig.y;
        min=(Asmall.y>Bsmall.y)?Asmall.y:Bsmall.y;
        ypo=max-min;
        //judge
        //print
        if(xpo>0&&ypo>0)
        {
            area=xpo*ypo;
        }
        System.out.print(area);
    }
    
}