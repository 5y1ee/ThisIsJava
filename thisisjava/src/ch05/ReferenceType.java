package ch05;

import java.util.Arrays;

public class ReferenceType {

	public static void main(String[] args) {
		
		int[] a1 = new int[] {1,2,3};
		int[] b1 = a1;
		
		System.out.println(Arrays.toString(b1));
		a1[0] = 99;
		System.out.println(Arrays.toString(b1));
		System.out.println(a1 == b1);
		
		// 문자열 리터럴, new String
		String str1 = "literal";
		String str2 = "literal";
		
		String str3 = new String("ref");
		String str4 = new String("ref");
		
		System.out.println((str1 == str2) + " " + (str3 == str4));
		
		
		// heap, stack
		// primitive 변수는 stack
		// Ref 변수는 heap
		
		str1.replace('i', '2');
		System.out.println(str1.replace('i', '2'));
		System.out.println(str1.replace('\n', '2')); // 얜 변함이 없네. string 메타데이터로 length를 갖고 있어서 그런가?
		
//		System.out.print(str1.replace('\n', '2'));
		
//		for (int i=0; i<=str1.length(); ++i)
//		{
//			System.out.println(str1.charAt(i));
//		}
		
		// \0 문자가 안쓰이나?
		// 디폴트 파라미터를 안쓰나?
		str1.substring(0);
		str1.substring(0,1);
		
		// 배열이 왜 레퍼런스인가. c, cpp는 값임
		System.out.println(a1);
		
		
		int[] aryy;
		
		
	}

}
