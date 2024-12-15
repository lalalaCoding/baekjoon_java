package doIt.그래프.그래프표현;

import java.io.*;
import java.util.*;

public class E1707_이분그래프 {

    public static ArrayList<Integer>[] graph; //인접 리스트 배열
    public static boolean[] visited; //방문 배열
    public static int[] group; //이분 그래프 집합 배열
    public static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine()); //테스트 케이스의 수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //노드의 개수
            int E = Integer.parseInt(st.nextToken()); //엣지의 개수

            graph = new ArrayList[N + 1];
            for (int j = 0; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start_node = Integer.parseInt(st.nextToken());
                int end_node = Integer.parseInt(st.nextToken());
                graph[start_node].add(end_node);
                graph[end_node].add(start_node);
            }

            visited = new boolean[N + 1];
            group = new int[N + 1];

            //여러개의 부분 그래프로 이루어진 케이스가 있을수 있으므로 모든 노드로 깊이 우선 탐색을 실행
            result = true; //최초에 탐색을 실행하기 위하여 true로 초기화
            for (int start_node = 1; start_node <= N; start_node++) {
                if (result) DFS(start_node);
                else break; //이분 그래프가 아니면 곧바로 반복 종료
            }
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }

    /*
        깊이 우선 탐색
    */
    private static void DFS(int startNode) {
        /*
            이미 방문한 노드인 경우 같은 그룹임을 검사해야 하므로 return은 작성하지 않음
        if (visited[startNode]) {
            return;
        }
        */
        visited[startNode] = true; //탐색 노드를 방문 배열에 기록

        for (int node : graph[startNode]) { //node = 탐색 노드의 인접 노드
            //인접 노드가 미방문 노드인 경우
            if (!visited[node]) {
                group[node] = (group[startNode] + 1) % 2;
                DFS(node);
            }
            //인접 노드가 방문 노드인 경우
            else if (group[startNode] == group[node]) { //기준 노드와 인접 노드가 같은 그룹에 속하는 경우
                result = false;
            }
        }
    }
}
