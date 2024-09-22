package step05_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2675 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < num; i++){
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int loop = Integer.parseInt(st.nextToken());
				String[] arr = st.nextToken().split("");
				
				StringBuffer sb = new StringBuffer("");
				
				for(String s : arr){
					for(int j = 0; j < loop; j++){
						if(s.equals("\\")){
							sb.append(s+"\\");
						} else{
							sb.append(s);
						}
					}
				}
				
				bw.write(sb + "\n");
			}
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
