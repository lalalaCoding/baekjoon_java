package doIt.자료구조;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class E2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //1이상 50만이하
		
		Queue<Integer> queue = new LinkedList<Integer>(); //카드를 담을 큐를 선언
		for (int i = 1; i <= N; i++) {
			queue.add(i); //큐를 초기화
		}
		
		for (int i = 1; i <= 2*N - 3; i++) {
			if(i%2 != 0) {
				queue.remove();
			} else {
				int head = queue.poll();
				queue.add(head);
			}
		}
		
		System.out.println(queue.peek());
	}
}
