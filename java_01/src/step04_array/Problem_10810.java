package step04_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_10810 {
	public static void main(String[] args){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 5, 4
			int n = Integer.parseInt(st.nextToken()); // 바구니의 총 개수
			int m = Integer.parseInt(st.nextToken()); // 공을 넣을 횟수 -> 반복문의 횟수
			
			String[] basket = new String[n]; // 바구니의 갯수만큼 배열을 선언
			
			for(int i = 0; i < m; i++){
				StringTokenizer st1 = new StringTokenizer(br.readLine(), " "); // 1, 2, 3
				int start = Integer.parseInt(st1.nextToken());
				int end = Integer.parseInt(st1.nextToken());
				String input = st1.nextToken(); // 문자열 타입
				for(int k = start - 1; k < end; k++){
					basket[k] = input;
				}
			}
			
			for(int i = 0; i < basket.length; i++){
				if(i < basket.length - 1){
					if(basket[i] == null){
						bw.write(0 + " ");
					} else{
						bw.write(basket[i] + " ");
					}
				} else{
					if(basket[i] == null){
						bw.write(0 + "");
					} else{
						bw.write(basket[i]);
					}
				}
			}
			
			bw.flush();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
