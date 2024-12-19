package doIt.그래프.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E1717_집합의표현 {

    public static int[] parent; // 루트 노드 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]); //노드 갯수
        parent = new int[n + 1]; //인덱스=노드, 배열의 값=대표 노드가 될 수 있게하기 위해 n + 1크기로 선언
        for (int i = 1; i <= n; i++) {
            parent[i] = i; //루트 노드 초기화
        }
        int m = Integer.parseInt(arr[1]); //질의 횟수
        for (int i = 0; i < m; i++) {
            arr = br.readLine().split(" ");
            int type = Integer.parseInt(arr[0]); //질문 유형
            int a = Integer.parseInt(arr[1]);
            int b = Integer.parseInt(arr[2]);

            if (type == 0) { //유니온 연산
                union(a, b);
            } else if (type == 1) { //같은 집합인지 체크
                if (isSame(a, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static boolean isSame(int a, int b) {
        int a_root = find(a);
        int b_root = find(b);
        return a_root == b_root;
    }

    /* 유니온 연산 : 대표 노드끼리 연결 */
    public static void union(int a, int b) {
        int a_root = find(a); //a의 대표 노드 find
        int b_root = find(b); //b의 대표 노드 find
        if (a_root != b_root) {
            parent[b_root] = a_root; //b의 대표 노드 값을 a의 대표 노드 값으로 변경
        }
    }

    /* 파인드 연산 : 대표 노드를 반환하는 연산 */
    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return find(parent[a]);
        }
    }
}
