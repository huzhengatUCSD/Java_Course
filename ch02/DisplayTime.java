package ch02;

import java.util.Scanner;

public class DisplayTime {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Prompt the user for input
    System.out.print("Enter an integer for seconds: ");
    int seconds = input.nextInt();
    
    int hours = seconds / 3600; // Find hours in seconds
    int remainingSeconds = seconds % 60; // Seconds remaining
    int minutes = remainingSeconds / 60; // Find minutes in seconds
    remainingSeconds = remainingSeconds % 60; // Seconds remaining
    System.out.println(seconds + " seconds is " + hours + " hours and "  + minutes + 
      " minutes and " + remainingSeconds + " seconds");  
    input.close();
  }
}