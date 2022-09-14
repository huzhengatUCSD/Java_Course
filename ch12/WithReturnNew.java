package ch12;

public class WithReturnNew{
	  public int methodA(int money)throws SpecialException{
	       if(--money<=0) throw new SpecialException("Out of money");
	       return money;
	  }

	  public int methodB(int money){
	   int a=-100;
	   try{
	      System.out.println("Begin");
	      int result=methodA(money);  //可能抛出异常
	      return result;
	    }catch(SpecialException e){
	      System.out.println(e.getMessage());
	      return a;  //怎么样都会返回-100
	    }finally{
	      a=100;
		  System.out.println("Finally");
	    }
	  }

	  public static void main(String args[]){
	    System.out.println(new WithReturnNew().methodB(1)); 
	  }
	}
