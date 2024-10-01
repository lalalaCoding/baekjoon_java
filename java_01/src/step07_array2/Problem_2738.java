package step07_array2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2738 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			int arr1[][] = new int[row][col]; // new 자료형[행][열]
			int[][] arr2 = new int[row][col];
		
			for(int i = 0; i < row; i++){
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				int[] colArr = new int[col];
				for(int j = 0; j < col; j++){
					colArr[j] = Integer.parseInt(st2.nextToken());
				}
				arr1[i] = colArr;
			}
			for(int i = 0; i < row; i++){
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				int[] colArr = new int[col];
				for(int j = 0; j < col; j++){
					colArr[j] = Integer.parseInt(st2.nextToken());
				}
				arr2[i] = colArr;
			}
			
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					if(c != col - 1){
						bw.write(arr1[r][c]+ arr2[r][c] + " ");
					} else{
						bw.write(arr1[r][c] + arr2[r][c] + "\n");
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
