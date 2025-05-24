package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:\\Users\\fzaca\\Documents\\test2.db");
			byte[] array = {67,92,100,76};
			os.write(array);
			os.flush();
			os.close();
			
			Writer writer = new FileWriter("C:\\Users\\fzaca\\Documents\\test3.txt");
			char[] arr = {'a','b','e','f'};
			writer.write(arr);
			writer.write("FGH");
			writer.flush();
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
