package ch06.question.no20;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		
		Account[] accountAry = new Account[100];
		Scanner scanner = new Scanner(System.in);
		
		String input = "";
		
		int accountCount = 0;
		
		do {
			switch (input)
			{
			case "1":
				System.out.println("계좌생성");
				System.out.print("계좌번호 : ");
				String number = scanner.nextLine();
				System.out.print("계좌주 : ");
				String name = scanner.nextLine();
				System.out.print("초기입금액 : ");
				int budget = Integer.parseInt(scanner.nextLine());
				
				var account = new Account(number, name, budget);
				accountAry[accountCount] = account;
				++accountCount;
				break;
				
			case "2":
				for (int i=0; i<accountCount; ++i)
				{
					accountAry[i].display();
				}
				break;
				
			case "3":
				break;
				
			case "4":
				break;
				
			}
			
			input = scanner.nextLine();
		}
		while (input != "5");
		
	}

}
