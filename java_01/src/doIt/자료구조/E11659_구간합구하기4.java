package doIt.자료구조;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E11659_구간합구하기4 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int length = Integer.valueOf(st.nextToken());
			int count = Integer.valueOf(st.nextToken());
			
			int[] a = new int[length]; //원본 배열 선언
			int[] s = new int[length]; //합 배열 선언
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < length; i++) {
				a[i] = Integer.valueOf(st2.nextToken()); //원본 배열 초기화
				if(i == 0) {
					s[i] = a[i];
				} else {
					s[i] = s[i-1] + a[i];
				}
			}
			
			System.out.println(Arrays.toString(s));
			
			for(int i = 0; i < count; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
				//"1 3" -> a[0]+a[1]+a[2] -> s[2]
				//"2 4" -> a[1]+a[2]+a[3] -> s[3] - s[0]
				int begin = Integer.valueOf(st3.nextToken()) - 1; // n번째는 인덱스로는 n-1을 가르킴
				int end = Integer.valueOf(st3.nextToken()) - 1; 
				
				if(begin == 0) {
					bw.write(String.valueOf(s[end]) + "\n");
				} else if(begin == end) {
					bw.write(String.valueOf(a[end]) + "\n");
				} else {
					bw.write(String.valueOf(s[end] - s[begin - 1]) + "\n");
				}
			}
			bw.flush();
			bw.close();
			br.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
