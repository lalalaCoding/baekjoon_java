package doIt.탐색;

import java.io.*;
import java.util.*;

public class E2178_미로탐색 {

    private static int[][] A; //미로
    private static int N; //미로 -> 행의 수
    private static int M; //미로 -> 열의 수
    private static final int[] dx = {0, 0, -1, 1}; //스태틱 변수는 일반적으로 final로 선언한다.
    private static final int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited; //방문배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]); //행의 수
        M = Integer.parseInt(arr[1]); //열의 수

        A = new int[N][M]; //미로 -> 2차원 배열 선언
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(""); //한 글자씩 문자열로 자른다.
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(row[j]);
            }
        }
        visited = new boolean[N][M]; //방문배열 초기화

        BFS(0, 0); //너비 우선 탐색을 요청, 시작 노드는 (0, 0)
        System.out.println(A[N-1][M-1]);
        br.close();
    }

    public static void BFS(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c}); //큐에 int 배열 [r, c]를 삽입한다.
        visited[r][c] = true; //방문을 기록한다.

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); //탐색 기준 노드를 큐에서 꺼낸다.
            int row = cur[0];
            int col = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < M) { //탐색하려는 좌표가 유효한지 검사
                    if (!visited[nextRow][nextCol] && A[nextRow][nextCol] != 0) {
                        visited[nextRow][nextCol] = true; //방문을 기록
                        queue.add(new int[]{nextRow, nextCol}); //0이 아닌 값을 가지고 있을 때 다음 탐색 기준 노드가 된다.
                        A[nextRow][nextCol] = A[row][col] + 1; //깊이를 증가시킨다.
                    }
                }
            }
        }
    }
}
