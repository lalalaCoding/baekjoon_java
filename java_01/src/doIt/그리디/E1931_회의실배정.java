package doIt.그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class E1931_회의실배정 {
    //각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2]; //N행 2열의 2차원 배열 : 시작 시간(1열), 종료 시간(2열)
        StringTokenizer st;
        sc.nextLine(); //버퍼 공간 제거
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(sc.nextLine(), " ");
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        
        //각 회의가 일찍 끝나야 1개의 룸에서 진행가능한 회수 개수가 많아짐
        //따라서 종료 시각 기준 오름차순 정렬한다.
        
        //람다식 사용
        Arrays.sort(A, (o1, o2) -> { //회의 시간에 대한 int 배열 : o1, o2
            if (o1[1] == o2[1]) { //종료 시각이 같음
                return o1[0] - o2[0]; //시작 시각을 오름차순
            } else {
                return o1[1] - o2[1]; //종료 시각을 오름차순
            }
        });

        //익명 내부 클래스 사용
//        Arrays.sort(A, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) { //회의 시간에 대한 int 배열 : o1, o2
//                if (o1[1] == o2[1]) { //종료 시각이 같음
//                    return o1[0] - o2[0]; //시작 시각을 오름차순
//                } else {
//                    return o1[1] - o2[1]; //종료 시각을 오름차순
//                }
//            }
//        });





        int count = 0; //진행 가능한 회의 개수
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (A[i][0] >= end) { //다음 회의의 시작 시간 >= 이전 회의의 종료 시간
                count++;
                end = A[i][1];
            }
        }

        System.out.println(count);
    }
}
