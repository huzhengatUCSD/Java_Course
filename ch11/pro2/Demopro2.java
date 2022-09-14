package ch11.pro2;
import ch11.pro1.Demopro1;
public class Demopro2 extends Demopro1
{
	protected int demopro2x=1;
	public static void main(String args[])
	{
		Demopro1 aDemo1 = new Demopro1(); //实例化Demo1
	    System.out.println("x = "+aDemo1.x);
	  //不能访问Demopro1中的default成员
	    aDemo1.ab=11;
	    
      //不能访问Demopro1中protected成员方法
	    aDemo1.method();
	    aDemo1.pa;
	    
      //可以访问Demopro1中public成员变量
		aDemo1.a = 10;
        int a = aDemo1.a;
		System.out.println("Demopro1中的公共成员变量a的值："+a);
      
	  //继承类Demopro2
		Demopro2 aDemo2 = new Demopro2();
	    aDemo2.ab=11;
	  //System.out.println("Demopro2中的default成员变量ab的值："+aDemo2.ab);
		aDemo2.method();  //可以继承protected类型方法并执行
		aDemo2.pa=10;
	
	    Demopro21 aDemo3 = new Demopro21();
	  
		aDemo3.method();
        aDemo3.ab=11;
        aDemo3.pa=3;
      //System.out.println("Demopro21中default类型的成员变量ab的值："+aDemo3.ab);
	}

/*    @Override
	protected void method(){
		System.out.println("Override superclass Demopro1's method() in Demopro2");
	}*/
}
class Demopro21 extends Demopro2
{
	public void method21() {
		Demopro2 x1=new Demopro2();
		x1.demopro2x+=1;
	}
	
}