package ch12;

public class TestCircleWithRadiusException {
  /** Main method */
  public static void main(String[] args) {
    try {
      CircleWithRadiusException c1 = new CircleWithRadiusException(5);
      c1.setRadius(-15);
      CircleWithRadiusException c2 = new CircleWithRadiusException(0);
    }
    catch (InvalidRadiusException ex) {
      System.out.println(ex);
    }

    System.out.println("Number of objects created: " +
      CircleWithRadiusException.getNumberOfObjects());
  }
}
