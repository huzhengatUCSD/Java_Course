package ch12;

public class FinallyReturn {
	  public int methodA(int money)throws SpecialException{
	    if(--money<=0) throw new SpecialException("Out of money");
	    return money;
	  }

	  @SuppressWarnings("finally")
	public int methodB(int money){
		int a=-100;
	    try{
	      return methodA(money);  //可能抛出异常
	    }catch(SpecialException e){
	      return a;
	    }finally{
	      return 100;  //会覆盖try和catch代码块的return语句
	    }
	  }

	  public static void main(String args[]){
	    FinallyReturn s=new FinallyReturn ();
	    System.out.println(s.methodB(-2));  //打印100
	    System.out.println(s.methodB(1));  //打印100
	  }
	}