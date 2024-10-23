package doIt.자료구조;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class E11286_절댓값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//PriorityQueue<E>는 Queue<E> 인터페이스의 구현체
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(new AlsoluteComparator());
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(pQueue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pQueue.poll());
				}
			} else {
				pQueue.add(request);
			}
		}
	}
	
	//정렬 기준 클래스 정의
	static class AlsoluteComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1 != abs2) { //절대값에 따라 오름차순
				return abs1 - abs2;
			} else { //절대값이 같은 경우 수에 따라 오름차순
				return o1 > o2 ? 1 : -1;
			}
		}
	}
}
