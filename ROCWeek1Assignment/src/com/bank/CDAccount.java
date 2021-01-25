package com.bank;

public class CDAccount extends Account{

	private final int initialBalance;
	private final int numOfDays;
	private final double intrestRate;

	public CDAccount(String firstName, String lastName, int initialBalance, int numOfDays, double intrestRate) {
		super(firstName, lastName, setAccountNumber(firstName+lastName+"CDA"));	
		this.initialBalance=initialBalance;
		this.numOfDays=numOfDays;
		this.intrestRate=intrestRate;
		updateBalance();		
	}
	
	public void updateBalance() {
		this.setBalance(this.initialBalance*(1.0+this.intrestRate*this.numOfDays/365));
	}
	
	@Override
	public void printBalance() {
		System.out.println("the value of "+super.getLastName()+"'s CD when it matures will be: "+super.getBalance());
	}
	
}
