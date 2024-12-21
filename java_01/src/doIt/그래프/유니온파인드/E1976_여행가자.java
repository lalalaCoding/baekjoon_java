package doIt.그래프.유니온파인드;

import java.io.*;
import java.util.StringTokenizer;

public class E1976_여행가자 {

    public static int[] parent; //루트 노드 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //노드의 개수
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i; //대표 노드 초기화
        }

        int M = Integer.parseInt(br.readLine()); //여행 계획에 속한 노드의 수
        int[] plan = new int[M + 1]; //여행 계획 노드를 저장하는 배열

        int[][] dosi = new int[N + 1][N + 1]; //인접 행렬: 연결된 도시 정보
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " "); //토큰 개수는 N개
            for (int j = 1; j <= N; j++) {
                dosi[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dosi[i][j] != 0) union(i, j);
            }
        }

        String[] arr = br.readLine().split(" "); //길이는 M
        for (int i = 1; i <= M; i++) {
            plan[i] = Integer.parseInt(arr[i - 1]);
        }

        //계획된 도시(노드)들의 대표(루트) 노드가 같은지 확인한 결과 출력
        int start_root = find(plan[1]);
        for (int i = 2; i < plan.length; i++) {
            if (start_root != find(plan[i])) {
                System.out.println("NO");
                return; // main() 종료
            }
        }
        System.out.println("YES"); // main() 실행 중일 때만 여기에 도달 가능
    }

    //UNION 연산
    public static void union(int a, int b) {
        int a_root = find(a);
        int b_root = find(b);
        if (a_root != b_root) parent[b_root] = a_root;
    }

    //FIND 연산
    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
