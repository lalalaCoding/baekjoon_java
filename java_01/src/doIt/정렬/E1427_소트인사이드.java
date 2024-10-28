package doIt.정렬;

import java.util.Scanner;

public class E1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] S = sc.nextLine().split(""); //입력받은 숫자(문자열)의 자릿수를 문자열 배열에 저장
        int[] A = new int[S.length];
        for (int i = 0; i < S.length; i++) {
            A[i] = Integer.parseInt(S[i]);
        }

        for (int i = 0; i < A.length - 1; i++) { //i == 정렬하기 위해 필요한 횟수
            for (int j = i; j < A.length; j++) { //j == 남은 정렬 부분의 시작 인덱스
                int max = 0; //남은 정렬 부분에서의 최대값을 저장할 변수
                int maxIndex = 0; //남은 정렬 부분에서 최대값에 대한 인덱스를 저장할 변수
                if(max < A[j]) {
                    max = A[j]; //남은 정렬 부분에서 최대값 계산
                    maxIndex = j;
                }
                if(A[i] < max) { //남은 정렬 부분에서 시작 값과 최대 값을 비교해 swap
                    int temp = A[i];
                    A[i] = max;
                    A[maxIndex] = temp;
                }
            }
        }
        //결과 출력
        for (int num : A) {
            System.out.print(num);
        }
    }
}
