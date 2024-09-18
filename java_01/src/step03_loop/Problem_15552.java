package step03_loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_15552 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 콘솔을 통해 입력받음
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 콘솔을 통해 출력함
		
		
		try {
			int t = Integer.parseInt(br.readLine());
			for(int i = 0; i < t; i++){
				String[] arr = br.readLine().split(" ");
				int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
				bw.write(sum + "\n");
			}
			bw.flush(); // for문 밖에서 1번만 실행해도 됨. -> for문 안에서 하면 메모리 낭비임
			bw.close();
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
