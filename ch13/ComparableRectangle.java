package ch13;

public class ComparableRectangle extends Rectangle 
    implements Comparable<ComparableRectangle> {
  /** Construct a ComparableRectangle with specified properties */
  public ComparableRectangle(double width, double height) {
    super(width, height);
  }

  @Override // Implement the compareTo method defined in Comparable 
  public int compareTo(ComparableRectangle o) {
    /*if (getArea() > o.getArea())
      return 1;
    else if (getArea() < o.getArea())
      return -1;
    else
      return 0;*/

    return Double.compare(getArea(),o.getArea());
  }
  
  @Override // Implement the toString method in GeometricObject
  public String toString() {
    return "Width: " + getWidth() + " Height: " + getHeight() +
      " Area: " + getArea();
  }

  @Override
  public boolean equals(Object otherObject)
  {
    // test whether the fields have identical values
    if (this == otherObject) return true;

    // must return false if the explicit parameter is null
    if (otherObject == null) return false;

    // if the classes don't match, they can't be equal
    if (getClass() != otherObject.getClass()) return false;

    ComparableRectangle other=(ComparableRectangle)otherObject;

    return getArea()==other.getArea();

  }

  public int hashCode()
  {
    return (int)getArea();
  }

}
