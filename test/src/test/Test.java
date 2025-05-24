package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
//import java.util.Arrays.ArrayList;

public class Test {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		int[][] dp;
		dp = new int[10][];
		dp[0] = new int[10];
		
		/*
		    public static <T> List<T> asList(T... a) {
		        return new ArrayList<>(a);
		    }
		 */
		
		Integer[] ary = {1,2,3,4,5};
		reverse(Arrays.asList(ary));
		
		int[] ary2 = {1,2,3,4,5};
		reverse(Arrays.asList(ary2));
		
//		System.out.println("dd:"+Arrays.asList(ary2).toString().toString());
		
		var tmp = Arrays.asList(ary2);
		System.out.println(tmp +"\n" + tmp.toString() +"\n"+ tmp.get(0).toString()
				+"\n"+tmp.get(0)[0]);
		
		
//		System.out.println(Arrays.toString(ary));
		
//		Arrays.asList(null)
		
	}
	
    public static void reverse(List<?> list) {
        int size = list.size();
        System.out.println("size" + size);
        if (size < 18 || list instanceof RandomAccess) {
            for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
                swap(list, i, j);
        } else {
            // instead of using a raw type here, it's possible to capture
            // the wildcard but it will require a call to a supplementary
            // private method
            ListIterator fwd = list.listIterator();
            ListIterator rev = list.listIterator(size);
            for (int i=0, mid=list.size()>>1; i<mid; i++) {
                Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        }
    }
    
    public static void swap(List<?> list, int i, int j) {
        // instead of using a raw type here, it's possible to capture
        // the wildcard but it will require a call to a supplementary
        // private method
        final List l = list;
        System.out.println(l.toString());
        l.set(i, l.set(j, l.get(i)));
    }

	
}
