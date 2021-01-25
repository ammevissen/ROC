package com.bank.main;

import com.bank.*;
import java.util.ArrayList;

public class SavingsCheckingAccountMain {

	public void scDriver(){
	//public static void main(String[] args) {
		//SavingsAccount(String firstName, String lastName)
		SavingsAccount savingsAccount1=new SavingsAccount("Irene", "Adler", 0.01);
		CheckingAccount checkingAccount1=new CheckingAccount("Irene", "Adler");
		System.out.println(savingsAccount1.getFirstName()+" "+savingsAccount1.getLastName()+"'s savings account number is: "+savingsAccount1.getAccountNumber());
		System.out.println(checkingAccount1.getFirstName()+" "+checkingAccount1.getLastName()+"'s checking account number is: "+checkingAccount1.getAccountNumber());
		
		
		savingsAccount1.addTransaction(1, 500, "Irene Adler", "Initial Deposit");
		savingsAccount1.addTransaction(1, -150, "Baker", "Bread");
		savingsAccount1.addTransaction(8, -50, "Farmer's Market", "Fruit and Vegtables");
		savingsAccount1.addTransaction(15, -75);
		savingsAccount1.addTransaction(22, -25, "Blacksmith");
		savingsAccount1.addTransaction(29, 1000, "King of Bohemia", "Money from the King");
		savingsAccount1.addTransaction(30, -25, "Train Depot", "Train Tickets");//can not make withdraw due to to many transactions this month

		System.out.println("End of month balance");
		savingsAccount1.printBalance();	
		savingsAccount1.endOfMonth();
		System.out.println("New Month");
		System.out.println("Start of month balance");
		savingsAccount1.printBalance();		

		System.out.println("adding transaction that couldn't be added last month");
		savingsAccount1.addTransaction(31, -1000, "Transfer to Checking Account");			
		savingsAccount1.printBalance();		


		checkingAccount1.addTransaction(31, 1000, "Irene Adler", "Initial Deposit");		
		checkingAccount1.addTransaction(31, -150, "Home Depot", "Tools");
		checkingAccount1.addTransaction(38, -50, "Home Depot", "Dry Wall");
		checkingAccount1.addTransaction(45, -75, "Home Depot", "Paint");
		checkingAccount1.addTransaction(52, -25, "Home Depot", "Wallpaper");
		savingsAccount1.addTransaction(60, -25, "Train Depot", "Train Tickets");//Need to wait for the next month to make the transaction
		savingsAccount1.printBalance();		
		checkingAccount1.printBalance();		

		SavingsAccount.setInterestRate(0.02);
		
		System.out.println("New Month and change in interest rate");
		savingsAccount1.endOfMonth();
		savingsAccount1.printBalance();		
		
		
		System.out.println("Irene Adler changed her name to Irene Norton");
		savingsAccount1.setLastName("Norton");
		checkingAccount1.setLastName("Norton");
				
		System.out.println(savingsAccount1.getFirstName()+" "+savingsAccount1.getLastName()+"'s account number is: "+savingsAccount1.getAccountNumber());
		System.out.println(checkingAccount1.getFirstName()+" "+checkingAccount1.getLastName()+"'s account number is: "+checkingAccount1.getAccountNumber());
		
		ArrayList<PersonalTransactions> transactions=checkingAccount1.getTransactions();
		for (int i=0; i<transactions.size(); i++) {
			if (transactions.get(i).getLocation().equals("Home Depot")){
				System.out.println("on the "+transactions.get(i).getDate()%30+"th day of the month");
				System.out.println("I bought: "+transactions.get(i).getDescription());
			}
		}
		
	}

}
