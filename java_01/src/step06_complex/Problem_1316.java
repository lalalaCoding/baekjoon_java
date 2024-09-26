package step06_complex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1316 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int num = Integer.parseInt(br.readLine());
			int count = 0;
			for(int i = 0; i < num; i++){
				String str = br.readLine();
				int length = str.length();
				boolean flag = true;
				if(length < 3) {
					count++;
				} else { // 문자열의 길이가 3이상임
					for(int k = 0; k < length - 2; k++) {
						if(str.charAt(k) != str.charAt(k+1)) {
							for(int j = k+2; j < length; j++) {
								if(str.charAt(k) == str.charAt(j)) {
									// 그룹 문자가 아닌 경우임
									flag = false;
									break;
								} 
							}
						}
					}
					if(flag) {
						count++;
					}
				}
			}
			
			bw.write(count + "");
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
