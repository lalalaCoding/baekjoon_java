package java_01.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("개나리");
		list.add("소나무");
		list.add("진달래");
		List<String> subList = list.subList(1, 2); // 1 <= index < 2
		System.out.println(subList);
		
		System.out.println(list.size());
		
	}
}
