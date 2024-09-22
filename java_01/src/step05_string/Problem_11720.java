package step05_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_11720 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int sum = 0;
			for(int i = 0; i < str.length(); i++){
				sum += Integer.parseInt(str.substring(i, i));
			}
			bw.write(sum + "");
			bw.flush();
			bw.close();
			br.close();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
}
