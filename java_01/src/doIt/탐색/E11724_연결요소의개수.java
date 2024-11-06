package doIt.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class E11724_연결요소의개수 {

    private static ArrayList<Integer>[] list; //인접 리스트 선언
    private static boolean[] visited; //방문 배열 선언
    private static long cc = 0; //연결 요소의 개수

    public static void main(String[] args) throws IOException {
        //인접 리스트와 방문 배열 : 선언과 초기화를 해보자!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //정점(노드, 꼭짓점)의 개수
        int M = Integer.parseInt(st.nextToken()); //간선(엣지, 변)의 개수

        list = new ArrayList[N + 1]; // list[0]는 사용하지 않을 계획
        visited = new boolean[N + 1]; // visited[0]는 사용하지 않을 계획, [F, F, ..., F]

        for (int i = 0; i < N + 1; i++) { //인접 리스트 초기화
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) { //인접 리스트 저장
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            //무향 그래프 : 시작 노드와 도착 노드 양쪽에 모두 인접 노드를 기록해준다.
            list[start].add(end);
            list[end].add(start);
        }

        //1번 노드부터 시작하는 DFS 요청하기
        for (int v = 1; v < N + 1; v++) {
            if (!visited[v]) {
                cc++; //DFS 요청 횟수 저장하기
                DFS(v);
            }
        }

        System.out.println(cc);
    }

    public static void DFS(int v) { //v부터 DFS 탐색을 수행하는 메서드
        //이미 방문한 노드라면 탐색을 종료(재귀 함수 호출을 종료)
        if (visited[v]) {
            return;
        }
        visited[v] = true; //탐색하려는 노드를 방문 배열에 기록
        for (int i : list[v]) {
            if (!visited[i]) { //v에서 연결된 노드가 방문x인 노드일 때 다음 탐색을 요청
                DFS(i);
            }
        }
    }
}
