package ch12;

public class FinallyReturn {
	  public int methodA(int money)throws SpecialException{
	    if(--money<=0) throw new SpecialException("Out of money");
	    return money;
	  }

	  public int methodB(int money){
	    try{
	      return methodA(money);  //可能抛出异常
	    }catch(SpecialException e){
	      return -100;
	    }finally{
	      return 100;  //会覆盖try和catch代码块的return语句
	    }
	  }

	  public static void main(String args[]){
	    FinallyReturn s=new FinallyReturn ();
	    System.out.println(s.methodB(1));  //打印100
	    System.out.println(s.methodB(2));  //打印100
	  }
	}