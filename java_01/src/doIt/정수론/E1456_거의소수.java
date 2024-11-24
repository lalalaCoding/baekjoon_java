package doIt.정수론;

import java.util.Scanner;

public class E1456_거의소수 { //거의 소수 : 소수의 N제곱 (N>1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        long A = Long.parseLong(arr[0]);
        long B = Long.parseLong(arr[1]);
        /*
            B의 최대값인 10^14의 제곱근까지의 소수만 고려하면 된다.
                이유1 : 10^7 이상의 소수에 대한 제곱은 B를 초과하기 때문에 '거의 소수'가 존재하지 않기 때문이다.
                이유2 : 10^14 > 21억(int 최대값) 이므로 배열의 크기(int만 가능)를 B의 최대값으로 지정할 수 없기 때문이다.
        */
        int[] N = new int[10000000 + 1];

        //1차원 배열 초기화
        for (int i = 2; i < N.length; i++) {
            N[i] = i;
        }

        //에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(N.length); i++) {
            if (N[i] != 0) { //값이 지워지지 않았다면
                for (int j = i + i; j < N.length; j = j + i) { //i의 배수를 모두 지운다.
                    N[j] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < N.length; i++) {
            if (N[i] != 0) {
                long tmp = N[i];

                //‘현재 소수의 다음 거듭제곱 수’가 ‘long형 최대 값’을 초과할 경우 발생하는 에러를 막기 위하여 다음 거듭제곱 수를 직접 계산하지 않도록 하였다.
                while ((double)N[i] <= (double)B/tmp) { // 최대값을 현재값으로 나눈 몫이 기준 소수보다 크거나 같음 -> 현재 값의 다음 제곱이 최대값보다 작음
                    if ((double)N[i] >= (double)A/tmp) { // 현재값의 다음 제곱이 최소값보다 큼
                        count++;
                    }
                    tmp *= N[i];
                }
            }
        }
        System.out.println(count);
    }
}
