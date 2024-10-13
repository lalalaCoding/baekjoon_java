package doIt.자료구조;

import java.util.Scanner;

public class E2018_수들의합5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N의 최대값은 1,000만
		int count = 1; // 구하는 경우의 수
		int sum = 1; // 연속된 자연수의 합에 대한 변수
		
		int start_index = 1; // 부분 합에 대한 시작 숫자
		int end_index = 1; // 부분 합에 대한 끝 숫자
		
		while(end_index != N) {
			if(sum > N) { // 현재 연속된 합이 N보다 큼
				sum = sum - start_index; // 부분 합의 시작 값 보정
				start_index++;// 시작 값을 1 증가
			} else if(sum < N) { // 현재 연속된 합이 N보다 작음
				end_index++; // 끝 숫자를 1 증가
				sum = sum + end_index; // 부분 합을 다시 계산
			} else { // 현재 연속된 합이 N과 같음
				count++; // 경우의 수를 1 증가
				end_index++; // 끝 숫자를 1 증가
				sum = sum + end_index; // 부분 합 다시 계산
			}
		}
		
		System.out.println(String.valueOf(count));
		
		
	}
}
