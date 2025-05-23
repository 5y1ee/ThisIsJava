package ch06.sec08.exam01;

import java.util.Arrays;

public class Calculator {
	
	int ary[];
	
	void set(int ... x)
	{
		ary = new int[x.length];
		for (int i=0; i<x.length; ++i)
		{
			ary[i] = x[i];
		}
	}
	
	void modify(int idx, int val)
	{
		ary[idx] = val;
	}
	
	void print()
	{
		System.out.println(Arrays.toString(ary));
	}
	
	
	int plus(int x, int y)
	{
		return x + y;
	}
	
	double divide(int x, int y)
	{
		return (double)x / y;
	}
}
