package doIt.자료구조;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
//1부터 n까지의 정수를 오름차순으로 저장할 수 있는 스택을 통해 입력받은 수열을 표현할 수 있겠는가의 문제다.
public class E1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(""); //java.lang.StringBuffer
		boolean result = true; //스택으로 수열을 표현할 수 있는가에 대한 플래그
		
		int N = sc.nextInt(); //1 이상 10만 이하
		Stack<Integer> stack = new Stack<Integer>();
		
		int[] A = new int[N]; //수열 선언
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt(); //수열 초기화
		}
		
		int num = 1; //오름차순 자연수 선언 및 초기화 -> 현재 스택에 넣으려는 값
		for(int i = 0; i < N; i++) {
			int present = A[i]; //수열의 현재 값 -> 4
			
			if(present >= num) { 
				/*
				 	'스택에 넣으려는 값 num'보다 '수열의 항의 값 present'가 크거나 같음
					1.스택에 num부터 present까지 푸시
					2.스택에서 팝 
				*/
				
				//스택 : 1, 2, 3, ..., present
				//스택에 넣으려는 자연수 : present + 1
				while(present >= num) {
					stack.push(num);
					num++;
					sb.append("+\n");
				} 
				stack.pop();
				sb.append("-\n");
			} else {
				/*
					'스택에 넣으려는 값 num'보다 '수열의 항의 값 present'가 작음
					-> top = num - 1, present <= (num - 1)
					-> 스택 안에 present가 존재하지 않으면 스택으로 수열을 표현할 수 없는 상황!
					1.스택에서 top의 값이 present보다 큰 경우?
						persent를 꺼내기 위해서 pop()을 반복하게 되는데,
						이럴 경우 추후에 뽑아야할 수열의 항에 대한 값이 소실되기 때문이다.
					2.스택에서 top의 값이 present과 같은 경우?
						pop()을 하면 됨!
				*/
				int top = stack.pop();
				if(top > present) {
					result = false;
					break;
				} else {
					sb.append("-\n");
				}
			}
		}
		
		if(result) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
