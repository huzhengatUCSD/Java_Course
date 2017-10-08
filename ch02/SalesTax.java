package ch02;

import java.util.Scanner;

public class SalesTax {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter purchase amount just like 112124.33:  ");
    double purchaseAmount = input.nextDouble();
    
    double tax = purchaseAmount * 0.06;
    System.out.println(String.format("Sales tax is %10.2f", tax));
    input.close();
  }
}
