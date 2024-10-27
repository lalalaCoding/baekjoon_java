package doIt.정렬;

import java.io.*;
import java.util.Arrays;

public class E1377_버블소트 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //1이상 50만 이하
        MyData[] A = new MyData[N]; //객체 배열 선언
        for (int i =0; i < N; i++) {
            MyData m  = new MyData(i, Integer.parseInt(br.readLine()));
            A[i] = m; //객체 배열 초기화
        }
        Arrays.sort(A); //배열 정렬 -> 시간 복잡도 O(nlogn)

        int max = 0; //정렬 전 index - 정렬 후 index -> 최대값을 저장하는 변수 선언 및 초기화
        for(int i = 0; i < N; i++) {
            //정렬 후 인덱스 = i
            //정렬 전 인덱스 = A[i].getOriginalIndex() -> 수열을 입력받을 때 원본 인덱스도 같이 저장되어 있었어야 한다.
            if (max < A[i].getOriginalIndex() - i) {
                max = A[i].getOriginalIndex() - i; //인덱스 차이의 최대값 저장
            }
        }

        System.out.println(max + 1); //max + 1 = 스왑이 일어나지 않은 안쪽 루프의 번째 수
        br.close();
    }
}

//Arrays.sort()는 Comaparable.compareTo() 메서드의 반환값에 따라 정렬을 해준다.
class MyData implements Comparable<MyData>{
    //필드
    private int originalIndex;
    private int inputData;

    //매개변수 생성자
    public MyData(int originalIndex, int inputData) {
        this.originalIndex = originalIndex;
        this.inputData = inputData;
    }

    @Override
    public int compareTo(MyData o) { //정렬기준을 작성
        int obj = this.inputData; //비교 기준
        int statement = o.getInputData(); //비교 대상

        return obj - statement; //오름차순 정렬
    }

    public int getOriginalIndex() {
        return this.originalIndex;
    }
    public void setOriginalIndex(int originalIndex) {
        this.originalIndex = originalIndex;
    }
    public int getInputData() {
        return this.inputData;
    }
    public void setInputData(int inputData) {
        this.inputData = inputData;
    }
}