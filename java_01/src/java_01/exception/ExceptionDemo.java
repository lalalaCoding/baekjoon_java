package java_01.exception;

import java.io.IOException;

class Animal {
	public void divide(int num) {
		System.out.print(10/num);
	}
}

class MyException extends Exception {
	public MyException() {}
	public MyException(String msg) {
		super(msg);
	}
}



public class ExceptionDemo {
	public static void main(String[] args) {
		// 예외 메시지 살펴보기
		//new Animal().divide(0);
		
		//throw new MyException("메시지를 입력합니다.");
		
		
		// 다중 캐치 유의 사항
		try {
			System.out.println("다중 캐치 유의 사항 확인");
		} catch(Exception e) {
			System.out.println("Exception 처리 범위");
		} /*
			 * catch(IOException e) { System.out.println(); }
			 */
		
		
		
		
	}
}
