package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_11021 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int t = Integer.parseInt(br.readLine());
			for(int i = 0; i < t; i++){
				
				String[] arr = br.readLine().split(" ");
				int plus = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
				//Case #1: 2
				bw.write("Case #" + (i+1) + ": " + plus + "\n");
			
			}
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
