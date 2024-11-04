package doIt.정렬;

import java.io.*;
import java.util.StringTokenizer;

public class E1517_버블소트 {
    //서로 다른 메서드에서 사용해야 하는 변수는 스태틱으로 지정
    private static long swapCount; //수열의 길이가 10억이므로 스왑횟수가 21억을 충분히 넘을 수 있음
    private static int[] A;
    private static int[] tmp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //수열의 길이
        A = new int[N + 1]; //원본 수열을 저장할 배열 선언
        tmp = new int[N + 1]; //병합 과정에서 비교군으로 사용할 배열 선언
        StringTokenizer sb = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(sb.nextToken());
        }

        mergeSort(1, N); // A배열의 1번째 부터 N번까지의 데이터에 대한 병렬 정렬을 요청


        System.out.println(swapCount);
        br.close();
    }

    public static void mergeSort(int start, int end) {
        if (start == end) {
            return; //병합할 시작 위치와 끝 위치가 같으면 메소드에 대한 재귀 호출을 종료
        }

        int mid = start + (end - start) / 2; //병합 집합을 반반으로 나눌 중간점 계산
        mergeSort(start, mid); //왼쪽 집합에 대한 재귀
        mergeSort(mid + 1, end); //오른쪽 집합에 대한 재귀

        //병합 정렬 수행
        System.arraycopy(A, start, tmp, start, end - start + 1); //병합 대상이 되는 데이터를 임시 배열에 옮겨 담기 -> 값을 비교해서 원본 배열에 순차적으로 저장할 것임

        int position = start; //원본 배열에서 저장할 위치를 가르키는 변수
        int index1 = start; //병합 대상 중 왼쪽 집합에서 시작 인덱스 -> 최대값은 mid
        int index2 = mid + 1; //병합 대상 중 오른쪽 집합에서 시작 인덱스 -> 최대값은 end

        while (index1 <= mid && index2 <= end) {
            if(tmp[index1] > tmp[index2]) {
                A[position] = tmp[index2];
                index2++;
                position++;
                swapCount += index2 - position; //오른쪽 집합의 데이터가 몇칸 앞으로 이동했는가 = swap이 몇번 일어났는가
            } else {
                A[position] = tmp[index1];
                index1++;
                position++;
            }
        } //종료 = 왼쪽 집합 또는 오른쪽 집합에서 꺼낼 데이터가 없는 경우

        while (index1 <= mid) { //왼쪽 집합에서 꺼낼 데이터가 남은 경우
            A[position] = tmp[index1];
            index1++;
            position++;
        }
        while (index2 <= end) { //오른쪽 집합에서 꺼낼 데이터가 남은 경우
            A[position] = tmp[index2];
            index2++;
            position++;
        }
    }
}
