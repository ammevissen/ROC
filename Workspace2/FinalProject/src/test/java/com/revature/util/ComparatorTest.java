package com.revature.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.model.CustomerTransaction;

class ComparatorTest {

	
	/*
	private int accountID;
	private double amount;
	private String trasancitonType;
	private int trasanciontPartner;
	private LocalTime timeCreated;
	private LocalDate dateCreated;
	 *
	 */
	
	public static List<CustomerTransaction> transactions=new ArrayList<>();

	
	@BeforeAll
	public static void setUpMyService() {
		
		int accountNumber=100;
		
		LocalDate date=LocalDate.parse("2010-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime time=LocalTime.parse("10:10:10", DateTimeFormatter.ofPattern("HH:mm:ss"));
		transactions.add(new CustomerTransaction(accountNumber, 100.00, "Deposit", 200, time, date));

		date=LocalDate.parse("2020-12-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("20:20:20", DateTimeFormatter.ofPattern("HH:mm:ss"));
		transactions.add(new CustomerTransaction(accountNumber, 20.00, "Withdraw", 300, time, date));

		date=LocalDate.parse("2005-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("21:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
		transactions.add(new CustomerTransaction(accountNumber, 30.00, "Withdraw", 250, time, date));
		
	}
	
	@Test
	void testSortByAmmount() {
		//compareAmount
		List<CustomerTransaction> resultTransactions=new ArrayList<>();
		int accountNumber=100;

		LocalDate date=LocalDate.parse("2020-12-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime time=LocalTime.parse("20:20:20", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 20.00, "Withdraw", 300, time, date));

		
		date=LocalDate.parse("2005-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("21:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 30.00, "Withdraw", 250, time, date));

		
		date=LocalDate.parse("2010-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("10:10:10", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 100.00, "Deposit", 200, time, date));
		
		assertTrue(Comparator.compareAmount(transactions).equals(resultTransactions));	
	}

	
	@Test
	void testSortByTime() {
		//compareAmount
		List<CustomerTransaction> resultTransactions=new ArrayList<>();
		int accountNumber=100;

		LocalDate date=LocalDate.parse("2010-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime time=LocalTime.parse("10:10:10", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 100.00, "Deposit", 200, time, date));
		
		 date=LocalDate.parse("2020-12-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("20:20:20", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 20.00, "Withdraw", 300, time, date));

		
		date=LocalDate.parse("2005-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("21:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 30.00, "Withdraw", 250, time, date));

		assertTrue(Comparator.compareTime(transactions).equals(resultTransactions));	
	}

	@Test
	void testSortByDate() {
		//compareAmount
		List<CustomerTransaction> resultTransactions=new ArrayList<>();
		int accountNumber=100;

		LocalDate date=LocalDate.parse("2005-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime time=LocalTime.parse("21:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 30.00, "Withdraw", 250, time, date));
		
		date=LocalDate.parse("2010-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("10:10:10", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 100.00, "Deposit", 200, time, date));
		
		date=LocalDate.parse("2020-12-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("20:20:20", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 20.00, "Withdraw", 300, time, date));


		assertTrue(Comparator.compareDate(transactions).equals(resultTransactions));	
	}
	
	
	@Test
	void testSortByTrasanciontPartner() {
		//compareAmount
		List<CustomerTransaction> resultTransactions=new ArrayList<>();
		int accountNumber=100;
		
		LocalDate date=LocalDate.parse("2010-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime time=LocalTime.parse("10:10:10", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 100.00, "Deposit", 200, time, date));

		date=LocalDate.parse("2005-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("21:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 30.00, "Withdraw", 250, time, date));
				
		date=LocalDate.parse("2020-12-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("20:20:20", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 20.00, "Withdraw", 300, time, date));


		assertTrue(Comparator.compareTrasanciontPartner(transactions).equals(resultTransactions));	
	}
	
	
	@Test
	void testIncorrectOrder() {
		//compareAmount
		List<CustomerTransaction> resultTransactions=new ArrayList<>();
		int accountNumber=100;
		
		LocalDate date=LocalDate.parse("2010-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime time=LocalTime.parse("10:10:10", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 100.00, "Deposit", 200, time, date));

		date=LocalDate.parse("2005-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("21:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 30.00, "Withdraw", 250, time, date));
				
		date=LocalDate.parse("2020-12-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		time=LocalTime.parse("20:20:20", DateTimeFormatter.ofPattern("HH:mm:ss"));
		resultTransactions.add(new CustomerTransaction(accountNumber, 20.00, "Withdraw", 300, time, date));

		assertFalse(Comparator.compareDate(transactions).equals(resultTransactions));	
	}
}
