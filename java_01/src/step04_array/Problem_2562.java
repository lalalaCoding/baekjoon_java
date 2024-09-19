package step04_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_2562 {
	public static void main(String[] args){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			
			int[] arr = new int[9];
			int max = 0;
			int index = 0;
			for(int i = 0; i < 9; i++){
				arr[i] = Integer.parseInt(br.readLine());
				// 3, 29, 38, 12, 57, 74, 40, 85, 61
				if(max <= arr[i]){
					max = arr[i];
					index = i+1;
				}
			}
			
			bw.write(max + "\n");
			bw.write(index + "");
			bw.flush();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
