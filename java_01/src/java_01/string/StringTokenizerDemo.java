package java_01.string;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
	public static void main(String[] args) {
		String str = "안_녕+하/세.요?";
		StringTokenizer st = new StringTokenizer(str, "_"); // 토큰 -> 안, 녕+하/세.요?
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		
	}
}
