package step03_loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_2439 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int n = Integer.parseInt(br.readLine()); // 줄의 반복횟수
			for(int line = 1; line <= n; line++){
				for(int space = 1; space <= n - line; space++){
					bw.write(" "); // 공백 찍기
				}
				for(int star = 1; star <= line; star++){
					bw.write("*"); // 별 찍기
				}
				bw.newLine(); // 줄바꿈
			}
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
