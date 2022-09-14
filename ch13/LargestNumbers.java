package ch13;

import java.util.ArrayList;
import java.math.*;

public class LargestNumbers {
  public static void main(String[] args) {
    ArrayList<Number> list = new ArrayList();
    list.add(45); // Add an Integer
    list.add(3445.53); // Add a Double
    // Add a BigInteger
    list.add(new BigInteger("3432323234344343101")); 
    // Add a BigDecimal
    list.add(new BigDecimal("2090909098909133242342342342342343244343334434.3")); 
    
    System.out.println("The largest number is " +   
         getLargestNumber(list));
    
  }
  
  public static Number getLargestNumber(ArrayList<Number> list) {
    if (list == null || list.size() == 0) 
      return null;
    
    Number number = list.get(0);
    for (int i = 1; i < list.size(); i++) 
      if (number.doubleValue() < list.get(i).doubleValue()) 
        number = list.get(i);
    return number;
  }
}
