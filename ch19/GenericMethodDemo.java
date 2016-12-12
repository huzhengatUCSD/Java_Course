package ch19;

public class GenericMethodDemo {
  public static void main(String[] args ) {
    Integer[] integers = {1, 2, 3, 4, 5};
    String[] strings = {"London", "Paris", "New York", "Austin"};
    
    GenericMethodDemo gmc=new GenericMethodDemo();
    
    gmc.<String>print(strings);
    gmc.<Integer>print(integers);
    GenericMethodDemo.<String>m("hello");
  }
  public static <E> void m(E o1){
	  System.out.println(o1);
	  
  }
  public <E> void print(E[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
    System.out.println();
  }
  
}
