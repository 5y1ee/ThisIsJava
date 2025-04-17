package ch19.sec06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJsonExample {

	public static void main(String[] args) {
		
//		BufferedReader br = null;
		String json = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Aaron/sy.json", Charset.forName("UTF-8")));
			json = br.readLine();
			br.close();
			
			
		} catch (IOException e) {
			System.out.println("##");
			e.printStackTrace();
		}
		
		JSONObject root = new JSONObject(json);
		
		System.out.println(root.getString("id"));
		System.out.println(root.getString("name"));
		System.out.println(root.getInt("age"));
		System.out.println(root.getBoolean("student"));
		
		JSONObject tel = root.getJSONObject("tel");
		System.out.println(tel.getString("email"));
		System.out.println(tel.getString("mobile"));
		
		JSONArray skill = root.getJSONArray("skill");
		for (int i=0; i<skill.length(); ++i) {
			System.out.println(skill.get(i));
		}
		
	}

}
