package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		
		try {
			InputStream is = new FileInputStream("C:\\Users\\fzaca\\Documents\\test1.db");
			
			while (true) {
				int data = is.read();
				if (data == -1) break;
				System.out.println(data);
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			InputStream is = new FileInputStream("C:\\Users\\fzaca\\Documents\\test2.db");
			byte[] data = new byte[100];
			
//			while (true) {
				int num = is.read(data);
//				if (num == -1) break;
				
				for (int i=0; i<num; ++i) {
					System.out.println(data[i]);
				}
//			}
			is.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
