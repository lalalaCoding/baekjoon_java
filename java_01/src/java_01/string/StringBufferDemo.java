package java_01.string;

public class StringBufferDemo {
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("개나리");
		StringBuffer sb0 = new StringBuffer();
		// capacity() : int -> 수용량 반환
		System.out.println(sb0.capacity()); // 16
		System.out.println(sb0.length());
		System.out.println(sb.capacity()); // 19 (기본16 + 3)
		
		// append(String str) : StringBuffer -> 이어 붙이기
		System.out.println(sb); // 개나리
		StringBuffer sb1 = sb.append("소나무");
		System.out.println(sb); // 개나리소나무
		System.out.println(sb1);
		
		// insert(int offset, String str) : StringBuffer -> 삽입
		StringBuffer isb = new StringBuffer("개나리");
		isb.insert(1, "고드름");
		System.out.println(isb);
		
		// delete(int start, int end) : StringBuffer -> 제거
		StringBuffer dsb = new StringBuffer("배가 몹시 고픕니다");
		dsb.delete(1, 4);
		System.out.println(dsb);
	
		
		
		
	}
	
	
}
