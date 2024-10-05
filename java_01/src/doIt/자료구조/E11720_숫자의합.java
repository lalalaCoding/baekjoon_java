package doIt.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class E11720_숫자의합 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			long sum = 0;
			
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split("");
			for(int i = 0; i < arr.length; i++) {
				sum += Integer.parseInt(arr[i]);
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
