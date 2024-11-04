package doIt.정렬;

import java.io.*;

public class E10989_수정렬하기3 {
    private static final int maxSize = 5; //입력될 숫자에 대한 최대 자릿수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //수열의 길이, 1 이상 1천만 이하
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine()); //배열 초기화
        }

        radixSort(A, maxSize);//기수 정렬 요청

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void radixSort(int[] A, int maxSize) {
        int[] sortArr = new int[A.length]; //특정 자리수 기준으로 정렬한 수열을 저장할 배열 선언
        int jarisu = 1;

        for (int i = 0; i < maxSize; i++) { //최대 자리수만큼 정렬을 반복함
            int[] bucket = new int[10]; //인덱스가 0부터 9까지의 자릿수를 의미하는 배열

            //bucket에 각 자리수를 가르키는 숫자의 갯수를 저장
            for (int k : A) {
                int x = k / jarisu % 10; //자리수 구하기
                bucket[x]++;
            }

            //bucket에 각 자리수 이하의 숫자의 갯수를 저장
            //특정 자리수를 갖는 숫자가 A에서 몇번째 인덱스에 있는지 계산하기 위함
            //bucket에 대한 부분 합을 저장한다.
            for (int j = 1; j < bucket.length; j++) {
                bucket[j] += bucket[j - 1];
            }

            //현재 자리수를 기준으로 정렬하기
            for (int j = A.length - 1; j >= 0; j--) {
                int x = A[j] / jarisu % 10; //A[j]의 자리수
                sortArr[bucket[x] - 1] = A[j]; //A[j]보다 자리수가 작거나 같은 숫자의 갯수에서 1을 뺀 인덱스에 A[j]를 저장
                bucket[x]--; //A[j]의 자리수보다 작거나 같은 숫자의 갯수를 1개 감소시킨다.
            }
            
            //현재 자리수를 기준으로 정렬한 결과를 원본 배열에 옮겨담기
            System.arraycopy(sortArr, 0, A, 0, A.length);
            //다음 자리수를 계산하여 저장
            jarisu *= 10;
        }
    }
}
