package doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque; //인터페이스
import java.util.LinkedList; // Deque의 구현체

public class E11003_최솟값찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//여러번 출력해야 하기 때문에 BufferedWriter를 사용한다.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //수열의 길이 -> 덱에 데이터를 삽입/삭제할 반복횟수
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " "); //수열을 토큰으로 저장
		Deque<Node> myDeque = new LinkedList<Node>();
		
		for(int i = 0; i < N; i++) { //덱에 데이터를 삽입 또는 삭제하는 반복문
			//덱의 오른쪽에서 데이터를 삽입
			int now = Integer.parseInt(st.nextToken()); //수열의 새로운 값
			while(!myDeque.isEmpty() && myDeque.getLast().value > now) {
				//덱이 비어 있지 않으면서,
				//덱의 마지막 Node의 value가 새로운 값보다 크다면 최소값을 구하는데 필요없으므로 제거함.
				myDeque.removeLast();
			}
			
			myDeque.addLast(new Node(i, now)); //덱에 새로운 데이터를 삽입
			
			//덱의 첫 번째 노드의 인덱스가 윈도우의 범위를 벗어나면, 첫 번째 노드를 제거한다.
			if(i - myDeque.getFirst().index >= L) {
				myDeque.removeFirst();
			}
			//덱의 첫 번째 노드의 value가 현재 윈도우에서의 최소값이 된다.
			bw.write(myDeque.getFirst().value + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	// (인덱스, 값)에 대한 Node 클래스를 '정적 중첩 클래스'로 작성
	// 그 이유는, Node 객체를 1번만 메모리에 로드 시킨 후 상태를 변화시키는 것이 메모리가 효율적이기 때문임
	static class Node {
		public int index;
		public int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}


