package ch20;


import java.util.*;

public class TestHashSet {
  public static void main(String[] args) {
    // Create a hash set
    Set<String> set = new HashSet<String>();

    // Add strings to the set
    set.add("1 London");
    set.add("2 Paris");
    set.add("3 New York");
    set.add("4 San Francisco");
    set.add("5 Beijing");
    set.add("3 New York");

    System.out.println(set);

    // Display the elements in the hash set
    for (String s: set) {
      System.out.print(s.toUpperCase() + " ");
    }
     
     System.out.println();
    
     Iterator<String> iterator = set.iterator();
     // Display the elements in the hash set using iterator
     while (iterator.hasNext()){
    	   System.out.print(iterator.next().toLowerCase()+" ");
    	   iterator.remove();
     }
    
  }
}
