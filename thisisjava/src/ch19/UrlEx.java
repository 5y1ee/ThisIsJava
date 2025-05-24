package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEx {

	public static void main(String[] args) {
		// URL로 요청 후 응답받은 데이터를 콘솔에 출력.
		
		URL url = null;
		BufferedReader br = null;
		
		try {
			url = new URL("https://www.work24.go.kr/cm/main.do");
			System.out.println(url.getPath());
			System.out.println(url.getProtocol());
			
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			/*
			 * 1. url.openStream() : url에서 바이트 스트림을 오픈
			 * 2. InputStreamReader() : 바이트 스트림을 문자 스트림으로 변환함
			 * 3. BufferedReader() : 문자 스트림을 버퍼에 담아 한 줄씩 읽을 수 있게 해줌 -> readLine() 같은 걸 쓸 수 있게 함
			 */
			
			String readLine = "";
			while ((readLine = br.readLine()) != null) {
				
//				System.out.println(readLine);
				
			}
			
			
			// url encoder
			String txt = "한글이다.";
			String txt2 = URLEncoder.encode(txt);
			System.out.println(txt2);
			String txt3 = URLDecoder.decode(txt2);
			System.out.println(txt3);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
	}

}
