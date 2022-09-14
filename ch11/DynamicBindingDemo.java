package ch11;

public class DynamicBindingDemo {
  public static void main(String[] args) {
	Object o1 = new GraduateStudent(); // implicit casting 向上转型
	
	/*if (o1 instanceof GraduateStudent) {
	  System.out.println("Never got here");
	  GraduateStudent gs = (GraduateStudent)o1; // explicit casting 向下转型
	}*/
	
    m(o1);
    m(new Student());
    m(new Person());
    m(new Object());
   // m(new AAA());
  }

  public static void m(Object x) {
    System.out.println(x.toString());
  }
}

class GraduateStudent extends Student {
}

class Student extends Person {
  //@Override 
  //public String toString() {
  //  return "Student";
  //}
}

class Person extends Object {
  //@Override 
  //public String toString() {
  //  return "Person";
  //}
  
 
}
class AAA{
	 
}
