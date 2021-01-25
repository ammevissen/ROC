package com.bank;

public class SavingsAccount extends PersonalAccount{

	private static double interestRate;//interest rate is the same across all accounts
	private int numberOfTransactions; //resets each month
	
	//can not add more than 6 transactions per month
	public SavingsAccount(String firstName, String lastName) {
		super(firstName, lastName, setAccountNumber(firstName+lastName+"SA"));	
	}
	
	public SavingsAccount(String firstName, String lastName, double interestRate) {
		this(firstName, lastName);
		this.interestRate=interestRate;
	}
	
	public static double getInterestRate() {
		return interestRate;
	}
	
	public static void setInterestRate(double interestRate) {
		SavingsAccount.interestRate = interestRate;
	}
	
	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}
	
	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}
	
	@Override
	public void addTransaction(int date, double amount){
		if (numberOfTransactions>5) {
			System.out.println("Too many transactions this month");
		}else {
		numberOfTransactions+=1;
		transactions.add(new PersonalTransactions(date, amount));
		}
	}
	
	@Override
	public void addTransaction(int date, double amount, String location) {
		if (numberOfTransactions>5) {
			System.out.println("Too many transactions this month");
		}else {
		numberOfTransactions+=1;
		transactions.add(new PersonalTransactions(date, amount, location));
		}
	}
		
	@Override
	public void addTransaction(int date, double amount, String location, String description) {
		if (numberOfTransactions>5) {
			System.out.println("Too many transactions this month");
		}else {
		numberOfTransactions+=1;
		transactions.add(new PersonalTransactions(date, amount, location, description));
		}
	}

	@Override
	public void printBalance() {
		updateBalance();
		System.out.println("the current balance in "+super.getLastName()+"'s savings account is: "+super.getBalance());
	}

	
	public void endOfMonth() {
		numberOfTransactions=-1;
		this.updateBalance();
		//a getDate funtion would be called instead of 1 in real scenario
		this.addTransaction(1, this.interestRate*this.getBalance(), super.getBankname(), "Inerest");
	}
}
