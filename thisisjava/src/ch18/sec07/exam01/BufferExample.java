package ch18.sec07.exam01;

import java.io.*;

public class BufferExample {

	static String fileDir = "C:\\Users\\fzaca\\Documents\\test4.txt";
	static String fileDir2 = "C:\\Users\\fzaca\\Documents\\test5.txt";
	
	public static void main(String[] args) throws Exception {
		
//		String originalFilePath1 = BufferExample.class.getResource(fileDir).getPath();
		String originalFilePath1 = fileDir;
		String targetFilePath1 = fileDir2;
		
		FileInputStream fis = new FileInputStream(originalFilePath1);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);
		
		
//		String originalFilePath2 = BufferExample.class.getResource(fileDir).getPath();
		String originalFilePath2 = fileDir;
		String targetFilePath2 = fileDir2;
		
		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long nonBufferTime = copy(fis, fos);
		System.out.println("no buffer " + nonBufferTime);
		
		long bufferTime = copy(bis, bos);
		System.out.println("buffer " + bufferTime);
		
		fis.close();
		fos.close();
		bis.close();
		bos.close();
	}
	
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		
		while (true) {
			int data = is.read();
			if (data == -1) break;
			os.write(data);
		}
		os.flush();
		long end = System.nanoTime();
		return (end-start);
	}

}
