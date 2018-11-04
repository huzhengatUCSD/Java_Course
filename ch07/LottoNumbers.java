package ch07;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LottoNumbers {
  public static void main(String args[]) {
    File file=new File(".//res//ch07//lotto_number.txt");
    //Scanner input = new Scanner(System.in);
    Scanner input=null;
    try {
      input=new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    boolean[] isCovered = new boolean[99]; // default false

    // Read all numbers and mark corresponding element covered
    int number;
    while(input.hasNextInt()) {
      number = input.nextInt();
      while (number != 0) {
        isCovered[number - 1] = true;
        number = input.nextInt();
      }
    }
    // Check if all covered
    boolean allCovered = true; // Assume all covered
    int hitCount=0;
    for (int i = 0; i < 99; i++) 
      if (!isCovered[i]) {
        allCovered = false; // Find one number is not covered
      } else {
        System.out.printf("%-4d",i);
        hitCount++;
        if (hitCount%5==0){
          System.out.println();
        }
      }

    System.out.println("\n==========================");
      // Display result
    if (allCovered)
      System.out.println("The tickets cover all numbers");
    else
      System.out.printf("The tickets don\'t cover all numbers and only cover %d numbers\n",hitCount);
    input.close();
  } 
}