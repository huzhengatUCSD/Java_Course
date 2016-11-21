package ch11;

import java.util.*;

public class TestArrayListNew {
	public static void main(String[] args) {
		String[] array = {"red", "green", "blue"};
		System.out.println(array[0]+" "+array[1]+" "+array[2]);
		ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
		System.out.println(list);
		String[] array1 = new String[list.size()];
		list.toArray(array1);
		System.out.println(array1[0]+" "+array1[1]+" "+array1[2]);
		Integer[] array2 = {3, 5, 95, 4, 15, 34, 3, 6, 5};
		ArrayList<Integer> list1 = new   
				ArrayList<>(Arrays.asList(array2));
		java.util.Collections.shuffle(list1);
		System.out.println(list1);

	}
}
