package step03_loop;

import java.util.Scanner;

public class Problem_10950 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < t; i++){
			String[] arr = sc.nextLine().split(" ");
			System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
		}
		
	}
}
