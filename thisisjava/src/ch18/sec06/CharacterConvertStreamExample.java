package ch18.sec06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {

	static String fileDir = "C:\\Users\\fzaca\\Documents\\test4.txt";
	
	public static void main(String[] args) throws Exception {
		
		write("문자 변환 스트림을 사용합니다.");
		String data = read();
		System.out.println(data);
	}
	
	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream(fileDir);
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static String read() throws Exception {
		InputStream is = new FileInputStream(fileDir);
		Reader reader = new InputStreamReader(is, "UTF-8");
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		String str = new String(data, 0, num);
		return str;
	}

}
