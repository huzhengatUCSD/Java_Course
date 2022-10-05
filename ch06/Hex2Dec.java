package ch06;

import java.util.Scanner;

public class Hex2Dec {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter a string
    System.out.print("Enter a hex number: ");
    String hex = input.nextLine();

    System.out.println("The decimal value for hex number "
      + hex + " is " + hexToDecimal(hex.toUpperCase()));
  }

  public static int hexToDecimal(String hex) {
    int decimalValue = 0;
    for (int i = 0; i < hex.length(); i++) {
      char hexChar = hex.charAt(i);
      int charDecimal=hexCharToDecimal(hexChar);
      if (charDecimal==-1){
        System.out.println("invalid Hex number digit input!");
        System.exit(0);
      }
      decimalValue = decimalValue * 16 + charDecimal;
    }
    
    return decimalValue;
  }

  public static int hexCharToDecimal(char ch) {
    if (ch >= 'A' && ch <= 'F') {
      return 10 + ch - 'A';
    } else if (Character.isDigit(ch)) {// ch is '0', '1', ..., or '9'
      return ch - '0';
    } else return -1;
  }
}
