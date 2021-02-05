package com.revature.DAO;

import java.util.List;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
//import org.apache.log4j.Logger;
import com.revature.model.CustomerAccount;
import com.revature.model.CustomerTransaction;
import com.revature.model.CustomerTransactions;


public interface CustomerDAO {

	//private static Logger log=Logger.getLogger(CustomerDAO.class);

	public int CreateCustomerAccount(String firstName, String lastName, String password, double initialChecking, double initialSaving) throws DatabaseConnectionException;
	
	public String getPassword(int accountNumber) throws DatabaseConnectionException;
	
	public List<CustomerAccount> getAccountInfo(String searchBy, String name) throws DatabaseConnectionException, AccountNotFoundException;
	public CustomerAccount getAccountInfo(String searchBy, int account) throws DatabaseConnectionException, AccountNotFoundException;
	public List<CustomerTransaction> getTransactionsInfo(int accountNum) throws DatabaseConnectionException;
}
