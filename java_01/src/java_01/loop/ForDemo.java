package java_01.loop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ForDemo {
	
	//final double PI; 상수는 반드시 선언과 초기화가 동시에 이루어져야 한다.
	
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("개나리");
		set.add("진달래");
		set.add("소나무");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("3월", "개나리");
		map.put("4월", "진달래");
		map.put("5월", "철쭉");
		
		
		
		
		// 향상된 for 문
		for(String s : set) {
			System.out.println(s);
		}
		
		// 향상된 for 문의 동작과정
		Iterator<String> iter = set.iterator(); // Iterator 객체를 생성함
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public void test() {
		
		return;
	}
	
	
	
}
