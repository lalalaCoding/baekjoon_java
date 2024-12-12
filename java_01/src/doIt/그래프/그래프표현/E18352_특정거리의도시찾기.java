package doIt.그래프.그래프표현;

import java.io.*;
import java.util.*;

public class E18352_특정거리의도시찾기 {
    /*
     * 그래프 표현 : 인접 리스트
     * 탐색 방법 : 너비우선탐색 (도착 노드까지의 최단 경로를 보장하기 위함)
     * */
    public static ArrayList<Integer>[] graph; //인접 리스트 배열
    public static int[] visited; //방문 배열: 최단 경로의 길이 저장
    public static List<Integer> answer = new ArrayList<>(); //정답 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //M+1번 입력받아야하므로 입력횟수의 최대는 100만+1 회

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); //노드의 수: 도시의 수
        int M = Integer.parseInt(arr[1]); //엣지의 수: 도로의 수
        int K = Integer.parseInt(arr[2]); //최단 경로 값: 거리 정보
        int X = Integer.parseInt(arr[3]); //출발 노드: 출발 도시의 번호

        graph = new ArrayList[N + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            arr = br.readLine().split(" ");
            graph[Integer.parseInt(arr[0])].add(Integer.valueOf(arr[1]));
        }
        visited = new int[N + 1];
        for (int i = 1; i < visited.length; i++) {
            visited[i] = -1; // 시작 노드에서 i 노드까지의 길이를 기록하기 위함
        }

        BFS(X); //너비 우선 탐색 실행
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == K) answer.add(i);
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer); //정답 노드를 오름 차순 정렬
            for (Integer node : answer) {
                System.out.println(node);
            }
        }
    }
    
    /*
        너비 우선 탐색 : 방문 배열에 경로의 길이를 기록한다.
    * */
    private static void BFS(int x) {
        //큐에 탐색할 노드를 넣기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++; //탐색 노드까지의 경로에 대한 길이를 기록

        //큐에서 노드를 꺼내어, 꺼낸 노드의 인접 노드를 다시 큐에 삽입한다.
        //이를 큐가 비워질 때까지 반복한다.
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i : graph[now_node]) { //i: 현재 노드x의 인접 노드
                if (visited[i] == -1) {
                    queue.add(i);
                    visited[i] = visited[now_node] + 1; //i노드까지의 길이를 기록
                }
            }
        }
    }
}
