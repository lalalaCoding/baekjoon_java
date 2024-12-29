package doIt.그래프.다익스트라;

import java.io.*;
import java.util.*;

public class E1916_최소비용구하기 {
    
    public static ArrayList<MyNode>[] graph; //그래프: 인접 리스트
    public static boolean[] visited; //방문 배열
    public static int[] cost; //최소 비용 배열
    public static PriorityQueue<MyNode> pq = new PriorityQueue<>(); //최단 경로를 선택하기 위한 '우선순위 큐' 자료 구조
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //노드의 수
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        cost = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            cost[i] = Integer.MAX_VALUE;
//        }
        Arrays.fill(cost, Integer.MAX_VALUE); //**

        int M = Integer.parseInt(br.readLine()); //엣지의 수
        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new MyNode(b, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken()); //시작 노드
        cost[start] = 0;
        int end = Integer.parseInt(st.nextToken()); //종점 노드
        
        //다익스트라 구현
        pq.offer(new MyNode(start, 0)); //시작 노드 st 정보 삽입
        while (!pq.isEmpty()) {
            MyNode current = pq.poll();//기준 노드 정보를 꺼내면서 삭제하기
            int c_v = current.target; //기준 노드

            if (visited[c_v]) { //이미 방문
                continue;
            } else { //미방문
                visited[c_v] = true; //방문 기록
            }

            for (MyNode i : graph[c_v]) {
                int n_v = i.target; //인접 노드
                int value = i.value; //인접 노드로의 가중치 또는 가중치의 합계

                if (!visited[n_v] && cost[n_v] > cost[c_v] + value) { //최소 거리 업데이트
                    cost[n_v] = cost[c_v] + value;
                    pq.offer(new MyNode(n_v, cost[n_v]));
                }
            }

        }

        //결과 출력
        br.close();
        System.out.println(cost[end]);
    }
    
    //노드 클래스 작성
    public static class MyNode implements Comparable<MyNode> {
        
        private int target; //인접 노드
        private int value; //인접 노드로의 가중치 또는 가중치의 합계

        public MyNode(int target, int value) {
            this.target = target;
            this.value = value;
        }

        @Override
        public int compareTo(MyNode o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
