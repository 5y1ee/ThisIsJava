package ch06.question.no20;

public class Account {
	
	private String accountNumber;
	private String accountName;
	private int accountBudget;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountBudget() {
		return accountBudget;
	}
	public void setAccountBudget(int accountBudget) {
		this.accountBudget = accountBudget;
	}

	public Account(String accountNumber, String accountName, int accountBudget) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountBudget = accountBudget;
	}
	
	public void display() {
		System.out.println(this.accountNumber + "\t" + this.accountName + "\t" + this.accountBudget);
	}
	
	public boolean withdraw(int amount) {
		if (this.accountBudget > amount)
		{
			this.accountBudget -= amount;
			return true;
		}
		else
		{
			System.out.println("Not Enough Budget.");
			return false;
		}
	}
	
	public boolean deposit(int amount) {
		if (amount < 0)
		{
			System.out.println("Invalid Value.");
			return false;
		}
		else
		{
			this.accountBudget += amount;
			return true;
		}
	}
	
	
	
}
