package doIt.정수론;

import java.util.Scanner;

public class E1016_제곱아닌수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] S = sc.nextLine().split(" ");
        long min = Long.parseLong(S[0]); //1이상 10^12이하 이므로 long 타입으로 선언
        long max = Long.parseLong(S[1]);
        
        //제곱수의 배수만 true로 마킹
        boolean[] check = new boolean[(int) (max - min + 1)];
        int result = 0;

        for (long i = 2; i * i <= max; i++) { //최소 제곱수인 2의 제곱부터 시작
            long pow = i * i; //현재 제곱수

            long start = min / pow; //제곱수에 곱할 숫자
            if(min % pow != 0) { //최소값이 현재 제곱수의 배수가 아닌 경우
                start++; //제곱수에 곱할 숫자를 1 증가시켜야지, 최소값 이상의 숫자를 의미하게 된다.
            }

            for (long j = start; pow * j <= max; j++) {
                check[(int) ((pow * j) - min)] = true;
            }
        }

        for (boolean b : check) {
            if (!b) result++;
        }
        System.out.println(result);
    }
}
