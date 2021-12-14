
public class lab3_5ex{
    public static void main(String[]args){
        MobilePhone phone2=new MobilePhone("HUAWEI","13800000000","130432100000000000");
        // phone2.testprint();
        phone2.display();
    }
}

class MobilePhone extends Phone{
    private String name;
    private String number;

    public void testprint(){
        System.out.println("Name="+this.name);
        System.out.println("Number="+this.number);
    }

    public MobilePhone(String name,String code,String number)
    {
        super(code);    //子类要想调用父类含参数的构造方法，必须使用super显示调用，并且必须在子类第一条可执行语句
        this.name=name;
        this.number=number;
    }
}