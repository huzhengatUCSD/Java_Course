package ch11;

public class Apple extends Fruit {

	public Apple(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
  
}

class Fruit {
  
  public Fruit(String name) {
    System.out.println("Fruit's constructor is invoked");
  }
}
