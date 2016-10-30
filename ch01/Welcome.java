// This application program prints Welcome to Java!

package ch01;

import java.util.*;	

class Student {
	public long sid;
	public int zonghepingfen;
	public int getRank(int zonghepingfen){
		return 1;
	}
	public Student(){
		sid=1L;
		zonghepingfen=1;
	}
	public Student(long sida, int zonghepingfena){
		sid=sida;
		zonghepingfen=zonghepingfena;
	}
	
}

public class Welcome { 
  public static void main(String[] args) { 
	String s="Welcome to Java!\b\b\r\n";
	System.out.print(s);
	System.out.print(s);
	Student[] student=new Student[5];
	student[0]=new Student(1L,88);
	student[1]=new Student(2L,67);
	student[2]=new Student(3L,90);
	student[3]=new Student(4L,70);
	student[4]=new Student(5L,64);
	System.out.println(student[0].zonghepingfen);
	int i=0; 
	do {
	  System.out.println("i is " + i);
	  i++;
	} while (i<10);
	
	Scanner input = new Scanner(System.in);
	System.out.print("Enter a character: ");
	String s1 = input.nextLine();
	char ch = s1.charAt(0);
	System.out.println("The character entered is " + ch);
	
	int count = 5;
	double amount = 23.4E3;
	
	System.out.printf("count is %d and amount is %f", count, amount);
    int[] list2={2, 3, 7, 7, 7, 10};
    System.out.println(list2[0] + " "+ list2[1]+" "+ list2[3]);
  }
}
