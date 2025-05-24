package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		
		try {
			OutputStream os = new FileOutputStream("C:\\Users\\fzaca\\Documents\\test1.db");
			
			byte a = 70;
			byte b = 80;
			byte c = 90;
			
			os.write(a);
			os.write(b);
			os.write(c);
			
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
