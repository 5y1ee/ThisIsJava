package ch06.sec08.exam01;

import java.util.Arrays;

//import ch01.Variable;

class Temp {
	public int ary[] = {1,2,3};
	
	int[] getAry()
	{
		return ary;
	}

//	Variable v = new Variable();
	
}

public class CalcEx {
	
	
	public static void main(String[] args) {
		System.out.println(new Calculator().plus(10, (int)new Calculator().divide(9, 3)));
	
		int var = 99;
		System.out.println(var);
		String tmp = "";
//		char ch = '';
		
		
		var calc = new Calculator();
		calc.set(1,2,3,4,5);
		calc.print();
		
		calc.modify(0, 99);
		calc.print();
		
		var tt = new Temp();
		func(tt.getAry(), 99);
		System.out.println(Arrays.toString(tt.ary));
		
		
	}
	
	static void func(int[] ary, int val)
	{
		ary[0] = val;
	}
}
