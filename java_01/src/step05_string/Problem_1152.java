package step05_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_1152 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			String[] arr = br.readLine().split(" ");
			
			if(arr.length > 0) {
				if(arr[0].equals("")) {
					bw.write(arr.length - 1 + "");
				} else {
					bw.write(arr.length + "");
				}
			} else {
				bw.write(arr.length + "");
			}
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
