package com.bank;

import java.util.ArrayList;

public class InvestingAccount  extends Account{

	protected ArrayList<StockTransactions> transactions=new ArrayList<StockTransactions>();
	
	
	public InvestingAccount(String firstName, String lastName) {
		super(firstName, lastName, setAccountNumber(firstName+lastName+"IA"));	
	}
	
	public void updateBalance() {
		double balance=0;
		for (StockTransactions transaction: transactions) {
			balance+=transaction.getQuantity()*transaction.getStockValue();
		}
		super.setBalance(balance);
	}
	
	public void addTransaction(int date, int quantity, double stockValue, String stockName){
		transactions.add(new StockTransactions(date, quantity, stockValue, stockName));
	}
		
	public ArrayList<StockTransactions> getTransactions() {
		return(this.transactions);
	}
	
	@Override
	public void printBalance() {
		updateBalance();
		System.out.println("the current balance in "+super.getLastName()+"'s stock account is: "+super.getBalance());
	}
	
}
