package doIt.그래프.위상정렬;

import java.util.*;

public class E1516_게임개발 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //건물(노드)의 수

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N + 1]; //진입 차수 배열
        int[] time = new int[N + 1]; //각 건물 건설 시간
        int[] result = new int[N + 1]; //각 건물 완성까지 시간

        for (int i = 1; i <= N; i++) {
            int temp = sc.nextInt();
            time[i] = temp; //각 건물 건설 시간 초기화

            while (true) {
                temp = sc.nextInt();
                if (temp == -1) {
                    break;
                } else {
                    graph[temp].add(i); //그래프 초기화
                    inDegree[i]++; //진입 차수 배열 초기화
                }
            }
        }

        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) { //진입 차수가 0인 경우
                queue.offer(i); //노드를 삽입
            }
        }

        while (!queue.isEmpty()) {
            int now_node = queue.poll(); //큐의 head에 있는 노드 꺼내기
            for (int next_node : graph[now_node]) {
                inDegree[next_node]--; //진입 차수 1 감소

                result[next_node] = Math.max(result[next_node], result[now_node] + time[now_node]); //현재 건물까지의 건설 시간 총합을 저장

                if (inDegree[next_node] == 0) { //인접 노드의 진입 차수가 0인 경우
                    queue.offer(next_node); //인접 노드를 큐에 삽입
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + time[i]);
        }

    }
}
