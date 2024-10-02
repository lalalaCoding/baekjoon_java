package step07_array2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2563 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int n = Integer.parseInt(br.readLine());
			boolean[][] coordinate = new boolean[100][100]; // coordinate[0][0]은 왼쪽 꼭짓점의 좌표가 (0,0)인 1x1 정사각형
			int area = 0; 
			
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				// 왼쪽 꼭짓점을 가르키는 변수 x, y를 초기화
				int x = 0;
				int y = 0; 
				
				while(st.hasMoreTokens()) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
				}
				// (3,7)인 경우
				// (3,7), (4,7), ... , (12, 7)
				// (3,8), (4,8), ... , (12, 8)
				
				// (3,16), (4,16), ... , (12,16) 을 마킹한다.
				for(int markX = x; markX < x + 10; markX++) {
					for(int markY = y; markY < y + 10; markY++) {
						if(!coordinate[markX][markY]) {
							coordinate[markX][markY] = true;
							area++;
						}
					}
				}
			}
			bw.write(area + "");
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}		
	}
}
