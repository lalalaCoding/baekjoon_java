package java_01.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MapDemo {
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("짱구", "5세");
		map.put("개나리", "35세");
		
		System.out.println(map.values());;
		
		
		Object[] arr = new Object[5];
		arr[0] = "개나리";
		arr[1] = new Integer(1);
		System.out.println(Arrays.toString(arr));
		
		
		
	}
}
