package ch19;

public class WildCardNeedDemo {
  public static void main(String[] args ) {
     GenericStack<Double> intStack = new GenericStack<>();
     intStack.push(1.0); // 1 is autoboxed into new Integer(1)
     intStack.push(2.0);
     intStack.push(-2.0);

     System.out.print("The max number is " + max(intStack));
  }

  /** Find the maximum in a stack of numbers */
  public static double max(GenericStack<Number> stack) {
     double max = stack.pop().doubleValue(); // initialize max

     while (!stack.isEmpty()) {
       double value = stack.pop().doubleValue();
       if (value > max)
         max = value;
     }

     return max;
  }
}
