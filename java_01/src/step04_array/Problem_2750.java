package step04_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_2750 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n]; // 배열 선언
			int[] result = new int[n]; // 정렬 결과를 담을 배열을 선언
			
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(br.readLine());
			} // 배열 초기화
			
			
			int min = arr[0];
			int ind = 0;
			
			for(int k = 0; k < n; k++){
				for(int i = 0; i < n; i++) {
					if(arr[k] <= arr[i]) {
						min = arr[k];
						ind = k;
					} else {
						min = arr[i];
						ind = i;
					}
				}
				result[k] = min;
			}
			
			System.out.println(Arrays.toString(result));
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
