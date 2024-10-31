package doIt.정렬;

import java.io.*;

public class E2751_수정렬하기2 {
    public static int[] A, tmp; // 배열을 동시에 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1]; //
        tmp = new int[N + 1]; //병합 과정에서의 원본을 저장할 임시 배열
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine()); //배열 초기화
        }

        merge_sort(1, N); //병합 정렬 수행

        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void merge_sort(int start, int end) {
        //집합 분할하기
        if (end - start < 1) {
            return; //집합의 시작점과 종료지점이 같다면, 더 이상 분할을 할 수 없으므로 종료시킨다.
        }

        int mid = start + (end - start)/2;//중간점 mid구하기
        merge_sort(start, mid);
        merge_sort(mid + 1, end);

        //병합 정렬 수행하기
        System.arraycopy(A, start, tmp, end, end - start + 1);//병합하려는 두 집합의 데이터를 임시 배열에 옮겨 닮기
        /*for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }*/

        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            //양쪽 그룹에서 각 index가 가르키는 값을 비교해 더 작은 수를 배열에 저장하고,
            //선택된 데이터의 index값을 오른쪽으로 한 칸 이동하기
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                index2++;
                k++;
            } else {
                A[k] = tmp[index1];
                index1++;
                k++;
            }
        }

        while (index1 <= mid) { //왼쪽 그룹에 정렬해야할 데이터가 남아있는 경우
            A[k] = tmp[index1];
            index1++;
            k++;
        }
        while (index2 <= end) { //오른쪽 그룹에 정렬해야할 데이터가 남아있는 경우
            A[k] = tmp[index2];
            index2++;
            k++;
        }
    }
}
