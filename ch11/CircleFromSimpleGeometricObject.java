package ch11;

public class CircleFromSimpleGeometricObject 
    extends SimpleGeometricObject {
  private double radius;

  public CircleFromSimpleGeometricObject() {
  }

  public CircleFromSimpleGeometricObject(double radius) {
    this.radius = radius;
  }

  public CircleFromSimpleGeometricObject(double radius, 
      String color, boolean filled) {
	super(color,filled);
    this.radius = radius;
    //setColor(color); // using this.color= color is illegal 
    //setFilled(filled); //using this.filled = filled is illegal 
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }
  
  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }
  
  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /* Print the circle info */
  public void printCircle() {
    System.out.println("The circle is created " + super.getDateCreated() +
      " and the radius is " + radius);
  }
  
  
  @Override
  public String toString(){
	  return super.toString() + "\nradius is "+ radius+"\nArea is "+getArea();
  }
  
  @Override
  public void display(){
	  System.out.println("The circle area is " +
			  this.getArea());
	  System.out.println("The circle diameter is " +
			  this.getDiameter());
  }
}


