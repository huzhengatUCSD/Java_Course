package ch19;

import java.util.*;
import ch13.Circle;


public class TestArrayListNew {
  public static void main(String[] args) {
    // Create a list to store cities
    ArrayList<String> cityList = new ArrayList<>();

    // Add some cities in the list
    cityList.add("London");
    cityList.add("New York");
    cityList.add("Paris");
    cityList.add("Toronto");
    cityList.add("Hong Kong");
    cityList.add("Singapore");
    cityList.add(new Integer(1));

    System.out.println("List size? " + cityList.size());
    System.out.println("Is Toronto in the list? " +
      cityList.contains("Toronto"));
    System.out.println("The location of New York in the list? "
      + cityList.indexOf("New York"));
    System.out.println("Is the list empty? " +
      cityList.isEmpty()); // Print false

    // Insert a new city at index 2
    cityList.add(2, "Beijing");

    // Remove a city from the list
    cityList.remove("Toronto");

    // Remove a city at index 1
    cityList.remove(1);

    // Display London, Beijing, Paris, HongKong, Singapore
    for (int i = 0; i < cityList.size(); i++)
      System.out.print(cityList.get(i) + " ");
    System.out.println();

    // Create a list to store two circles
    ArrayList<Circle> list = new ArrayList<>();

    // Add a circle and a cylinder
    list.add(new Circle(2));
    list.add(new Circle(3));
    list.add("");
    // Display the area of the first circle in the list
    System.out.println("The area of the circle? " +
      (list.get(0)).getArea());
  }
}
