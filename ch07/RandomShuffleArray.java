package ch07;

public class RandomShuffleArray{
	public static void main(String[] args) {
		double[] myList=new double[10];

		for(int i=0;i<myList.length;i++)
			myList[i]=i+1;
		
		for(int i=myList.length-1;i>0;i--){
			int j=(int)(Math.random()*(i+1));
			double temp=myList[i];
			myList[i]=myList[j];
			myList[j]=temp;

		}
		for(double db : myList)
  			System.out.println(db+" ");
		System.out.println();
	}
}