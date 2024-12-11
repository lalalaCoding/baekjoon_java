package doIt.정수론;

import java.util.Scanner;
import java.util.Stack;

public class E21568_AxByC {
    public static int x; // Ax + By = gcd(A, B)의 특수해
    public static int y; // Ax + By = gcd(A, B)의 특수해
    public static Stack<Integer> quota = new Stack<>(); //유클리드 호제법 수행 중 몫을 저장할 스택(후입선출)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);

        int gcd = gcd(a, b);
        if (c % gcd == 0) { //해가 존재
            disphantus(); // Ax + By = gcd(A, B)의 특수해 구하기
            System.out.println(x*(c/gcd) + " " + y*(c/gcd));
        } else { //해가 존재하지 않음
            System.out.println(-1);
        }
    }
    
    //Ax + By = gcd(A,B)의 특수해 구하기
    private static void disphantus() {
        int specificX = 0;
        int specificY = 1 - 0 * quota.pop();

        while (!quota.isEmpty()) {
            x = specificY;
            y = specificX - specificY * quota.pop();
            specificX = x;
            specificY = y;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            quota.push(a / b);
            return gcd(b, a % b);
        }
    }
}
