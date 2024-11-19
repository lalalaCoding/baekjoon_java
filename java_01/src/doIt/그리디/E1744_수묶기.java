package doIt.그리디;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxSum = 0;
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); //우선순위 큐(내림차순)
        PriorityQueue<Integer> minusPq = new PriorityQueue<>(); //우선순위 큐(오름차순)
        int zeroCount = 0; //0의 개수를 저장하는 변수 : 음수값을 줄일 때 사용할 것임
        int oneCount = 0; //1의 개수를 저장하는 변수 : 1이 여러개일 때 합을 계산할 때 사용할 것임
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num < 0) minusPq.add(num);
            else if (num == 0) zeroCount++;
            else if (num == 1) oneCount++;
            else plusPq.add(num);
        }

        //양수 묶음 처리
        while (plusPq.size() > 1) { //우선순위 큐에 2개 이상의 데이터가 있을 때
            int first = plusPq.poll();
            int second = plusPq.poll();
            maxSum += first * second;
        }
        if (plusPq.size() == 1) { //1개의 양수가 남아있을 때
            maxSum += plusPq.poll();
        }

        //1 처리
        maxSum += oneCount;

        //음수와 0처리
        while (minusPq.size() > 1) {
            int first = minusPq.poll();
            int second = minusPq.poll();
            maxSum += first * second;
        }

        if (minusPq.size() == 1) {
            if (zeroCount < 1) { //0이 존재하지 않음
                maxSum += minusPq.poll();
            } 
            //0이 존재하는 경우 : 1개의 남은 음수를 무시할 수 있음
        }

        System.out.println(maxSum);
    }
}
