package doIt.그래프.위상정렬;

import java.util.*;

public class E1948_임계경로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //도시(노드)의 수
        ArrayList<MyNode>[] graph = new ArrayList[n + 1];
        int[] inDegree = new int[n + 1];
        ArrayList<MyNode>[] reverse_graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverse_graph[i] = new ArrayList<>();
        }

        int m = sc.nextInt(); //도로(엣지)의 수
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int time = sc.nextInt();
            graph[start].add(new MyNode(end, time));
            inDegree[end]++;
            reverse_graph[end].add(new MyNode(start, time));
        }

        int start_dosi = sc.nextInt();
        int end_dosi = sc.nextInt();

        //위상 정렬
        int[] result = new int[n + 1]; //각 도시까지 걸리는 시간의 합계 계산
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_dosi); //시작 노드는 '고정 값'
        while (!queue.isEmpty()) {
            int now_dosi = queue.poll();
            for (MyNode nextNode : graph[now_dosi]) {
                inDegree[nextNode.getEndNode()]--; //인접 노드의 진입 차수 감소

                result[nextNode.getEndNode()] = Math.max(result[nextNode.getEndNode()], result[now_dosi] + nextNode.getTime());

                if (inDegree[nextNode.getEndNode()] == 0) {
                    queue.offer(nextNode.getEndNode());
                }
            }
        }

        //위상 정렬 역방향: 1분도 쉬지 않고 달린 경로에서 엣지의 개수를 구함
        int resultCount = 0; //1분도 쉬지 않고 달린 경로에서 도로(엣지)의 개수 저장
        boolean[] visited = new boolean[n + 1]; //같은 도로를 반복하지 않기 위한 노드 방문 배열
        queue = new LinkedList<>();
        queue.offer(end_dosi); //거슬러 올라가므로 시작 노드가 도착지 노드이다
        visited[end_dosi] = true;

        while (!queue.isEmpty()) {
            int now_dosi = queue.poll();
            for (MyNode nextNode : reverse_graph[now_dosi]) {
                //1분도 쉬지 않는 도로 체크하기
                if (result[nextNode.getEndNode()] + nextNode.getTime() == result[now_dosi]) {
                    resultCount++;
                    if (!visited[nextNode.getEndNode()]) {
                        visited[nextNode.getEndNode()] = true;
                        queue.offer(nextNode.getEndNode());
                    }
                }
            }
        }
        
        //결과 출력
        System.out.println(result[end_dosi]);
        System.out.println(resultCount);
    }

    //== 노드 클래스 작성 ==//
    static class MyNode {
        private int endNode;
        private int time;

        public MyNode(int endNode, int time) {
            this.endNode = endNode;
            this.time = time;
        }

        public int getEndNode() {
            return endNode;
        }

        public int getTime() {
            return time;
        }
    }
}
