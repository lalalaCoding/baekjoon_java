package doIt.자료구조;

import java.util.Scanner;
import java.util.StringTokenizer;

public class E1940_주몽 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //최대값 15,000
		int M = sc.nextInt(); //최대값 1,000만
		sc.nextLine(); // 버퍼 공간 클리어
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		
		int[] arr = new int[st.countTokens()]; // 숫자 배열 선언
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(st.nextToken()); // 숫자 배열 초기화
		}
		
		int count = 0;
		if(arr.length == 1) {
			System.out.println(String.valueOf(count));
		} else {
			int first_index = 0;
			int second_index = first_index + 1;
			int sum = arr[first_index] + arr[second_index];
			
			while(true) {
				if(sum != M) {//합이 M과 다름
					if(second_index != arr.length - 1) { //2번째 인덱스가 배열의 끝이 아님
						second_index++;
					} else {//2번째 인덱스가 배열의 끝
						if(first_index == arr.length - 2) { //1번째 인덱스가 배열의 끝에서 2번째임
							break;
						} else {
							first_index++;
							second_index = first_index + 1;
						}
					}
				} else {//합이 M과 같음
					count++;
					if(second_index != arr.length - 1) { //2번째 인덱스가 배열의 끝이 아님
						second_index++;
					} else {//2번째 인덱스가 배열의 끝
						if(first_index == arr.length - 2) { //1번째 인덱스가 배열의 끝에서 2번째임
							break;
						} else {
							first_index++;
							second_index = first_index + 1;
						}
					}
				}
				
				sum = arr[first_index] + arr[second_index];
			}
			
			// 결과 출력
			System.out.println(String.valueOf(count));
		}
	}
}
