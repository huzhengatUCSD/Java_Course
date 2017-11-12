package ch10;

import java.math.*;

public class LargeFactorial {
  public static void main(String[] args) {
    System.out.println("100! is \n" + factorial(100));
    System.out.println(String.format("%b", 26));
    System.out.println(String.format("%x", 26));
  }

  public static BigInteger factorial(long n) {
    BigInteger result = BigInteger.ONE;
    for (int i = 1; i <= n; i++)
      result = result.multiply(new BigInteger(i+""));

    return result;
  }
}
