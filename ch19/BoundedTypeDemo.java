package ch19;


import ch13.*;

public class BoundedTypeDemo {
  public static void main(String[] args ) {
    Rectangle rectangle = new Rectangle(java.lang.Math.PI, 4);
    Circle circle = new Circle(2);

    System.out.println("Same area? " +
    		equalArea(rectangle, circle));
  }

  public static <E extends GeometricObject> boolean equalArea(
		  E o1, E o2) {
    return o1.getArea() == o2.getArea();
  }
}
