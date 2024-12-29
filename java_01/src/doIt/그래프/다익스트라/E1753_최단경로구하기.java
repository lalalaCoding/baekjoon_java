package doIt.그래프.다익스트라;

import java.util.*;

public class E1753_최단경로구하기 {

    public static boolean[] visited; //방문 배열
    public static ArrayList<MyNode>[] graph; //그래프: 인접 리스트
    public static int[] distance; //최단 경로 배열
    public static PriorityQueue<MyNode> pq = new PriorityQueue<>(); //현재 최단 거리인 노드가 선택될 수 있게 우선순위 큐 자료구조 사용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(); //정점의 개수
        visited = new boolean[v + 1];
        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        int e = sc.nextInt(); //엣지의 개수
        int start = sc.nextInt(); //시작 노드

        distance = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            if (i == start) {
                distance[i] = 0;
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < e; i++) {
            int begin_node = sc.nextInt();
            int end_node = sc.nextInt();
            int value = sc.nextInt();
            graph[begin_node].add(new MyNode(end_node, value));
        }

        //다익스트라 구현
        pq.offer(new MyNode(start, 0));
        while (!pq.isEmpty()) {
            MyNode current = pq.poll(); //탐색 기준 노드 정보 꺼내기: 최단 거리 노드가 항상 선택됨
            int c_v = current.node; //탐색 기준 노드

            if (visited[c_v]) { //이미 방문 -> 건너뛰기
                continue;
            }
            visited[c_v] = true; //이미 방문x -> 방문 기록
            
            for (MyNode n : graph[c_v]) {
                int n_v = n.node; //인접 노드
                int value = n.value; //인접 노드로의 가중치
                if (distance[n_v] > distance[c_v] + value) { //최소 거리로 업데이트
                    distance[n_v] = distance[c_v] + value;
                    pq.offer(new MyNode(n_v, distance[n_v]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }

    }

    //
    private static class MyNode implements Comparable<MyNode> {
        private int node, value;

        public MyNode(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(MyNode o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
