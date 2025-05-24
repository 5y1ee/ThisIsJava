package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<Board> list = new ArrayList<>();
		
		list.add(new Board("title1", "content1", "writer1"));
		list.add(new Board("title2", "content2", "writer2"));
		list.add(new Board("title3", "content3", "writer3"));
		list.add(new Board("title4", "content4", "writer4"));
		list.add(new Board("title5", "content5", "writer5"));
		
		int size = list.size();
		System.out.println(size);
		
		Board board = list.get(2);
//		System.out.println(board.getSubject()+"\t"+board.getContent()+"\t"+board.getWriter());
		System.out.println(board);
		
		System.out.println();
		for(int i=0; i<size; ++i) {
			System.out.println(list.get(i));
		}
		
		list.remove(2);
		list.remove(2);
		
		System.out.println();
		for(Board b : list)
			System.out.println(b.toString(1));
		
		// toString 오버로딩...
		
		// 출력 결과가 왜..? \t 가 이상하게 나오네
		// 

//		Object o=null;
//		o.toString();
		
	}

}
