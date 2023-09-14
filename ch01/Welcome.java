// This application program prints Welcome to Java!

package ch01;

public class Welcome { 
	public void hello() {
		System.out.println("Hello, Welcome to Java World! "); 
	}
  public static void main(String[] args) { 
    // Display message Welcome to Java! on the console
    System.out.println("Welcome to Java world and something new happened! "); //to do
    new Welcome().hello();
    
  }
}

