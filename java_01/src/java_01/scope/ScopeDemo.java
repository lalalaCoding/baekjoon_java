package java_01.scope;

public class ScopeDemo {
	static int i = 5;

    static void a() {
        int i = 10;
        b();
    }

    static void b() {
        System.out.println(i); // i는 b()메소드의 유효범위에 있는 i의 값을 가르킨다.
    }

    public static void main(String[] args) {
        a(); // 5를 출력.
    }

}
