package doIt.그래프.그래프표현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E2251_물통 {
    //6가지 이동(엣지) 케이스를 표현하기 위한 배열
    //sender[0]과 receiver[0]: 0번 노드 -> 1번 노드: 물통A에서 물통B로 물읏 붓는 행위
    public static int[] sender = {0, 0, 1, 1, 2, 2};
    public static int[] receiver = {1, 2, 0, 2, 0, 1};
    public static boolean[][] visited; // visited[2][5]: A물통의 물의 양이 2, B물통의 물의 양이 5라는 의미
    public static boolean[] answer; //answer[10] = true: C물통의 물의 양이 10이라는 의미
    public static int[] now = new int[3]; //물통의 최대부피를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] arr = sc.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            now[i] = Integer.parseInt(arr[i]); //각 물통의 부피 초기화
        }
        
        visited = new boolean[201][201];
        answer = new boolean[201];
        BFS(); //깊이 우선 탐색
        
        //정답 출력
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) System.out.print(i + " ");
        }
        
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0)); //각 물통의 시작 상태를 저장
        visited[0][0] = true; //A(0), B(0)인 경우를 방문에 기록
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB present = queue.poll();
            int A = present.A;
            int B = present.B;
            int C = now[2] - A - B;

            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;

                if (next[receiver[k]] > now[receiver[k]]) { //'도착 물통'에 담긴 물의 양이 물통의 부피보다 큰 경우
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]]; //초과된 물을 다시 '시작 물통'에 옮겨 담음
                    next[receiver[k]] = now[receiver[k]]; //'도착 물통'은 최대 용량 만큼 채워준다.
                }

                if (!visited[next[0]][next[1]]) { //visited[2][5] = false : A물통(2), B물통(5)인 경우가 처음인 경우
                    visited[next[0]][next[1]] = true; //A,B 물통의 상태를 방문 기록
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) { //물통A의 물의 양이 0인 경우
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    // 물통 A와 B의 상태를 저장할 수 있는 클래스 작성 -> C는 A와 B로 계산 가능
    private static class AB {
        int A;
        int B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
