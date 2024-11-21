package doIt.그리디;

import java.util.Scanner;

public class E1541_잃어버린괄호 {
    //빼기(-)를 기준으로 자른다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] A = sc.nextLine().split("-");
        int answer = 0; //가장 앞의 수로 초기화

        answer += mySum(A[0]);
        for (int i = 1; i < A.length; i++) {
            answer -= mySum(A[i]);
        }

        System.out.println(answer);
    }
    
    //문자열을 '더하기'를 기준으로 잘라서 합계를 계산해주는 메서드
    public static int mySum(String s) {
        int sum = 0;
        // +는 정규표현식에서 '1개 이상'의 의미를 갖으므로 일반 문자로 취급하기 위해 이스케이프 처리가 필요함
        // 자바에서 \도 이스케이프 처리가 필요함
        // +를 기준으로 자르기 위해서는 \\을 붙여야 함
        //String[] arr = s.split("\\+");
        String[] arr = s.split("[+]");
        for (String a : arr) {
            sum += Integer.parseInt(a); // "0009"는 9로 파싱됨
        }
        
        return sum;
    }
}
