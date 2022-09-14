package ch19;

import java.util.List;

public class GenericMethodDemo {
  public static void main(String[] args ) {
    Integer[] integers = {1, 2, 3, 4, 5};
    String[] strings = {"London", "Paris", "New York", "Austin"};
    
    GenericMethodDemo gmc=new GenericMethodDemo();
    
    gmc.<String>print(strings); //可inference
    gmc.<Integer>print(integers); //可inference
    gmc.<Comparable<?>>print(134,13.2,0); //可inference
    gmc.print("hello",0,null);
    GenericMethodDemo.<java.util.Date>m(new java.util.Date());
  }
  public static <E> void m(E o1){
	  System.out.println(o1);
	  
  }
  public <E> void print(E... list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
    System.out.println();
  }
  
}
