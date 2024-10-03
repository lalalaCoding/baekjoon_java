package java_01.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class SortTest implements Comparable<SortTest>{
	private String name;
	private int age;
	
	public SortTest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(SortTest o) {
		Integer standard = this.age;
		Integer obj = o.getAge();
		
		
		return -standard.compareTo(obj); // age의 값을 기준으로 내림차순 정렬
	}
	
	public int getAge() {
		return this.age;
	}

	
	
	
}



public class ListDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("개나리");
		list.add("소나무");
		list.add("진달래");
		List<String> subList = list.subList(1, 2); // 1 <= index < 2
		//System.out.println(subList);
		
		//System.out.println(list.size());
		
		// List 정렬 테스트
		ArrayList<SortTest> sortTest = new ArrayList<SortTest>();
		sortTest.add(new SortTest("짱구", 5));
		sortTest.add(new SortTest("도라에몽", 100));
		//System.out.println(sortTest);
		Collections.sort(sortTest);
		
		// List 초기화 테스트
		ArrayList<String> list100 = new ArrayList<String>();
		System.out.println(list100);
		
		HashSet<String> set = new HashSet<String>();
		System.out.println(set);
	}
}
