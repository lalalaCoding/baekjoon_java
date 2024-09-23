package step06_complex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1157 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			String s = br.readLine().toUpperCase();
			int[] result = new int[26];
			
			//A의 코드값은 65 -> 65-65번째 인덱스의 값을 1증가시킨다.
			for(int i = 0; i < s.length(); i++){
				char c = s.charAt(i); // A
				int code = c; // 65
				result[code-65] += 1;
			}
			
			// 최대값 계산
			int max = 0;
			int index = 0;
			for(int i = 0; i < 26; i++){
				if(max <= result[i]){
					max = result[i];
					index = i;
				} 
			}
			
			// 최대값이 중복되어있는지 검사하기
			int maxCount = 0;
			for(int i = 0; i < 26; i++){
				if(max == result[i]){
					maxCount++;
				}
			}
			
			// 결과 출력하기
			if(maxCount > 1){
				bw.write("?");
			} else{
				char c = (char)(index+65);
				bw.write(c+"");
			}
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
