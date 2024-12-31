package doIt.그래프.벨만포드;

import java.io.*;
import java.util.*;

public class E11657_타임머신 {

    public static Edge[] edges;
    public static long[] distance; //최단 거리 배열: long !
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        int M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        //==벨만-포드 알고리즘==//
        boolean minus_cycle = false;
        for (int i = 1; i < N; i++) { //'전체 노드 - 1'만큼 반복
            for (int j = 0; j < M; j++) {
                Edge e = edges[j];
                
                //업데이트 조건: 출발노드가 방문한 적이 있어야함 & 최단 거리일 때
                if (distance[e.start] != Integer.MAX_VALUE && distance[e.end] > distance[e.start] + e.value) {
                    distance[e.end] = distance[e.start] + e.value;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            Edge e = edges[j];

            //음수 사이클 확인하기
            if (distance[e.start] != Integer.MAX_VALUE && distance[e.end] > distance[e.start] + e.value) {
                minus_cycle = true;
                break;
            }
        }

        //== 결과 출력  ==//
        if (!minus_cycle) { //음수 사이클 없음
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) { //최단 경로가 존재하지 않는 경우
                    System.out.println("-1");
                } else { //최단 경로가 존재하는 경우
                    System.out.println(distance[i]);
                }
            }
        } else { //음수 사이클 있음
            System.out.println("-1");
        }
        br.close();
    }

    //== 엣지 클래스 작성  ==//
    private static class Edge {
        int start, end, value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
