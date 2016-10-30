package ch09;

import java.util.*;

public class TestSubAdd{
  public static void main(String[] args) {
	int numbersofquestions=10;
	int numbers_extent=10;
	switch (args.length) {
		case 2:  numbers_extent=Integer.parseInt(args[1]);
		
		case 1:  numbersofquestions=Integer.parseInt(args[0]);
		         break;
		case 0:  break;
		default: System.out.println("TestSubAdd should use parameters like int or int int");
	}
    final int NUMBER_OF_QUESTIONS = numbersofquestions; // Number of questions
    int correctCount = 0; // Count the number of correct answers
    int count = 0; // Count the number of questions
    long startTime = System.currentTimeMillis();
    String output = ""; // output string is initially empty
    Random rand = new Random(13);
    Scanner input = new Scanner(System.in);
    
    boolean isAddorSub=false;
    boolean reOutput=false;
    int number1 = rand.nextInt(numbers_extent);
    int number2 = rand.nextInt(numbers_extent);;
    
    while (count < NUMBER_OF_QUESTIONS) {
      // 1. Generate two random single-digit integers
    	  
    	  if (reOutput){
     	  reOutput=false; 
    	  }
    	  else{
    		  number1 = rand.nextInt(numbers_extent);;
    		  number2 = rand.nextInt(numbers_extent);;
    	  }
      // 2. If number1 < number2, swap number1 with number2
      if (number1 < number2) {
        int temp = number1;
        number1 = number2;
        number2 = temp;
      }
      

      // 3. Prompt the student to answer \"What is number1 + or - number2?\"
      
      
      isAddorSub=rand.nextBoolean();
      System.out.print(
    		  "Question No." + (count+1)+": " + number1 + (isAddorSub?" + ":" - ") + number2 + " = ");
      
      int answer=0;
      String strAnswer;
      strAnswer=input.nextLine();
      try{
    	    answer=Integer.parseInt(strAnswer);
      }catch(Exception e){
    	    System.out.println("Please check the input characters. numbers are required!");
    	    reOutput=true; 
    	    continue;
      }
      
      
	  
      // 4. Grade the answer and display the result
      if (isAddorSub){
    	      if (number1 + number2 == answer) {
    	    	  	correctCount++;
    	      }
    	      count++;

    	      output += "\n" +count +" : "+ number1 + "+" + number2 + "=" + answer + 
    			  ((number1 + number2 == answer) ? "  \u2713" : "  \u2717"+ " ,and the correct answer is "+ (number1 + number2));
      } 
      else {
    	      if (number1 - number2 == answer) {
	    	  	correctCount++;
	      }
	      
	      // Increase the count
	      count++;

	      output += "\n" +count +" : "+ number1 + "-" + number2 + "=" + answer + 
			  ((number1 - number2 == answer) ?  "  \u2713" : "  \u2717"+ " ,and the correct answer is "+ (number1 - number2));
      }
    	  
    }

    long endTime = System.currentTimeMillis();
    long testTime = endTime - startTime;

    System.out.println("Correct count is " + correctCount + " in "+ NUMBER_OF_QUESTIONS + " questions" + 
      "\nTest time is " + testTime / 1000 + " seconds\n" + output);
  }
}
