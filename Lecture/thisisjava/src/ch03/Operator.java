package ch03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operator {

	public static void main(String[] args) {
		
		
		int[] arr = {1,2,3,5,4};
		int cnt = arr.length;
		
		String str = "123";
		int scnt = str.length();
		

		List<Integer> list = new ArrayList<Integer>(3);
		list.size();
		
		int[] ary = new int[5];
		int length = Array.getLength(arr); // arr.length와 동일한 값
		
		Integer ii = 1;
		
		Arrays.sort(arr);
//		System.out.println(Arrays.deepToString(arr));
		for (var i : arr)
		{
			System.out.println(i);
		}
		System.out.println(arr);
		
		
		
	}

}
