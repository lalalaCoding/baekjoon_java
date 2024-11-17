package doIt.그리디;

import java.util.Scanner;

public class E11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0; //필요한 동전의 최소 개수

        String[] arr = sc.nextLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int[] A = new int[N];
        int K = Integer.parseInt(arr[1]); //만들어야할 금액

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            if (K >= A[i]) { //K보다 작거나 같은 동전의 최대 금액
                count += (K / A[i]); //필요 동전 개수 갱신
                K %= A[i]; //만들어야 할 금액을 갱신
                if (K == 0) break; //만들어야 할 금액이 0원이라면 반복을 종료
            }
        }

        System.out.println(count);
    }
}
