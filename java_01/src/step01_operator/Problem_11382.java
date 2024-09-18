package step01_operator;

import java.util.Scanner;
//꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!
//입력 : 첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 10^12)이 공백을 사이에 두고 주어진다.
public class Problem_11382 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); 
		String[] arr = str.split(" ");
		long[] numArr = new long[3]; // int자료형은 약 21억까지만 저장가능하기 때문에 값이 10^12일 때 런타임에러가 발생한다.
		
		for(int i = 0; i < arr.length; i++) {
			numArr[i] = Long.parseLong(arr[i]);
		}
		
		System.out.println(numArr[0] + numArr[1] + numArr[2]);
	
	}
}
