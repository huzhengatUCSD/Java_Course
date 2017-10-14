package ch03;

import java.util.Scanner;

public class ComputeAndInterpretBMI {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    // Prompt the user to enter weight in pounds
    System.out.print("Enter weight in kilograms: ");
    double weightInKilograms = input.nextDouble();
    
    // Prompt the user to enter height in inches
    System.out.print("Enter height in meters: ");
    double heightInMeters = input.nextDouble();
    
    // Compute BMI
    double bmi = weightInKilograms / 
      (heightInMeters * heightInMeters);

    // Display result
    System.out.println("BMI is " + bmi);
    if (bmi < 18.5)
      System.out.println("Underweight");
    else if (bmi < 25)
      System.out.println("Normal");
    else if (bmi < 30)
      System.out.println("Overweight");
    else
      System.out.println("Obese");
    input.close();
  }
}
