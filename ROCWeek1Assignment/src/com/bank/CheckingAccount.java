package com.bank;

public class CheckingAccount extends PersonalAccount{

	private static final int bankRoutingNumber=6789;
	
	public CheckingAccount(String firstName, String lastName) {
		super(firstName, lastName, setAccountNumber(firstName+lastName+"CA"));	
	}
	
	public int getBankRoutingNumber() {
		return this.bankRoutingNumber;
	}
	
	@Override
	public void printBalance() {
		updateBalance();
		System.out.println("the current balance in "+super.getLastName()+"'s checking account is: "+super.getBalance());
	}

	
}
