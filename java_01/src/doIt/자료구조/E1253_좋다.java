package doIt.자료구조;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E1253_좋다 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.valueOf(br.readLine()); // 1이상 2,000이하
			int Result = 0; // 경우의 수
			long[] A = new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < A.length; i++) {
				A[i] = Long.valueOf(st.nextToken()); // 숫자 배열 초기화, 절대값이 10억 이하
			}
			Arrays.sort(A); // 숫자 배열을 오름차순 정렬
			
			for(int k = 0; k < N; k++) {
				long find = A[k]; // 비교 기준이 되는 수를 초기화
				int i = 0; // 첫 번째 인덱스
				int j = N - 1; // 두 번째 인덱스
				
				// 투 포인터 알고리즘 적용
				while(i < j) {
					if(A[i] + A[j] == find) { // 비교 기준과 두 수의 합이 같은 경우
						if(i != k && j != k) { // 두 수 모두 비교 기준과 다른 대상 (유효)
							Result++;
							break;
						} else if(i == k) { // 첫 번째 수가 비교 기준과 같은 대상 (무효)
							i++;
						} else {
							j--;
						}
					} else if(A[i] + A[j] < find){ //비교 기준보다 두 수의 합이 작은 경우
						i++;
					} else {//비교 기준보다 두 수의 합이 큰 경우
						j--;
					}
				}
			}
			
			System.out.println(Result);
			br.close(); //리소스 해제
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
