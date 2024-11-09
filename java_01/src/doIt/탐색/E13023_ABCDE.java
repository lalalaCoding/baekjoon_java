package doIt.탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class E13023_ABCDE {
    private static ArrayList<Integer>[] A; //인접 리스트 : ArrayList 배열
    private static boolean[] visited; //방문 노드 기록용 배열
    private static boolean flag = false;

    public static void main(String[] args) throws Exception {
        //무향 그래프 -> 인접 리스트로 표현해보기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); // 노드 수, 5 이상 2000이하
        int M = Integer.parseInt(arr[1]); // 엣지 수, 1 이상 2000이하

        A = new ArrayList[N];
        for (int i = 0; i < N; i++) { //인접 리스트 초기화
            A[i] = new ArrayList<>();
        }
        visited = new boolean[N]; //방문 배열 초기화

        for (int i = 0; i < M; i++) {
            arr = br.readLine().split(" ");
            int start = Integer.parseInt(arr[0]);
            int end = Integer.parseInt(arr[1]);
            A[start].add(end);
            A[end].add(start);
        }

        //각 노드를 시작점으로 하는 DFS 요청
        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if (flag) { //깊이5인 탐색이 등장
                break;
            }
        }

        //결과 출력
        br.close();
        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    private static void DFS(int i, int depth) {
        if (depth == 5 || flag) {//깊이가 5인 탐색이 등장 -> 더 이상 탐색할 필요가 없음.
            flag = true;
            return;
        }

        //깊이가 5미만 상태
        visited[i] = true; //방문 체크
        for (int node : A[i]) {
            if (!visited[node]) {
                DFS(node, depth + 1); //깊이를 1증가시켜 탐색을 다시 요청한다.
            }
        }
        visited[i] = false; //무향 그래프 -> 방문 체크를 해제
    }
}
