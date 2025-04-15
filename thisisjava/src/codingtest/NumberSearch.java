package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberSearch {

	public static void main(String[] args) {
		
		String[] numStrs1 = {"ZASSETE", "S4Z537B", "7_ASZEYB"};
		String[] words1 = {"2455373","425","373","378"};
		
		String[] numStrs2 = {"ZAZZ373"};
		String[] words2 = {"2422373","5455373","2455373"};
		
		// 문제별 레퍼런스 저장용
		String[] numStrs = numStrs1;
		String[] words = words1;
		
		Map<Integer, String[]> mSubstitute = new HashMap<Integer, String[]>();
		mSubstitute.put(0, new String[]{"0","()"});
		mSubstitute.put(1, new String[]{"I"});
		mSubstitute.put(2, new String[]{"Z","S","7_"});
		mSubstitute.put(3, new String[]{"E","B"});
		mSubstitute.put(4, new String[]{"A"});
		mSubstitute.put(5, new String[]{"Z","S"});
		mSubstitute.put(6, new String[]{"b","G"});
		mSubstitute.put(7, new String[]{"T","Y"});
		mSubstitute.put(8, new String[]{"B","E3"});
		mSubstitute.put(9, new String[]{"g","q"});
		
		
		
//		List<String> slist = new ArrayList<>();
//		slist.add("ori");
//		System.out.println(slist.toString());
//		Func(slist);
//		System.out.println(slist.toString());
		
		
		int wordsCnt = words.length;
		int[] res = new int[wordsCnt];	// 결과값 넣을 배열
		for (int i=0; i<wordsCnt; ++i) {
			// words[i]가 가변 가능한 모든 문자열을 담을 리스트
			List<String> sList = new ArrayList<>();
			
			String word = words[i];	// 425
			int wordCnt = word.length();
			
			
			
		}
		
		
	}
	
	
	public static void Func(List<String> sList, String word, Map<Integer, String[]>) {
		list.add("new");
	}

}



/*

0 O ()
1 I
2 Z, S, 7_
3 E, B
4 A
5 Z, S
6 b, G
7 T, Y
8 B, E3
9 g, q

2,5 Z,S
3,8 B

"425" -> A25
"373" -> ETE, 37B, EYB


numStrs <= 100
numStrs[i] <= 100

words <= 10
words[i] <= 8

B7_ => 37_



*/