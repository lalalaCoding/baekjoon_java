package java_review;

import java.io.File;

public class FIleDemo {
	public static void main(String[] args) {
		File file = new File("C:\\dev/readme.txt");
		System.out.println(file.getName());
		System.out.println(file.getParent()); // C:\dev
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
	}
}
