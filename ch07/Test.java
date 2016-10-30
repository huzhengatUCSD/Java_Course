package ch07;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      // for(int i =0; i< args.length; i++)
    	   	//	System.out.println(args[i]);
		int x=1; //x represents an int value;
		int[] y=new int[10]; //y represents an array of int values;
		
		m(x,y);
		
		System.out.println("x is "+x);
		System.out.println("y[0] is "+y[0]);
			
	}
	
    public static void m(int number, int[] numbers ){
    		number=1001; //Assign a new value to number
    		numbers[0]=5555;  //Assign a new value  to numbers[0]
    }

}
