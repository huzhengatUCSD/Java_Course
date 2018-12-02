package ch12;

public class MainCatcherNew{
  public void methodA(int money)throws SpecialException{
    if(--money<=0) {
		throw new SpecialException("Out of money");
        //money=1;
	}
    System.out.println("methodA");
  }
  public void methodB(int money) throws SpecialException{
    methodA(money);
    System.out.println("methodB");
  }
  public static void main(String args[]) throws Exception{
    try{
      new MainCatcherNew().method();
    }catch(SpecialException e){
      e.printStackTrace();
    }
  }

  public void method() throws Exception{
    try{
	  System.out.println("Begin");
      methodB(1);
      System.out.println("main");
    }catch(SpecialException e){
      System.out.println("Wrong");
//	  System.exit(0);
	  throw e;
    }finally{
       System.out.println("Finally");
	}
	System.out.println("End");
  }
}

