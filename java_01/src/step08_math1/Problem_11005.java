package step08_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_11005 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()); // 25
			int q = 0;
			int notation = Integer.parseInt(st.nextToken()); // 2진법
			
			StringBuffer sb = new StringBuffer("");
			
			ArrayList<Integer> modList = new ArrayList<Integer>(); // [1, 0, 0, 1]
			ArrayList<Integer> quoList = new ArrayList<Integer>(); // [12, 6, 3, 1]
			
			while(true){
				q = num/notation;
				
				if(q == 0){
					break;
				} else{
					quoList.add(q);
					modList.add(num%notation);
					num = q;
				}
			}
			
			int size = modList.size();
			
			// 마지막 몫이 첫번째 수가 된다.
			if(quoList.get(size - 1) > 9) {
				char c = (char)(quoList.get(size - 1) + 55);
				sb.append(c + "");
			} else {
				sb.append(quoList.get(size - 1)+"");
			}
			// 나머지를 거꾸로 나열하면 된다.
			for(int i = 1 ; i <= size; i++) {
				if(modList.get(size - i) > 9) {
					char c = (char)(modList.get(size - i) + 55);
					sb.append(c + "");
				} else {
					sb.append(modList.get(size - i) + "");
				}
			}
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
