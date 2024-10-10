package doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class E10986_나머지합 {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st1.nextToken()); // 수열의 길이
			int M = Integer.valueOf(st1.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			
			long answer = 0;
			
			//부분 합 배열 선언
			long[] S = new long[N]; 
			//부분 합 배열 초기화
			for(int i = 0; i < N; i++) {
				if(i == 0) {
					S[i] = Integer.parseInt(st2.nextToken());
				}
				else {
					S[i] = S[i - 1] + Integer.valueOf(st2.nextToken());
				}
			}
			
			//부분 합을 각각 M으로 나눈 배열
			long[] C = new long[M];
			for(int i = 0; i < N; i++) {
				int remain = (int)(S[i] % M);
				if(remain == 0) {
					answer++;
				}
				C[remain]++;
			}
			
			for(int i = 0; i < M; i++) {
				if(C[i] > 1) {
					answer = answer + (C[i]*(C[i] - 1))/2;
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
