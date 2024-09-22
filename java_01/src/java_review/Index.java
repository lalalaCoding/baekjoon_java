package java_review;

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
		
		
		// 
		StringBuffer sb = new StringBuffer("");
		sb.append("\\");
		
		String test = "\\abc";
		System.out.println(sb);
		
		
		
	}
}
