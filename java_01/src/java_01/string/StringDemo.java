package java_01.string;

public class StringDemo {

	public static void main(String[] args) {
		
		String str1 = "개나리";
		String str2 = "개나리";
		String str3 = new String("개나리");
		
		System.out.println(str1 == str2); // true
		System.out.println(str1 == str3); // false
		
		String str4 = null;
		String str5;
		String str6 = "";
		
		
		str1.replace("개", "소");
		System.out.println(str1);
		
		
		String before = "   개  나  리   ";
		String after = before.trim();
		System.out.println(before);
		System.out.println(after);
		
		
	}
	
	
	
	
	
	
	
}
