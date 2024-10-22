package java_01.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

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
		
		
		Properties prop = new Properties();
		prop.setProperty("이름", "개나리");
		
		Set<Object> pSet = prop.keySet(); //제네릭이 Object임에 주의!
		
		
		
	}
}
