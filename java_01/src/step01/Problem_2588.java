package step01;

import java.util.Scanner;

// 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
public class Problem_2588 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); // 472
		int b = sc.nextInt(); // 385
		
		int num1 = a*(b%10); // 일의 자리 수 == 10으로 나눈 나머지
		int num2 = a*((b%100)/10); // 십의 자리 수 == 100으로 나눈 나머지를 10으로 나눈 몫
		int num3 = a*(b/100); // 백의 자리 수 == 100으로 나눈 몫
		
		System.out.println(num1); 
		System.out.println(num2); 
		System.out.println(num3);
		System.out.println(num3*100 + num2*10 + num1);
	}
}
