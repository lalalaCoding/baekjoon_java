package doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class E12891_DNA비밀번호 {
	
	public static int[] myArr = new int[4];//현재 상태 배열 선언 -> 순서대로 A,C,G,T의 갯수를 저장
	public static int[] checkArr = new int[4];//검사 기준 배열 선언 -> 순서대로 A,C,G,T의 갯수를 저장
	public static int checkSecret = 0;//기준을 통과한 현재 배열의 인덱스의 개수 -> 4이면 Result를 1 증가시킴
	public static int Result = 0;//경우의 수 저장할 변수 선언 및 초기화
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st1.nextToken());//문자열의 길이 -> P 이상 100만이하
			int P = Integer.valueOf(st1.nextToken());//부분 문자열의 길이 -> 1 이상 S이하
			String str = br.readLine();//전체 문자열
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 4; i++) {
				checkArr[i] = Integer.parseInt(st2.nextToken());//검사 기준 배열 초기화
			}
			
			char[] C = str.substring(0, P).toCharArray();
			
			for(char ch : C) {//현재 상태 배열 초기화
				switch(ch) {
				case 'A' : myArr[0]++; break;
				case 'C' : myArr[1]++; break;
				case 'G' : myArr[2]++; break;
				case 'T' : myArr[3]++; break;
				}
			}
			calcResult();
			
			for(int i = 0; i < S - P; i++) {//i = 1; i <= 2; i++
				add(str.charAt(i + P));//문자 더하기 
				remove(str.charAt(i));// 문자 빼기
				calcResult();
			}
			
			System.out.println(Result);
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void remove(char c) {
		switch(c) {
		case 'A' : myArr[0]--; break;
		case 'C' : myArr[1]--; break;
		case 'G' : myArr[2]--; break;
		case 'T' : myArr[3]--; break;
		}
	}

	private static void add(char c) {
		switch(c) {
		case 'A' : myArr[0]++; break;
		case 'C' : myArr[1]++; break;
		case 'G' : myArr[2]++; break;
		case 'T' : myArr[3]++; break;
		}
	}

	//현재와 기준 배열을 비교하여 일치하는 개수를 계산해주는 기능
	private static void calcResult() {
		checkSecret = 0;//현재 문자열이 변경되었으므로 현재와 기준을 비교하는 인덱스의 갯수를 0으로 변경!
		for(int i = 0; i < 4; i++) {
			if(myArr[i] >= checkArr[i]) checkSecret++;//
		}
		
		if(checkSecret == 4) {
			Result++;
		}
	}
}
