package ch09;

// Define the circle class with two constructors
public class SimpleCircle1 {
  double radius;

  /** Construct a circle with radius 1 */
  SimpleCircle1() {
    radius = 1;
  }

  /** Construct a circle with a specified radius */
  SimpleCircle1(double newRadius) {
    radius = newRadius;
  }

  /** Return the area of this circle */
  double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return the perimeter of this circle */
  double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /** Set a new radius for this circle */
  void setRadius(double newRadius) {
    radius = newRadius;
  }
}

class TestSimpleCircle {
	  /** Main method */
	  public static void main(String[] args) {
	    // Create a circle with radius 1
	    SimpleCircle1 circle1 = new SimpleCircle1();
	    System.out.println("The area of the circle of radius "
	      + circle1.radius + " is " + circle1.getArea());

	    // Create a circle with radius 25
	    SimpleCircle1 circle2 = new SimpleCircle1(25);
	    System.out.println("The area of the circle of radius "
	      + circle2.radius + " is " + circle2.getArea());

	    // Create a circle with radius 125
	    SimpleCircle1 circle3 = new SimpleCircle1(125);
	    System.out.println("The area of the circle of radius "
	      + circle3.radius + " is " + circle3.getArea());

	    // Modify circle radius
	    circle2.setRadius(250); // this usage is preferred    
	    // or circle2.radius = 250; 
	    System.out.println("The area of the circle of radius "
	      + circle2.radius + " is " + circle2.getArea());
	  }
}
