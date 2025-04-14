package ch02;

import java.util.Scanner;

import ch01.Variable;

public class ScannerSample {
	
	int m_field;
	public void func() {
		System.out.println(m_field);
		
		int i_var;
		System.out.println(i_var);
	}

	public static void main(String[] args) {
		
		func();
		
//		Variable v = new Variable();
		
		
		// ctrl shift o
		Scanner scanner = new Scanner(System.in);
		
//		System.out.print("d : ");
//		System.out.println(scanner.nextLine());
		
//		System.out.print("d2 : ");
//		int d = scanner.nextInt();
//		System.out.println(d);
//		
//		System.out.print("d3 : ");
//		String str = scanner.nextLine();
//		System.out.print(str);
////		System.out.print(str);
//		System.out.print("d4 : ");
//		str = scanner.nextLine();
//		System.out.println(str);
//		System.out.print("d5 : ");
		
		
//		int i = scanner.nextInt();
//		String s = scanner.nextLine();
//		System.out.println(i + s);

		
//		String name = null;
		String name = new String();
		System.out.println(name.equals("null"));
		
		
		
		
	}

}
