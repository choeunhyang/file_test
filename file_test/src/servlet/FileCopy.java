package servlet;

import java.io.File;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\KOITT\\AppData\\Local\\Temp\\test.test");
		f.createNewFile();
		System.out.println(f.exists());
	}
}
