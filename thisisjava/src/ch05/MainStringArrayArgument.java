package ch05;

import java.util.Scanner;

public class MainStringArrayArgument {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("asdf");
			System.exit(0);
		}
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int res = num1 + num2;
		System.out.println(res);
		
		
		
		int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}			
		};
		
		int sum=0;
		int cnt=0;
		for (int i=0; i<array.length; ++i)
		{
			for (int k=0; k<array[i].length; ++k)
			{
				sum += array[i][k];
				++cnt;
			}
		}
		double avg = (double)sum / cnt;
		
		System.out.println(sum + ", " + avg);
		

		Scanner scanner = new Scanner(System.in);
		int[] arr= {};
		int n=0, max=0, k;
		double avge=0;
		do {
			System.out.println("1:학생수 2:점수입력 3:점수리스트 4:분석 5:종료");
			System.out.print("Input : ");
			
//			k=scanner.nextInt();
			k=Integer.parseInt(scanner.nextLine());
			switch (k)
			{
			case 1:
				System.out.print("student cnt:");
				n = Integer.parseInt(scanner.nextLine());
//				n = scanner.nextInt();
				arr = new int[n];
				break;
			case 2:
				int sum1=0;
				for (int i=0; i<n; ++i)
				{
					System.out.print("score"+i+":");
					int val=scanner.nextInt();
					arr[i]=val;
					sum1+=val;
					max=val>max?val:max;
				}
				avge=(double)sum1/n;
				break;
			case 3:
				for (int i=0; i<n && arr!=null; ++i)
				{
					System.out.println("score"+i+":"+arr[i]);
				}
				break;
			case 4:
				System.out.println("max"+max);
				System.out.println("avg"+avge);
				break;
			case 5:
				System.out.println("shut down.");
			}
			
		} while(k!=5);
		
		
		
		
		
	}

}
