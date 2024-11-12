package doIt.탐색;

import java.io.*;
import java.util.*;

public class E1167_트리의지름 {

    private static ArrayList<Edge>[] A; //인접 리스트
    private static boolean[] visited; //방문 배열
    private static int[] distance; //거리 배열

    public static void main(String[] args) throws Exception {
        //가중치 있는 무향 그래프 -> 인접 리스트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //노드 개수
        A = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end;
            while ((end = Integer.parseInt(st.nextToken())) > 0) {
                A[start].add(new Edge(end, Integer.parseInt(st.nextToken())));
            }
        }

        BFS(1); //임의의 점에서 각 노드에 도착하기 까지의 거리를 측정한다.
        int max = 1; // 1번 노드로부터 가장 거리가 먼 노드를 찾는다.
        for (int i = 2; i < N + 1; i++) {
            if (distance[i] > distance[max]) {
                max = i;
            }
        }

        distance = new int[N + 1]; //거리 배열 초기화
        visited = new boolean[N + 1]; //방문 배열 초기화
        BFS(max); // 1번 노드로부터 가장 거리가 먼 노드로부터 다시 거리를 측정한다.
        //최대 길이를 출력한다.
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static class Edge {
        private int end; //도착 노드
        private int value; //가중치

        public Edge(int end, int value) {
            this.end = end;
            this.value = value;
        }

        public int getEnd() {
            return this.end;
        }
        public int getValue() {
            return this.value;
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true; //방문 기록

        while (!queue.isEmpty()) {
            int cur = queue.poll(); //기준 노드를 꺼낸다.
            ArrayList<Edge> edges = A[cur];
            for (Edge edge : edges) {
                int end = edge.getEnd();
                if (!visited[end]) {
                    queue.add(end); //기준 노드에 대한 인접 노드를 큐에 삽입
                    visited[end] = true; //방문 기록
                    distance[end] = distance[cur] + edge.getValue(); //시작 노드부터의 거리를 저장
                }
            }
        }
    }
}
