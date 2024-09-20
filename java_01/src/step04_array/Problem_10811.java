package step04_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_10811 {
	public static void main(String[] args){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 바구니의 총 갯수
			int[] basket = new int[n]; // 바구니 배열의 선언
			for(int i = 0; i < n; i++){
				basket[i] = i + 1; // 바구니 배열의 초기화
			}
			
			int m = Integer.parseInt(st.nextToken()); // 교환할 회수
			for(int i = 0; i < m; i++){
				StringTokenizer change = new StringTokenizer(br.readLine(), " ");
				int begin = Integer.parseInt(change.nextToken()); // 1
				int end = Integer.parseInt(change.nextToken()); // 4
				
				if(end - begin != 0){
					int[] temp = new int[end - begin + 1]; // 길이 4인 배열 (임시 저장용) 
					int index = 0;
					for(int k = end; k >= begin; k--){
						temp[index] = basket[k - 1];
						index++;
					} // 임시 저장용 배열을 초기화 (역순으로 값을 저장함)
					
					int index2 = 0;
					for(int k = begin; k <= end; k++){
						basket[k - 1] = temp[index2];
						index2++;
					}	
				}
			}
			
			for(int i = 0; i < basket.length; i++){
				if(i != basket.length - 1){
					bw.write(basket[i] + " ");
				} else{
					bw.write(basket[i] + "");
				}
			}
			
			bw.flush();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
