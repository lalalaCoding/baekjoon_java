package doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class E10986_나머지합 {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st1.nextToken()); // 수열의 길이는 N, 수열의 각 항의 최대값은 10억이므로 수열의 각 항은 int형으로 처리 가능함
			int M = Integer.valueOf(st1.nextToken());
			
			//부분 합 배열 선언 (1억은 10의 9제곱)
			long[] S = new long[N]; // 부분 합의 최대값은 10^9*10^6 == 10^15으로 int형의 최대값이 21억보다 큼. 따라서 long타입 배열로 선언해야함
			//부분 합을 각각 M으로 나눈 배열
			long[] C = new long[M]; // C[i] == S[j]을 M으로 나눈 나머지가 i인 j의 개수이므로 최대값은 N 
			//int[] C = new int[M];
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			long answer = 0; // 최대값은 H(n,2) = C(n+1,2) = (n+1)*n/2 > (n의 제곱) / 2 = (10의 12제곱) / 2 > 21억. 따라서 long 타입 변수 선언
			
			//부분 합 배열 초기화
			for(int i = 0; i < N; i++) {
				if(i == 0) {
					S[i] = Integer.parseInt(st2.nextToken());
				}
				else {
					S[i] = S[i - 1] + Integer.valueOf(st2.nextToken());
				}
			}
			
			
			for(int i = 0; i < N; i++) {
				int remain = (int)(S[i] % M); // 연산 순서 : 최 -> 단 -> 형 변환 -> 산 -> 비 ...
				if(remain == 0) {
					answer++;
				}
				C[remain]++;
			}
			
			for(int i = 0; i < M; i++) {
				if(C[i] > 1) {
					answer = answer + (C[i] * (C[i] - 1)) / 2;
				}
			}
			
			bw.write(String.valueOf(answer));
			bw.flush();
			bw.close();
			br.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
