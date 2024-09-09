package java_01.condition;

public class SwitchDemo {
	
	static String str = "개나리";
	
	public static void main(String[] args) {
		
		switch(str) {
		case "개나리", "진달래" :
			System.out.println(str);
		}
		
		
		// switch문 축약 문법
		switch(str) {
		case "개나리" : case "진달래" :
			System.out.println(str);
		}
		
		
		
		
	}
	
	
	
	
}
