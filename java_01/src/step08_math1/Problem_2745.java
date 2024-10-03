package step08_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2745 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken(); // 숫자
			int notation = Integer.parseInt(st.nextToken()); // 진법
			
			int result = 0;
			
			for(int i = 0; i < str.length(); i++){
				char c = str.charAt(i); 
				int code = c; // 문자의 코드 값
				int number = 0; // 문자가 가르키는 실제 숫자 값
				int digit = 1; // 자릿수에 대한 단위 값
				for(int j = i + 1; j < str.length(); j++){
					digit *= notation;
				}
				if(code >= 65 && code <= 90){ // 수가 문자형인 경우
					number = code - 55; // 실제 숫자	
					result += number*digit;
				} else{ // 수가 숫자형인 경우
					number = code -48;
					result += number*digit;
				}
			}
			
			bw.write(result + "");
			bw.flush();
			bw.close();
			br.close();
			
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
