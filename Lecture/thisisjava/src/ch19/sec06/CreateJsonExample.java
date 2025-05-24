package ch19.sec06;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {

	public static void main(String[] args) {
		
		JSONObject root = new JSONObject();
		
		// 속성 추가
		root.put("id", "winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);
		
		// 객체 속성 추가
		JSONObject tel = new JSONObject();
		tel.put("mobile", "010-5577-1065");
		tel.put("email", "yunisy51@gmail.com");
		
		root.put("tel", tel);
		
		// 배열 속성 추가
		JSONArray skill = new JSONArray();
		skill.put("java");
		skill.put("c++");
		skill.put("python");
		skill.put("c#");
		
		root.put("skill", skill);
		
		// Json 얻기
		String json = root.toString();
		
		System.out.println(json);
		
		try {
			Writer writer = new FileWriter("C:/Aaron/sy.json", Charset.forName("UTF-8"));
			writer.write(json);
			writer.flush();	// flush를 하지 않으면 write가 제대로 되지 않음.
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
