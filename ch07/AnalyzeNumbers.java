package ch07;

public class AnalyzeNumbers {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter the number of items: ");
    int n = input.nextInt();
    double[] numbers = new double[n];
    int[] indexes= new int[n];
    double sum = 0;

    System.out.print("Enter the numbers: ");
    for (int i = 0; i < n; i++) {
      numbers[i] = Math.random()*100;
      sum += numbers[i];
    }

    double average = sum / n;

    int count = 0; // The number of elements above average
    for (int i = 0; i < n; i++) 
      if (numbers[i] > average) {
    	    indexes[count]=i;
        count++;
      }

    System.out.println("Average is " + average);
    System.out.println("Number of elements above the average "
      + count);
    System.out.println("Indexes of elements above the average are: ");
    for(int i=0;i<count;i++) {
    	   System.out.printf("%-3d ",indexes[i]);
    	   if(i==0) continue;
    	   if((i+1)%5==0) System.out.println();
    }
    input.close();
  }
}