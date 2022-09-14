package ch20;


import java.util.*;

public class TestMap {
  public static void main(String[] args) {
    // Create a HashMap
    Map<String, Integer> hashMap = new HashMap<String, Integer>();
    hashMap.put("Smith", 30);
    hashMap.put("Anderson", 31);
    hashMap.put("Lewis", 29);
    hashMap.put("Cook", 29);

    System.out.println("Display entries in HashMap");
    System.out.println(hashMap + "\n");

    // Create a TreeMap from the preceding HashMap
    Map<String, Integer> treeMap = 
      new TreeMap<String, Integer>(hashMap);
    System.out.println("Display entries in ascending order of key");
    System.out.println(treeMap);


    // Create a LinkedHashMap
    Map<String, Integer> linkedHashMap =
      new LinkedHashMap<String, Integer>(16, 0.75f, false);
    linkedHashMap.put("Smith", 30);
    linkedHashMap.put("Anderson", 31);
    linkedHashMap.put("Lewis", 29);
    linkedHashMap.put("Cook", 29);

    System.out.println("Display entries in LinkedHashMap");
    System.out.println(linkedHashMap);
    
    // Display the age for Lewis
    System.out.println("\nThe age for " + "Lewis is " +
      linkedHashMap.get("Lewis"));
    System.out.println("\nThe age for " + "Smith is " +
    	      linkedHashMap.get("Smith"));
    
    System.out.println("Display entries in LinkedHashMap");
    System.out.println(linkedHashMap);
  }
}
