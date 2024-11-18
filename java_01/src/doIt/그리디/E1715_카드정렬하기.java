package doIt.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class E1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //카드 묶음의 개수
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순으로 정렬된 우선순위 큐

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        } //헤드에 가장 작은 값이 위치한다.

        while (pq.size() > 1) {
            //우선순위 큐에서 가장 작은 두개의 값을 꺼낸다.
            int min1 = pq.poll();
            int min2 = pq.poll();
            //꺼낸 값의 합을 우선순위 큐에 삽입 : 현재 큐의 헤드와 삽입할 값을 비교하여 위치가 결정된다.
            pq.add(min1 + min2);
            answer += min1 + min2;
        }

        System.out.println(answer);
    }
}
