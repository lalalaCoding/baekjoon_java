package doIt.탐색;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E1920_수찾기 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); //데이터셋을 오름차순으로 정렬시키기 (이진탐색하기 위한 셋팅)
        
        int M = Integer.parseInt(br.readLine());
        int[] T = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        //이진 탐색 수행
        for (int i = 0; i < M; i++) {
            int target = T[i]; //타겟 숫자
            boolean find = false; //일치 여부 플래그
            int start = 0; //탐색 데이터셋의 시작 인덱스
            int end = N - 1; //탐색 데이터셋의 종료 인덱스
            while (start <= end) {
                int medianIndex = (end + start)/2; // start와 end의 합을 2로 나눈 몫
                int medianValue = A[medianIndex];
                if (medianValue == target) {
                    find = true;
                    break;
                } else if (medianValue < target) {
                    //중앙값 기준으로 오른쪽 데이터셋을 선택
                    start = medianIndex + 1;
                } else {
                    //중앙값 기준으로 왼쪽 데이터셋을 선택
                    end = medianIndex - 1;
                }
            }

            if (find) System.out.println(1);
            else System.out.println(0);
        }

        br.close();
    }
}
