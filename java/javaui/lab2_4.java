import java.util.Scanner;

public class lab2_4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float[] a = new float[10];
        for(int i=0;i<10;i++)
        {
            a[i] = sc.nextFloat();
        }
        ARRAY arr = new ARRAY(a);
        arr.process();
        arr.print();
    }
}

class ARRAY{
    private float data[] = new float[10];
    private float max = 0;
    private float min = 10000;
    private float average = 0;

    public ARRAY(float[] a){
        this.data=a;
    }

    public void process(){
        //max&min
        float total = 0;
        for(int i=0;i<10;i++)
        {
            if(data[i]>max)
            {
                max=data[i];
            }
            if(data[i]<min)
            {
                min=data[i];
            }
            total += data[i];
        }
        average = total/(float)10;
    }

    public void print(){
        //为什么要这么对我???
        //0
        int i=0;
        for(i=0;i<5;i++)
        {
            if(data[i]!=(int)data[i])
            {
                System.out.print(data[i] + " ");
            }
            else
            {
                System.out.print((int)data[i] + " ");
            }
            
        }
        System.out.print("\n");
        for(i=5;i<10;i++)
        {
            if(data[i]!=(int)data[i])
            {
                System.out.print(data[i] + " ");
            }
            else
            {
                System.out.print((int)data[i] + " ");
            }
        }
        System.out.print("\n");
        //max
        if(max!=(int)max)
        {
            System.out.println("max = " + this.max);
        }
        else
        {
            System.out.println("max = " + (int)this.max);
        }
        //min
        if(min!=(int)min)
        {
            System.out.println("min = " + this.min);
        }
        else
        {
            System.out.println("min = " + (int)this.min);
        }
        //average
        if(average!=(int)average)
        {
            System.out.println("average = " + this.average);
        }
        else
        {
            System.out.println("average = " + (int)this.average);
        }
    }
}