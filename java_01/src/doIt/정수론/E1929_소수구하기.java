package doIt.정수론;

import java.util.Scanner;

public class E1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] S = sc.nextLine().split(" ");
        int M = Integer.parseInt(S[0]);
        int N = Integer.parseInt(S[1]);
        
        //크기가 N + 1인 1차원 배열을 선언 후 초기화
        int[] A = new int[N + 1]; //인덱스와 값이 일치하게 하기 위해 크기를 N보다 1크게 선언
        for (int i = 2; i <= N; i++) { //1은 소수가 아니므로 무시
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] != 0) {
                //현재 선택된 수(i)의 배수를 모두 지운다.
                for (int j = i + i; j <= N; j = j + i) {
                    A[j] = 0;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if(A[i] != 0) System.out.println(A[i]);
        }
    }
}
