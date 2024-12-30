package doIt.그래프.다익스트라;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    최단 거리의 값을 를 배열에 오름차순으로 저장하되, K번째를 가장 앞에 위치시키는 접근 방법 
*/

public class E1854_K번째최단경로찾기 {
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st= new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //노드의 수
        int M = Integer.parseInt(st.nextToken()); //엣지의 수
        int K = Integer.parseInt(st.nextToken()); //구하려는 최단 경로의 번째 수

        int[][] W = new int[1001][1001]; //그래프: 인접 행렬
        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b] = c;
        }

        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1]; //최단 거리를 저장할 우선순위 큐 배열
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //내림차순 정렬 기준
                return o1 < o2 ? 1 : -1;
            }
        };
        for (int i = 0; i <= N; i++) {
            distQueue[i] = new PriorityQueue<>(cp); //내림차순으로 정렬하는 우선순위 큐
        }

        PriorityQueue<MyNode> pq = new PriorityQueue<>(); //오름차순으로 정렬하는 우선순위 큐
        pq.offer(new MyNode(1, 0)); //시작 노드는 1로 고정임
        distQueue[1].add(0);
        while (!pq.isEmpty()) {
            MyNode u = pq.poll();
            for (int adjNode = 1; adjNode <= N; adjNode++) {
                //연결된 모든 인접 노드 탐색하기
                if (W[u.node][adjNode] != 0) { // u.node와 adjNode가 인접한 경우
                    //adjNode 까지의 최단 경로 갯수가 K개 미만인 경우: 그냥 저장
                    if (distQueue[adjNode].size() < K) {
                        distQueue[adjNode].add(u.cost + W[u.node][adjNode]);
                        pq.offer(new MyNode(adjNode, u.cost + W[u.node][adjNode]));
                    }
                    //ajdNode 까지의 최단 경로 갯수가 K개 이고, 현재 가장 큰 최단 경로 값보다 작은 값일 때만 추가해야 함
                    else if (distQueue[adjNode].peek() > u.cost + W[u.node][adjNode]) {
                        distQueue[adjNode].poll(); //기존의 가장 큰 최단 경로 값을 제거
                        distQueue[adjNode].add(u.cost + W[u.node][adjNode]);
                        pq.add(new MyNode(adjNode, u.cost + W[u.node][adjNode]));
                    }
                }
            }
        }

        //K번째 경로 출력
        for (int i = 1; i <= N; i++) {
            if (distQueue[i].size() == K) {
                bw.write(distQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    //== 노드 클래스==//
    public static class MyNode implements Comparable<MyNode> {
        private int node, cost;

        public MyNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(MyNode o) {
            return Integer.compare(cost, o.cost);
        }
    }
}
