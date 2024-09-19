package java_review;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// 현재 시각을 날짜 클래스로 나타내보기
public class DateDemo {
	public static void main(String[] args) {
		// 1. Date 겍체의 기본 포맷을 출력하기
		Date nowDate = new Date();
		System.out.println(nowDate); // Mon Sep 16 19:04:23 KST 2024
		
		// 2. Calendar 객체를 이용해 특정 포맷으로 출력하기
		Calendar nowCal = Calendar.getInstance();
		int year = nowCal.get(Calendar.YEAR);
		int month = nowCal.get(Calendar.MONTH);
		int day = nowCal.get(Calendar.DATE);
		
		System.out.printf("%d년 %d월 %d일", year, month, day); // 2024년 8월 16일
		
		// 3.
		GregorianCalendar gc = new GregorianCalendar();
		int year1 = gc.get(Calendar.YEAR);
		int month1 = gc.get(Calendar.MONTH);
		int day1 = gc.get(Calendar.DATE);
		
		System.out.printf("%d년 %d월 %d일", year1, month1, day1);
		
		//
		SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date now = new Date();
		String s = sdf0.format(now);
		System.out.println(s);
		
	}
}
