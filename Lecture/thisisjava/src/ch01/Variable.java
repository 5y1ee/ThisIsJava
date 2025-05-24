package ch01;

public class Variable {
	public static void main(String[] args)
	{
		System.out.println("2222");
//		char c = '';
		
//		Variable d = ' ';
		
		byte a, b, c;
		a = 10;
		b = 5;
//		c = a + b;
		c = (byte)(a + b);
//		byte d = a+c;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
		
		
		String sInt = "10";
		String sDb = "3.14";
		String sCh = "c";
		
		int res = 0;
		for (int i=0; i<sInt.length(); ++i)
		{
			res *= 10;
			res += (int)sInt.charAt(i);
			System.out.println(sInt.charAt(i));
		}
		System.out.println(res);
		
		
	}
}
