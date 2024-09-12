package java_01.Polymorphism;

import java.util.Arrays;

class Animal {
}


public class PolymorphismDemo {
	public static void main(String[] args) {
		
		Object[] objArr = new Object[5];
		objArr[0] = "개나리";
		objArr[1] = 1;
		objArr[2] = new Animal();
		
		System.out.println(Arrays.toString(objArr));
	}
}
