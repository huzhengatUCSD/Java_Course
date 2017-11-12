package ch09;

class Student{
	String name; //name has the default value null
	int age;     //age has the default value 0
	boolean isScienceMajor; //isScienceMajor has default value false
	char gender;   //gender has default value '\u0000'
}
public class TestNullRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		System.out.println("name? "+ student.name);
		System.out.println("isScienceMajor? "+ student.isScienceMajor);
		
		/*Java assigns no default value to a local variable inside a method. 
		int x;  //x has no default value
		System.out.println("x=? "+x);  */

	}

}
