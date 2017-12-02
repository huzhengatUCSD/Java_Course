package ch12;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class InputMismatchExceptionDemo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean continueInput = true;
    NumberFormat nf=NumberFormat.getPercentInstance();
    System.out.print("Enter an Percent(XX%): ");
    String str=input.nextLine();
    do {
     	try {
	    		Number m=nf.parse(str);
	    		double d=m.doubleValue();
	    		System.out.println(d);
	    		continueInput=false;
     	} catch (ParseException e) {
    		// TODO Auto-generated catch block
     	    System.out.println("Try again. (" + 
     		          "Incorrect input: a format percent is required)");
     	   System.out.print("Enter an Percent(XX%): ");
     	   str=input.nextLine();
    		}
    }while(continueInput);
    
    continueInput=true;
    
    do {
      try {
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
  
        // Display the result
        System.out.println(
          "The number entered is " + number);
        
        continueInput = false;
      } 
      catch (InputMismatchException ex) {
        System.out.println("Try again. (" + 
          "Incorrect input: an integer is required)");
        input.nextLine(); // discard input 
      }
    } while (continueInput);
  }
}
