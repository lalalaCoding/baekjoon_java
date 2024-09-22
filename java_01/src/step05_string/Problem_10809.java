package step05_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_10809 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			String s = br.readLine();
			
			int aCode = 'a';
			int zCode = 'z';
			
			int[] result = new int[zCode - aCode + 1]; // 결과 배열을 선언 
			
			
			for(int i = aCode; i <= zCode; i++){
				char compare = (char)i;
				boolean check = false;
				for(int k = 0; k < s.length(); k++){
					if(s.charAt(k) == compare){
						if(i != zCode){
							bw.write(k + " ");
						} else{
							bw.write(k + "");
						}
						check = true;
						break;
					}
					
				}
				if(!check){
					if(i != zCode){
						bw.write("-1 ");
					} else{
						bw.write("-1");
					}
				}
				
			}
			
			bw.flush();
			bw.close();
			br.close();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
