package doIt.정수론;

import java.util.Scanner;

public class E11689_오일러함수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long result = N; //N과 서로소인 자연수의 개수

        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) { //i가 N의 소인수인 경우 : 작은 수부터 탐색하므로 약수가 소수일 수 밖에 없음
                result -= result / i; //i의 배수 개수만큼 result에서 뺀다.

                // N을 i의 거듭제곱으로 나눈 값 : N(2^7 *11) -> N(11)
                while (N % i == 0) {
                    N /= i;
                }
            }
        }

        if (N > 1) { //현재 N이 원래 N의 마지막 소인수인 경우
            result -= result / N;
        }

        System.out.println(result);
    }
}
