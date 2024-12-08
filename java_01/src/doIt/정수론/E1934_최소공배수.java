package doIt.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1934_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수

        StringTokenizer st = null;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //A가 B보다 작거나 같도록 정렬
            if (A > B) {
                int tmp = A;
                A = B;
                B = tmp;
            }

            //A와 B의 최소 공배수 계산 : A * B / gcd(A,B)
            int multiple = A * B;
            //최대 공약수 구하기
            while (true) {
                int R = B % A; //R은 반드시 A보다 작은 수
                if (R == 0) {
                    System.out.println(multiple/A);
                    break;
                } else {
                    B = A;
                    A = R;
                }
            }
        }
    }
}
