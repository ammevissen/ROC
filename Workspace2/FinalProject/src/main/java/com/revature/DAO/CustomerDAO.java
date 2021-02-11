package com.revature.DAO;

import java.time.LocalDate;
import java.util.List;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.CustomerAccount;
import com.revature.model.CustomerTransaction;


public interface CustomerDAO {

	public int CreateCustomerAccount(String firstName, String lastName, String password, double initialChecking, double initialSaving, LocalDate dob) throws DatabaseConnectionException;
	public String getPassword(int accountNumber) throws DatabaseConnectionException;
	public List<CustomerAccount> getAccountInfo(String searchBy, String name) throws DatabaseConnectionException, AccountNotFoundException;
	public CustomerAccount getAccountInfo(String searchBy, int account) throws DatabaseConnectionException, AccountNotFoundException;
	public List<CustomerTransaction> getTransactionsInfo(int accountNum) throws DatabaseConnectionException;
	public int exchangeMoney(int accountNumber, int otherAccountNumber, double amount); 
}
