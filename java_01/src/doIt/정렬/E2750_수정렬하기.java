package doIt.정렬;

import java.io.*;

public class E2750_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N]; //수열 선언
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine()); //수열 초기화
        }
        
        for (int i = 0; i < N - 1; i++) { //루프의 종료 범위 지정하기 위한 i
            for (int j = 0; j < N - 1 - i; j++) { //루프의 시작 범위를 지정하기 위한 j
                if (A[j] > A[j + 1]) { //다음 항이 더 큰 경우
                    //swap 연산을 수행
                    int temp = A[j]; //임시 저장
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }
}
