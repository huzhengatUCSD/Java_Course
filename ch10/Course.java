package ch10;

public class Course {
	private String courseName;
	private String[] students = new String[30];
	private int numberOfStudents;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public void addStudent(String student) {
		
		students[numberOfStudents] = student;
		if(numberOfStudents==(students.length-1)) {
			increaseSize();
		}
		numberOfStudents++;
	}

	public String[] getStudents() {
		return students;
	}

	/** Clear the course */
	public void clear() {
		for (int i = 0; i < numberOfStudents; i++) 
			students[i] = null;
		numberOfStudents = 0;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}  

	public String getCourseName() {
		return courseName;
	}  

	private void increaseSize() {
		System.out.println("resize students list to "+ (students.length * 2));
		String[] temp = new String[students.length * 2];
		System.arraycopy(students, 0, temp, 0, students.length);
		students = temp;
	} 

	public void dropStudent(String student) {
		for (int i = 0; i < numberOfStudents; i++) {
			if (students[i].equals(student)) {
				// Move students[i + 1] to students[i], etc.
				for (int k = i + 1; k < numberOfStudents; k++) {
					students[k - 1] = students[k];
				}

				numberOfStudents--;
				break;
			}
		}
	}
}