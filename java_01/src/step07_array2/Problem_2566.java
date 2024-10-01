package step07_array2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2566 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			int[][] arr = new int[9][9]; // [행의수][열의수]
			
			for(int r = 0; r < 9; r++){
				int[] colArr = new int[9];
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				int col = 0;
				while(st.hasMoreTokens()){
					colArr[col] = Integer.parseInt(st.nextToken());
					col++;
				}
				arr[r] = colArr; // 얕은 복사
			} // 이차원 배열을 초기화 완료
			
			// 최대값 찾기
			int maxNum = 0;
			int maxRow = 0;
			int maxCol = 0;
			
			for(int r = 0; r < 9; r++){
				for(int c = 0; c < 9; c++){
					if(maxNum <= arr[r][c]){
						maxNum = arr[r][c];
						maxRow = r + 1; // 행과 열은 1행부터 9행까지로 처리한다.
						maxCol = c + 1;
					}					
				}
			}
			
			bw.write(maxNum + "\n");
			bw.write(maxRow + " " + maxCol);
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
