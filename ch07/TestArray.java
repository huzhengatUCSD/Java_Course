package ch07;
import java.util.Scanner;
import ch08.TestSwap08;


public class TestArray {
	 public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double[] myList=new double[20];
		//System.out.print("Enter " + myList.length + " values: ");
		System.out.print("Create " + myList.length + " values Randomly: ");
		for(int i = 0; i < myList.length; i++)
  			myList[i]=Math.random()*100; //myList[i] = input.nextDouble();
  		myList=TestSwap08.reverse(myList);
  		for(double db : myList)
  			System.out.print(db+" ");
  		System.out.println();
  		input.close();
	}
}