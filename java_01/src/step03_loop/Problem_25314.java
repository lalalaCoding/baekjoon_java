package step03_loop;

import java.util.Scanner;

public class Problem_25314 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer("long");
		for(int i = 1; i < n/4; i++){
			sb.append(" long");
		}
		sb.append(" int");
		System.out.println(sb);
	}
}
