package step06_complex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_2941 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			String str = br.readLine();
			String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
			
			for(int i = 0; i < arr.length; i++){
				if(str.contains(arr[i])){
					str = str.replace(arr[i], "/");
				}
			}
			
			bw.write(str.length() + "");
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
