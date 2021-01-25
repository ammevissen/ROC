package com.bank;

public class PersonalTransactions extends Transactions{

	private double amount;
	private String location;
	private String description;

	
	public PersonalTransactions(int date, double amount) {
		this(date, amount, "", "");
	}
	
	public PersonalTransactions(int date, double amount, String location) {
		this(date, amount, location, "");
	}
		
	public PersonalTransactions(int date, double amount, String location, String description) {
		super(date);
		this.amount=amount;
		this.location=location;
		this.description=description;
	}
	
	public double getAmount() {
		return(this.amount);
	}
	
	public String getLocation() {
		return(this.location);
	}
	
	public String getDescription() {
		return(this.description);
	}
	
	
	
}
