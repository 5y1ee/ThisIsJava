package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

	public static void main(String[] args) {
		
		String[] names = {"이사람", "저사람", "이군", "조모양"};
		
		Map<String, Integer> map = new HashMap<>();
		
		for (String n : names) {
			String str = String.valueOf(n.charAt(0)); // 이걸로 대체하면 간단할듯
			if (map.get(String.valueOf(n.charAt(0))) == null) {
				map.put(String.valueOf(n.charAt(0)), 1);
			} else {
				map.put(String.valueOf(n.charAt(0)), map.get(String.valueOf(n.charAt(0)))+1);
			}
		}
		System.out.println(map);
		
		
	}

}
