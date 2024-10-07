package doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class E1546_평균 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			double avg = 0.0;
			int n = Integer.valueOf(br.readLine());
			int[] score = new int[n];
			
			// 점수 배열을 초기화
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				score[i] = Integer.valueOf(st.nextToken());
			}
			
			// 점수의 최대값 찾기
			int max = 0;
			for(int i = 0; i < n; i++) {
				max = max <= score[i] ? score[i] : max;
			}
			
			// 새로운 합계 구하기
			double sum = 0.0;
			for(int i = 0; i < n; i++) {
				sum += (double)score[i]/max*100;
			}
			
			// 새로운 평균을 출력하기
			avg = sum / n; // n을 double형으로 자동 형 변환하여 계산됨
			bw.write(String.valueOf(avg));
			bw.flush();
			bw.close();
			br.close();
			
			/*	시간 복잡도 계산하기
			 * 	-> 연산 횟수는 3n 이지만 상수는 무시함으로써 O(n)
			 *  -> 데이터의 최대 크기는 1000이므로 시간 복잡도는 1,000이다.
			 * */
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
