package doIt.정렬;

import java.util.Scanner;
import java.util.StringTokenizer;

public class E11399_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); //버퍼 공간에 남은 줄바꿈을 제거
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        //선택 정렬로 오름차순 구현
        for (int i = 1; i < N; i++) { //i = 데이터 값을 선택하기 위한 인덱스
            int temp = A[i]; //선택 데이터를 임시 저장
            int here = i; //삽입될 위치에 대한 인덱스
            for (int j = 0; j <= i; j++) { //j = 정렬된 데이터 범위
                if (A[j] > temp) {
                    here = j;
                    break;
                }
            }

            //시프트 연산
            for (int k = i; k > here; k--) {
                A[k] = A[k - 1];
            }
            //삽입할 위치에 선택했던 데이터를 삽입
            A[here] = temp;
        }
        
        //오름차순에 대한 합 배열 계산
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) S[i] = A[i];
            else S[i] = S[i - 1] + A[i];
        }

        //합 배열의 총합 계산
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }

        System.out.println(sum);
    }
}
