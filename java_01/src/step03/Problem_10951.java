package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_10951 {
	public static void main(String[] args){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			while(true){
				String str = br.readLine();
				if(str != null) {
					String[] arr = str.split(" ");
					int plus = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
					bw.write(plus + "\n");
				} else {
					break;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}	
