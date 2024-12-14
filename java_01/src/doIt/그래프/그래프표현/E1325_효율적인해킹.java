package doIt.그래프.그래프표현;

import java.io.*;
import java.util.*;
/*
    "3 1" : 3번 노드가 1번 노드를 신뢰함 : 3 -> 1
*/
public class E1325_효율적인해킹 {

    public static ArrayList<Integer>[] graph; //인접 리스트 배열
    public static boolean[] visited; //방문 배열
    public static int[] result; //자신으로 오는 노드에 대한 경우의 수를 저장하는 배열
                                //result[2] = 3 : 2번 노드를 해킹하면 다른 3개의 노드도 같이 해킹된다.
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //노드의 개수
        int M = Integer.parseInt(st.nextToken()); //단방향 엣지의 개수
        
        //인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1]; //방문 배열 초기화
            BFS(i); //깊이 우선 탐색
        }

        //도착하는 경우의 수에 대한 최대값 찾기
        int[] order_result = Arrays.copyOf(result, result.length);
        Arrays.sort(order_result);
        int max_count = order_result[N];
        
        //최대 경우의 수를 갖는 노드 출력하기
        for (int i = 1; i <= N; i++) {
            if (result[i] == max_count) {
                System.out.print(i + " ");
            }
        }
    }
    
    /*
        깊이 우선 탐색 메서드
    */
    private static void BFS(int start_node) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start_node); //탐색 할 삽입
        visited[start_node] = true; //방문 기록
        
        while (!queue.isEmpty()) {
            int node = queue.poll(); //기준 노드 꺼내기
            for (int i = 0; i < graph[node].size(); i++) {
                if (!visited[graph[node].get(i)]) {
                    queue.add(graph[node].get(i)); //기준 노드의 인접 노드를 큐에 삽입
                    visited[graph[node].get(i)] = true; // 기준 노드의 인접 노드에 대한 방문을 기록
                    result[graph[node].get(i)]++;
                }
            }
        }
    }
}
