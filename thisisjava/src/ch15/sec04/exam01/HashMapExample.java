package ch15.sec04.exam01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("A", 85);
		map.put("B", 90);
		map.put("C", 80);
		map.put("B", 95);
		System.out.println("Entry수:"+map.size());
		System.out.println();
		
		String key = "B";
		int value = map.get(key);
		System.out.println(key+":"+value);
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			String k = keyIterator.next();
			Integer v = map.get(k);
			System.out.println(k+":"+v);
		}
		System.out.println();
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k+":"+v);
		}
		System.out.println();
		
		map.remove("B");
		System.out.println("entry cnt:"+map.size());
		System.out.println();
		
		
		Collection<Integer> values = map.values();
		for (var i : values)
			System.out.println(i);
		
		
		
	}

}
