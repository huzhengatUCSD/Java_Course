package ch05;

import java.util.Scanner; 

public class GreatestCommonDivisor {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter first integer: ");
    int n1 = input.nextInt();
    System.out.print("Enter second integer: ");
    int n2 = input.nextInt();

    int gcd = (n1<n2) ? n1 : n2;
    for (; gcd >= 1; gcd--) {
        if ((n1 % gcd == 0) && (n2 % gcd == 0)) {
          break;
        }
      }

    System.out.println("The greatest common divisor for " + n1 +
      " and " + n2 + " is " + gcd);
  }
}

