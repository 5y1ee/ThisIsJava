package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		set.add("sy");
		set.add("aaron");
		set.add("lee");
		set.add("syl");
		
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String element = it.next();
			System.out.println(element);
			
			if (element.equals("aaron"))
				it.remove();
			
			
		}
		System.out.println();
		set.remove("sy");
		
		for (String elem : set)
			System.out.println(elem);
		
		// iterator가 편한 점.... 대부분 컬렉션이 갖고 있음
		
		
	}

}
