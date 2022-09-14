package ch10;

public class TestStackOfIntegers {
  public static void main(String[] args) {
    StackOfIntegers stack = new StackOfIntegers(16);
    
    for (int i = 0; i < 25; i++)
      stack.push(i);

    
    while (!stack.empty())
      System.out.print(stack.pop() + " ");  
  }
}
