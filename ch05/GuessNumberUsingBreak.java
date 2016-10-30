package ch05;

import java.util.Scanner; 

public class GuessNumberUsingBreak {
  public static void main(String[] args) {
    // Generate a random number to be guessed
    int number = (int)(Math.random() * 101);

    Scanner input = new Scanner(System.in);
    System.out.println("Guess a magic number between 0 and 100");
    boolean guessed=false;
    
    while (true) { // (!guessed)
      // Prompt the user to guess the number
      System.out.print("\nEnter your guess: ");
      int guess = input.nextInt();

      if (guess == number) {
        System.out.println("Yes, the number is " + number);
        break; //guessed = true;
      }
      else if (guess > number)
        System.out.println("Your guess is too high");
      else
        System.out.println("Your guess is too low");
    } // End of loop
  }
}
