package java_review;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Index {
	public static void main(String[] args) {
		
		//ArrayCopy arrayCopy = new ArrayCopy();
		//arrayCopy.arrayCopy();
		
		//ScopeDemo scope = new ScopeDemo();
		
		String str = "abc";
		String[] arr = str.split(""); // 한글자씩 자를 수 있음!
		System.out.println(arr[0]);
		
		StringTokenizer st = new StringTokenizer(str, "[]");
		System.out.println(st.nextToken()); // 한글자씩 자를 수 없음
		
		int aCode = 'a';
		System.out.println(aCode);
		char a = (char)aCode;
		System.out.println(a);
		
		
		// String.split(" ") 을 테스트하자.
		String[] arr1 = " ".split(" ");
		System.out.println(Arrays.toString(arr1)); // [] -> 길이 0인 문자열 배열
		
		String[] arr2 = " 개 나 리".split(" ");
		System.out.println(Arrays.toString(arr2)); // [, 개, 나, 리] -> 길이 4인 문자열 배열
		
		String[] arr3 = " 개 나 리 ".split(" ");
		System.out.println(Arrays.toString(arr3)); // [, 개, 나, 리] -> 길이 4인 문자열 배열
		
		
		// StringBuffer도 파싱이 될까?
		StringBuffer sb = new StringBuffer("123");
//		System.out.println(Integer.parseInt(sb)); // 안됨
		String str1 = sb.toString();
		System.out.println(str1);
		
		// String.contains() 테스트
		System.out.println("ABC".contains("A"));
		
		// StringBuffer
		StringBuffer sb1 = new StringBuffer("123");
		System.out.println(sb.toString().equals(sb1.toString()));
		
		
	}
}
