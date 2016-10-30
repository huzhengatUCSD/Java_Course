package ch05;

public class TestSum {
  public static void main(String[] args) {
    // Initialize sum
    double sum = 0;
    int count=1;
    // Add 0.01, 0.02, ..., 0.99, 1 to sum\
    for (double i = 0.01; i <= 1.0; i = i + 0.01){
    	     System.out.println(count+  " : "+ i);
    	     count++;
         sum += i;
    }
    
    // Display result
    System.out.println("The sum is " + sum);
  }
}
