package doIt.탐색;

import java.util.Scanner;

public class E2023_신기한소수찾기 {
    private static int N; //자리수 : 1이상 8이하

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] P = {2, 3, 5, 7}; //일의 자리인 소수 배열
        for (int p : P) {
            DFS(p, 1);
        }
    }

    public static void DFS(int p, int jarisu) {
        if (jarisu == N) { //N자리인 수가 완성되었는지 확인
            if (isPrime(p)) { //완성된 숫자p가 소수인지 확인 후 출력
                System.out.println(p);
            }
            return;
        } else { //
            if (isPrime(p)) { //p가 소수인 경우
                //자릿수를 늘려서 탐색을 요청
                int[] odd = {1, 3, 5, 7, 9};
                jarisu = jarisu + 1;
                for (int o : odd) {
                    DFS(p * 10 + o, jarisu); // p*10+0(왼쪽으로 부터 2자리 수)가 소수인지 탐색 요청
                }
            } else { //p가 소수가 아님 : 탐색 종료
                return;
            }
        }
    }

    //소수인지 확인해주는 메서드 작성
    public static boolean isPrime(int n) {
        int root = (int) Math.sqrt(n); //양의 제곱근

        for (int i = 2; i <= root; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
