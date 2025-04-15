package ch17.sec02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.ToString;

public class ParallelStreamExample {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(name -> {
			System.out.println(name + " : " + Thread.currentThread().getName());
		});
		
		List<Member> mlist = new ArrayList<Member>();
		mlist.add(new Member());
		mlist.stream().forEach(d->System.out.println(d));
		
		Stream<String> strStream = list.stream();
		System.out.println(strStream);
		
	}
}

@ToString
class Member {
	private int no;
}
