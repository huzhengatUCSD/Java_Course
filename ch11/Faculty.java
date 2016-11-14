package ch11;


public class Faculty extends Employee {
	public static void main(String[] args) {
		new Faculty();
	}

	public Faculty() {
		//super();
		System.out.println("(4) Faculty's no-arg constructor is invoked");

	}
}
class Employee extends People {
	public Employee() {
		this("(2) Invoke Employee’s overloaded constructor with String type parameter s");
		System.out.println("(3) Employee's no-arg constructor is invoked");
	}

	public Employee(String s) {
		System.out.println(s);
	}
}
class People {
	public People() {
		System.out.println("(1) People's no-arg constructor is invoked");
	}
}
