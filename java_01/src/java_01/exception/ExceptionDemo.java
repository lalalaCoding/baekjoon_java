package java_01.exception;

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
		
	}
}
