package doIt.정수론;

import java.util.Scanner;

public class E1747_소수와팰린드롬 {
    public static void main(String[] args) {
        //2 이상 1000만 이하의 소수를 구한다.
        //100만 이상의 팰린드롬 수 중 최소값(1,003,001)이 후보 소수군에 포함되도록 1000만 이하의 소수를 구했음.
        //소수 중에서 팰린드롬 수를 구한다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[10000000 + 1];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
        
        //에라토스테네스의 체 : 소수 구하기
        for (int i = 2; i <= Math.sqrt((double)A.length); i++) {
            if (A[i] != 0) {
                for (int j = i + i; j < A.length; j += i) {
                    A[j] = 0;
                }
            }
        }
        
        //팰린드롬 수 체크하기
        for (int i = N; i < A.length; i++) {
            if(A[i] != 0) {
                if (isPalindrome(A[i])) {
                    System.out.println(A[i]);
                    break;
                }
            }
        }
    }
    
    //매개변수가 팰린드롬 수인지 판별하는 함수 : 투 포인터를 이용한다.
    private static boolean isPalindrome(int x) {
        char[] temp = String.valueOf(x).toCharArray(); //타겟 숫자를 문자 배열로 변환하기
        int start = 0;
        int end = temp.length - 1;
        while (start < end) { //두개의 비교 포인터 값이 일치하는지 확인
            if (temp[start] != temp[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
