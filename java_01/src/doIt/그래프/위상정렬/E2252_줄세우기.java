package doIt.그래프.위상정렬;

import java.util.*;

public class E2252_줄세우기 {

    public static ArrayList<Integer>[] graph; //그래프: 인접 리스트
    public static int[] inDegree; //진입 차수 배열
    public static Queue<Integer> queue = new LinkedList<Integer>(); //위상 정렬 결과를 저장할 큐

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //학생(노드)의 수
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int M = sc.nextInt(); //비교(엣지)의 수
        for (int i = 1; i <= M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
        }
        
        //진입 차수 배열 초기화
        inDegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                inDegree[graph[i].get(j)]++;
            }
        }
        
        //위상 정렬 수행
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); //진입 차수가 0인 노드를 큐에 차례로 삽입
            }
        }

        while(!queue.isEmpty()) {
            int now_node = queue.poll(); //큐의 head에 있는 데이터 꺼내기
            System.out.print(now_node + " ");

            for (int next_node : graph[now_node]) {
                inDegree[next_node]--; //인접 노드들의 진입 차수 1씩 빼기
                if (inDegree[next_node] == 0) { //인접 노드의 진입 차수가 0인 경우(자신보다 작은 학생이 없다는 의미)
                    queue.offer(next_node); //인접 노드를 삽입
                }
            }
        }
    }
}
