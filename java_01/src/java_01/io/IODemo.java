package java_01.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class IODemo {
	public static void main(String[] args) {
		InputStreamReader ist = new InputStreamReader(System.in);
		
		try {
			FileReader fr = new FileReader(new File("C:\\text.txt"));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
