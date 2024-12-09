package doIt.정수론;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class E1850_최대공약수 {
    public static void main(String[] args) throws Exception{
        //A와 B의 최대 공약수만큼 1을 한줄로 출력한다.
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = sc.nextLine().split(" ");
        long A = Long.parseLong(arr[0]);
        long B = Long.parseLong(arr[1]);
    
        //A가 B 이하가 되도록 정렬
        if (A > B) {
            long temp = A;
            A = B;
            B = temp;
        }

        long result = gcd(A, B); //A와 B의 최대 공약수 계산

        while (result > 0) {
            bw.write("1");
            result--;
        }

        bw.flush(); //버퍼 공간 방류
        bw.close(); //스트림 리소스 반납
    }

    private static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }
}
