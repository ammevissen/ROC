package com.bank;

import java.util.ArrayList;

abstract public class Account {
	//Customer info
	private String firstName;
	private String lastName;
	private final long accountNumber;
	
	private double balance=0;
	private ArrayList<Transactions> transactions=new ArrayList<Transactions>();
	
	//Bank Info
	private static final int bankID=12345;
	private static final String bankName="ROC Bank";
		
	
	public Account(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = setAccountNumber(firstName+lastName);
	}
	
	
	public Account(String firstName, String lastName, long accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber=accountNumber;
	}
	
	public static long setAccountNumber(String name) {
		long result=0;
		for (int i=0; i<name.length(); i++) {
			char temp=name.charAt(i);
			result+=(long)((((int)temp)%26)*Math.pow(10,(i)));
		}
		return result;
	}
	
	abstract public void updateBalance();
	
	public void printBalance() {
		System.out.println("the current balance in this account is: "+balance);
	}

	protected void setBalance(double balance) {
		this.balance=balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public long getAccountNumber() {
		return accountNumber;
	}

	public static int getBankid() {
		return bankID;
	}

	public static String getBankname() {
		return bankName;
	}
		
}
