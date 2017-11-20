package ch10;

public class TestCourse {
  public static void main(String[] args) {
    Course course1 = new Course("Data Structures");
    Course course2 = new Course("Database Systems");
    
    course1.addStudent("Peter Jones");
    course1.addStudent("Brian Smith");
    course1.addStudent("Anne Kennedy");
    course1.addStudent("S1");
    course1.addStudent("S2");
    course1.addStudent("S3");
    course1.addStudent("S1");
    course1.addStudent("S5");
    course1.addStudent("S6");
    course1.addStudent("S7");
    
    course2.addStudent("Peter Jones");
    course2.addStudent("Steve Smith");
    
    System.out.println("Number of students in course1: "
      + course1.getNumberOfStudents());
    String[] students = course1.getStudents();
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.print(students[i] + ", ");
    System.out.println();
    
    course1.dropStudent("S1");
 // course1.dropStudent("S1");
 // course1.dropStudent("S7");    
    System.out.println("Number of students in course1 after drop student: "
      + course1.getNumberOfStudents());
    students = course1.getStudents();
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.print(students[i] + ", ");
    
    course1.clear();
    System.out.println("\nNumber of students in course1 after clear: "
      + course1.getNumberOfStudents());
   
    
    System.out.print("Number of students in course2: "
      + course2.getNumberOfStudents());
  }
}
