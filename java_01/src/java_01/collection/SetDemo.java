package java_01.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		// removeAll 테스트
		Set<String> set = new HashSet<String>();
		
		set.add("개나리");
		set.add("소나무");
		set.add("무궁화");
		
		List<String> list = new ArrayList<String>();
		
		list.add("ch");
		
		
		boolean result = set.removeAll(list);
		
		System.out.println(set);
		System.out.println(list);
		System.out.println(result);
		
		
		
		
		
		
		
		
		
	}
}