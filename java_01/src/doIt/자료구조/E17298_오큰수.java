package doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class E17298_오큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine()); //수열의 크기, 1 이상 100만 이하 -> 중첩 반복 불가
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] A = new int[N]; //수열 선언
		int[] ans = new int[N]; //정답 배열 선언
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); //수열 초기화
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0); //스택에 첫 인덱스를 푸시
		for(int i = 1; i < N; i++) {
			//스택의 피크에 대한 수열 값보다 새로 넣을 수열 값이 큰 경우는 '오큰수'
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				ans[stack.pop()] = A[i];
			}
			//스택에 다음 인덱스를 푸시
			stack.push(i);
		}
		
		//스택에 저장된 인덱스들은 '오큰수'가 없는 경우
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		//결과 출력
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < N; i++) {
			if(i != N - 1) {
				sb.append(ans[i] + " ");
			} else {
				sb.append(ans[i]);
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
