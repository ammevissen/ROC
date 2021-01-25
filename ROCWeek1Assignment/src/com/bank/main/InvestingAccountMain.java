package com.bank.main;

import com.bank.*;
import java.util.ArrayList;

public class InvestingAccountMain {

	public void investingDriver(){
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

		InvestingAccount investingAccount1=new InvestingAccount("John", "Watson");
		InvestingAccount investingAccount2=new InvestingAccount("Sherlock", "Holmes");
		
		System.out.println(investingAccount1.getFirstName()+" "+investingAccount1.getLastName()+"'s investing account number is: "+investingAccount1.getAccountNumber());
		System.out.println(investingAccount2.getFirstName()+" "+investingAccount2.getLastName()+"'s investing account number is: "+investingAccount2.getAccountNumber());
		
		investingAccount1.addTransaction(1, 10, 191.94, "CAT");
		investingAccount1.addTransaction(1, 10, 0.36, "GRR");
		
		investingAccount1.addTransaction(2, 10, 47.39, "LUV");
		investingAccount1.addTransaction(2, 10, 63.01, "EAT");
		investingAccount1.addTransaction(2, 10, 98.82, "PZZA");
		
		investingAccount1.addTransaction(3, 10, 38.61, "DOG");
		investingAccount1.addTransaction(3, 10, 26.07, "WOOF");		

		investingAccount1.addTransaction(4, 10, 41.05, "CAR");
		investingAccount1.addTransaction(4, 10, 96.39, "ROCK");
		investingAccount1.addTransaction(4, 10, 50.91, "BOOM");
		
		investingAccount1.addTransaction(5, 10, 26.47, "BEN");
		investingAccount1.addTransaction(5, 10, 92.96, "OMG");
		
		investingAccount1.addTransaction(6, 10, 25.48, "FAN");
		investingAccount1.addTransaction(6, 10, 34.00, "PLAY");
		
		investingAccount1.addTransaction(7, 10, 85.77, "CURE");
		investingAccount1.addTransaction(7, 10, 42.36, "CAKE");
		
		
		
		investingAccount2.addTransaction(1, 10, 2874.5, "FB");
		investingAccount2.addTransaction(1, 100, 139.07, "AAPL");
		investingAccount2.addTransaction(1, 10, 3292.23, "AMZN");
		investingAccount2.addTransaction(1, 20, 565.17, "NFLX");
		investingAccount2.addTransaction(1, 10, 1892.56, "GOOGL");
		
		investingAccount1.printBalance();
		investingAccount2.printBalance();
		
		
		ArrayList<StockTransactions> transactions=investingAccount1.getTransactions();
		System.out.println("Some of the stocks that Watson owns");
		for(int i=0; i<transactions.size(); i++){
			if (transactions.get(i).getDate()==1 || transactions.get(i).getDate()==3) {
			System.out.println(transactions.get(i).getStockName());
			}
		}	
	}

}