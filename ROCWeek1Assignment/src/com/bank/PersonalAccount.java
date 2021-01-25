package com.bank;

import java.util.ArrayList;

public class PersonalAccount extends Account{

	protected ArrayList<PersonalTransactions> transactions=new ArrayList<PersonalTransactions>();

	public PersonalAccount(String firstName, String lastName, long accountNumber) {
		super(firstName, lastName, accountNumber);	
	}
	
	public void updateBalance() {
		double balance=0;
		for (PersonalTransactions transaction: transactions) {
			balance+=transaction.getAmount();
		}
		super.setBalance(balance);
	}
	
	public void addTransaction(int date, double amount){
		transactions.add(new PersonalTransactions(date, amount));
	}
	
	public void addTransaction(int date, double amount, String location) {
		transactions.add(new PersonalTransactions(date, amount, location));
	}
		
	public void addTransaction(int date, double amount, String location, String description) {
		transactions.add(new PersonalTransactions(date, amount, location, description));
	}
	
	public ArrayList<PersonalTransactions> getTransactions() {
		return(this.transactions);
	}
	
	
}
