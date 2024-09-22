package step05_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_9086 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < t; i++){
				String str = br.readLine();
				bw.write(str.charAt(0) + "" + str.charAt(str.length() - 1) + "\n");
			}
			bw.flush();
			bw.close();
			br.close();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
}
