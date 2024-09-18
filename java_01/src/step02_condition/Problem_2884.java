package step02_condition;
import java.util.Scanner;

public class Problem_2884 {
	public static void main(String[] agrs){
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		
		if(min >= 45){ // 45분 이상일 때
			System.out.println(hour + " " + (min-45));
		} else{ // 45분 미만일 때 -> 시간을 1줄여야함
			int resultMin = 60 + min - 45;
			int resultHour = hour - 1;
			if(resultHour >= 0){
				System.out.println(resultHour + " " + resultMin);
			} else{ // 이전날로 계산해야함
				System.out.println("23 " + resultMin);
			}
		}
	}
}
