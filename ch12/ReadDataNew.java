package ch12;


import java.util.Scanner; 
import java.io.*;

public class ReadDataNew {
  public static void main(String[] args) throws IOException{
    // Create a File instance
	  File file = new File("test.txt"); //scores.txt
	  if (file.exists()) {
		  System.out.println("File already exists");
		  System.exit(0);
	  }
	  
	  PrintWriter output = new PrintWriter(file);

	  // Write formatted output to the file
	  output.print(12);
	  output.println(" 345");

	  // Close the file
	  output.close();
	  
	  int i=0;
	  String str="";
	  // Create a Scanner for the file with autoclose
	  try(
			  Scanner input = new Scanner("12\n345\n");
	  ){	
		  i= input.nextInt();
		  str = input.nextLine();	   
		  System.out.print(i);
		  System.out.print(str);

	    }
	  file.delete();
	  
  }
}
