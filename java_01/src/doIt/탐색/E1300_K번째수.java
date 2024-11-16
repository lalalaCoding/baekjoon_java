package doIt.탐색;

import java.util.Scanner;

public class E1300_K번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long answer = 0; // 정답을 저장할 변수

        //2차원 배열에서 K번째 수가 K보다 크다고 가정
        //1부터 k까지의 모든 수가 K번째 수보다 작다
        //K번째 수 이전에 최소 K개의 수가 존재
        //K번째수는 K번째 수가 아니다 (모순)
        int start = 1;
        int end = K;

        while (start <= end) {
            int mid = (start + end) / 2; //중앙값 계산
            long cnt = 0; //중앙값 보다 작거나 같은 수의 개수를 셈하는 변수

            for (int r = 1; r <= N; r++) {
                cnt += Math.min(mid / r, N); //각 행에서 mid보다 작거나 같은 수는 (중앙값 / 행의수)와 열의 수 중 최소값이다.
            }

            if (cnt < K) {
                start = mid + 1;
            } else {
                //K번째 수 : 본인 이하인 수의 개수가 K개를 넘을 수 있음 (K번째 수와 같은 수가 여러개일 수 있기 때문)
                answer = mid; //현재 중앙값을 정답에 기록하기
                end = mid - 1;
            }
        }

        System.out.println(answer); // 정답 출력
    }
}
