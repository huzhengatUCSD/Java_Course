package ch02;

public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Calculator cal=new Calculator();
        System.out.println(cal.getResult());
        cal.add(6);
        System.out.println(cal.getResult());
        cal.substract(4);
        System.out.println(cal.getResult());
        cal.multiply(3);
        System.out.println(cal.getResult());
        cal.divide(2);
        System.out.println(cal.getResult());
        
	}

}
