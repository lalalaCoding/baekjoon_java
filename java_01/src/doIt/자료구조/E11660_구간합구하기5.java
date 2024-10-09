package doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class E11660_구간합구하기5 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st1.nextToken()); // n행 n열
			int cnt = Integer.valueOf(st1.nextToken()); // 합 계산 횟수
			
			// x1 y1 x2 y2 -> x1행의 y1열~y2열까지의 합 + ... + x2행의 y1열~y2열까지의 합
			
			// n행 n열의 배열을 선언
			int[][] arr = new int[n][n]; 
			// n행 n+1열의 합 배열을 선언
			int[][] sum = new int[n][n+1];

			// n행 n열의 배열을 초기화
			for(int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
					//sum[i][j+1] -> arr의 i행 1열 + ... + i행 j열
					sum[i][j+1] = sum[i][j] + arr[i][j]; 
				}
			} // O(N*N)
			
			for(int i = 0; i < cnt; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
				int x1 = Integer.parseInt(st3.nextToken()); 
				int y1 = Integer.parseInt(st3.nextToken()); 
				int x2 = Integer.parseInt(st3.nextToken()); 
				int y2 = Integer.parseInt(st3.nextToken()); 
				
				int result = 0;
				for(int j = x1; j <= x2; j++) {
					// j번째 행의 y1번째 열 ~ y2번째 열까지의 합
					result += sum[j-1][y2] - sum[j-1][y1-1];
				}
				
				bw.write(String.valueOf(result + "\n"));
			} // O(M*N)
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
