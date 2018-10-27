package ch01;

import edu.duke.FileResource;

public class ComplexHelloApp{
	public void runHello () {
		FileResource res = new FileResource(".//res//ch01//hello_unicode.txt" );
		for (String line : res.lines()) {
			System.out.print(line+ "\n");
		}
		
	}
    public static void main(String[] args) {
	   ComplexHelloApp aHello = new 	ComplexHelloApp();
	   aHello.runHello();
		
	}
}