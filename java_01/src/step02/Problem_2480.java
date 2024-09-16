package step02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem_2480 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.nextLine().split(" ");
		ArrayList<String> list = new ArrayList<String>();
		for(String s : arr){
			list.add(s);
		}
		Collections.sort(list); // 크기 순으로 정렬됨
		
		// 가운데 숫자를 기준으로 같은 눈의 수를 셈하자
		int count = 0;
		if(list.get(0).equals(list.get(1))) {
			count++;
		}
		if(list.get(2).equals(list.get(1))){
			count++;
		}
		
		switch(count){
		case 0 :
			System.out.println(Integer.parseInt(list.get(2))*100);
			break;
		case 1 :
			System.out.println(1000+(Integer.parseInt(list.get(1))*100));
			break;
		case 2 :
			System.out.println(10000+(Integer.parseInt(list.get(1))*1000));
		}
		
		
		
	}
}
