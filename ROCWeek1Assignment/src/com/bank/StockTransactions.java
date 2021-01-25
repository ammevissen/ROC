package com.bank;

public class StockTransactions extends Transactions{

	private int quantity;
	private double stockValue;//value of stock at time of purchase/sale
	private String stockName;
		
	public StockTransactions(int date, int quantity, double stockValue, String stockName) {
		super(date);
		this.quantity=quantity;
		this.stockValue=stockValue;
		this.stockName=stockName;
	}

	public int getQuantity(){
		return(this.quantity);
	}
	
	public double getStockValue() {
		return(this.stockValue);
	}
	
	public String getStockName() {
		return(this.stockName);
	}

	
}
