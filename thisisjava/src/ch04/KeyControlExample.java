package ch04;

import java.util.Scanner;

public class KeyControlExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int speed = 0;
		
		while (!run) {
			System.out.println("======\n1.UP|2.DOWN|3.STOP\n=====\nInput:");
			
			String strNum = scanner.nextLine();
			int num = Integer.parseInt(strNum);
			
			switch (num)
			{
			case 1:
				++speed;
				System.out.println("Current Speed "+speed);
				break;
			case 2:
				--speed;
				System.out.println("Current Speed "+speed);
				break;
			case 3:
				run = false;
				break;
			}
		}
		
		System.out.println("Shut down.");
		
		int sum=0;
		for (int i=1; i<=100; ++i)
		{
			sum += i%3==0 ? i : 0;
		}
		System.out.println(sum);
		
		int a,b;
		do {
			a = (int)(Math.random()*6+1);
			b = (int)(Math.random()*6+1);
			System.out.println("("+a+","+b+")");
		}
		while (a+b!=5);
		
		System.out.println("adf");
		
		for (int x=1; x<=10; ++x)
		{
			for (int y=1; y<=10; ++y)
			{
				if (4*x+5*y==60)
					System.out.println("("+x+","+y+")");
			}
		}
		
		for(int i=0; i<5; ++i)
		{
			for (int k=0; k<=i; ++k)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		boolean flag = true;
		int budget = 0;
		while (flag)
		{
			System.out.print("========\n1.예금|2.출금|3.잔고|4.종료\n========\n선택> ");
			String str = scanner.nextLine();
			int i = Integer.parseInt(str);
			int val;
			
			switch(i)
			{
			case 1:
				System.out.print("예금액> ");
				str = scanner.nextLine();
				val = Integer.parseInt(str);
				budget+=val;
				break;
			case 2:
				System.out.print("출금액> ");
				str = scanner.nextLine();
				val = Integer.parseInt(str);
				budget-=val;
				break;
			case 3:
				System.out.println("잔고"+budget);
				break;
			case 4:
				flag=false;
				break;
			}
		}
		System.out.println("프로그램 종료");

	}

}
