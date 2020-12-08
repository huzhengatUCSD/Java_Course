package ch20;

import java.util.*;

public class CountOccurrenceOfWords {
  public static void main(String[] args) {
    // Set text in a string
    String text = "Good morning. Have a good class. Afternoon. Have a good time. " +
      "Have a good visit. Have fun!\r\n"
      + "Lunar samples collected by China's Chang'e 5 robotic probe will soon start their journey toward Earth, according to the China National Space Administration.\r\n" + 
      "\r\n" + 
      "The rocks and dust from the moon have been delivered from Chang'e 5's ascender to their final host－the probe's reentry capsule, which will later bring them to Earth.\r\n" + 
      "\r\n" + 
      "The 400-kilogram ascender docked with the 2.3-metric ton orbiter-reentry capsule combination early on Sunday morning and then transferred a sealed container holding 2 kilograms of lunar samples into the capsule.\r\n" + 
      "\r\n" + 
      "The operation was the first automated rendezvous and docking of any spacecraft in lunar orbit.\r\n" + 
      "\r\n" + 
      "The last time two components of a spacecraft docked with each other in lunar orbit was in December 1972 during the final Apollo mission, and that was monitored and controlled by astronauts.\r\n" + 
      "\r\n";

    // Create a TreeMap to hold words as key and count as value
    

    Map<String, Integer> map = new TreeMap<String, Integer>();
 
    String[] words = text.split("[ \n\t\r.,;:!?(){}]");
    for (int i = 0; i < words.length; i++) {
      String key = words[i].toLowerCase();
      
      if (key.length() > 0) {
        if (!map.containsKey(key)) {
          map.put(key, 1);
        }
        else {
          int value = map.get(key);
          value++;
          map.put(key, value);
        }
      }
    }

    // Get all entries into a set
    // 默认情况下，TreeMap对key进行升序排序
  	System.out.println("------------默认map按照key升序排序--------------------");
    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
    for (Map.Entry<String, Integer> entry: entrySet)
      System.out.println(entry.getKey() + "\t" + entry.getValue());
 
    //map转换成list进行排序
 	List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
 		// 排序
 	Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
		@Override
		public int compare(Map.Entry<String, Integer> o1,
				Map.Entry<String, Integer> o2) {
			// TODO Auto-generated method stub
			return o2.getValue()-o1.getValue();
		}
	});
 		// TreeMap对value进行降序排序
 	System.out.println("------------map按照value降序排序--------------------");

    // Get key and value from each entry
    for (Map.Entry<String, Integer> entry: list)
      System.out.println(entry.getKey() + "\t" + entry.getValue());
  }
}
