package doIt.탐색;

import java.util.*;
import java.io.*;

public class E1260_DFS와BFS {
    private static ArrayList<Integer>[] graph; //인접 리스트 선언
    private static boolean[] visited; //방문 배열 선언

    public static void main(String[] args) throws Exception {
        //그래프 -> 인접 리스트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); //노드 수
        int M = Integer.parseInt(arr[1]); //엣지 수
        int start = Integer.parseInt(arr[2]); //시작 노드

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            arr = br.readLine().split(" ");
            int s = Integer.parseInt(arr[0]);
            int e = Integer.parseInt(arr[1]);
            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]); //노드 번호가 작은 것을 먼저 방문하기 위해 오름차순 정렬
        }

        //깊이 우선 탐색을 요청
        DFS(start);
        System.out.println();
        visited = new boolean[N + 1]; //방문 배열을 다시 초기화
        BFS(start);

        br.close();
    }

    public static void DFS(int node) { //깊이 우선 탐색
        if (visited[node]) { //이미 방문한 노드에 대한 탐색 요청 -> 리턴시킴
            return;
        }
        System.out.print(node + " ");
        visited[node] = true; //방문 배열에 기록
        for (int i : graph[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) { //너비 우선 탐색
        //큐 자료구조에 시작점 더하기
        Queue<Integer> queue = new LinkedList<>();
        if (!visited[node]) {
            visited[node] = true; //방문을 기록
            queue.add(node);
            System.out.print(node + " ");
        }

        //큐에서 노드를 꺼낸 후, 꺼낸 노드의 인접 노드를 다시 큐에 삽입하기
        while (!queue.isEmpty()) { //큐가 비워질 때 까지 반복 : 인접 노드를 삽입하고 꺼낸다.
            for (int i : graph[queue.poll()]) {
                if (!visited[i]) { //인접노드가 방문했던적이 없음
                    visited[i] = true; //방문을 기록
                    queue.add(i); //인접노드를 큐에 삽입
                    System.out.print(i + " ");
                }
            }
        }
    }
}
