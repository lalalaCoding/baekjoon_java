package doIt.탐색;

import java.util.Scanner;

public class E2343_기타레슨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        int N = Integer.parseInt(arr[0]); //강의 수
        int[] A = new int[N]; //강의 길이 배열
        int M = Integer.parseInt(arr[1]); //블루레이 수

        arr = sc.nextLine().split(" ");
        int startIndex = 0; //데이터셋의 시작 인덱스
        int endIndex = 0; //데이터셋의 종료 인덱스
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(arr[i]); //강의 길이 배열 초기화
            if (startIndex < A[i]) {
                startIndex = A[i];
            }
            endIndex += A[i];
        }

        while (startIndex <= endIndex) {
            int medianIndex = (startIndex + endIndex) / 2; //최초 중앙값 계산
            int sum = 0; //부분 합 변수
            int count = 0; //필요한 블루레이 개수
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > medianIndex) { //부분 합이 중앙값을 초과한 경우
                    count++; //필요한 블루레이 개수를 1 증가
                    sum = A[i]; //부분합을 마지막에 합한 수부터 다시 계산
                } else {
                    sum += A[i];
                }
            }

            if (sum != 0) {
                count++; //잔여 강의를 저장할 블루레이 개수를 1개 추가함
            }

            if (count > M) { //필요한 블루레이 개수가 더 많은 경우 -> 중앙값 기준으로 오른쪽 데이터셋을 선택
                startIndex = medianIndex + 1;
            } else { //필요한 블루레이 개수가 더 작거나 같은 경우 -> 중앙값 기준으로 왼쪽 데이터셋을 선택
                endIndex = medianIndex - 1;
            }
        }

        System.out.println(startIndex);
    }
}
