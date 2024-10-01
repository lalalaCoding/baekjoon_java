package step07_array2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_10798 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			String[][] arr = new String[5][15];
		
			for(int i = 0; i < 5; i++){
				String[] oneDir = new String[15];
				String[] split = br.readLine().split(""); // 한 글자씩 자름 -> 문자의 갯수만큼의 길이를 갖는 배열이 만들어짐
				
				for(int j = 0; j < split.length; j++){
					oneDir[j] = split[j];
				}
				
				arr[i] = oneDir;
			}
			
			StringBuffer sb = new StringBuffer("");
			for(int c = 0; c < 15; c++){
				for(int r = 0; r < arr.length; r++){
					if(arr[r][c] != null){
						sb.append(arr[r][c]);
					}
				}
			}
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

