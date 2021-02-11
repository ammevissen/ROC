package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.CustomerAccount;
import com.revature.model.CustomerTransaction;


public class EmployeeService {

	private static Logger log=Logger.getLogger(EmployeeService.class);
	
	public static void customer(String searchBy, String name) {
		//Search for customer by first or last name
		
		CustomerDAO DAO=new CustomerDAOImpl();
		List<CustomerAccount> result=new ArrayList<>();
		
		//Call the DAO layer to get the customer account(s) that have the given first or last name
		try {
			result = DAO.getAccountInfo(searchBy, name);
		} catch (DatabaseConnectionException | AccountNotFoundException e) {
			
			//e.printStackTrace();
		}
		
		//Print customer account(s) info
		if (result.size()>0) {
			for (CustomerAccount account: result) {
				log.info(account);
			}	
		} else {
			log.info("no accounts found with "+searchBy+" "+name);
		}
		
	}

	public static void customer(String searchBy, int account) {
		//Get customer account by account number, checking account number or savings account number
		
		CustomerDAO DAO=new CustomerDAOImpl();
		CustomerAccount result=null;

		//Call the DAO layer to get the customer account(s) that have the given account number, checking account number or savings account number
		try {
			result = DAO.getAccountInfo(searchBy, account);
		} catch (DatabaseConnectionException e){
			e.printStackTrace();
		}catch(AccountNotFoundException e){
			String searchBySpace="account Number";
			switch (searchBy) {
			case "checkingID":
				searchBySpace="checking account number";
				break;
			case "savnigsID":
				searchBySpace="saving account number";
				break;
			}
			log.info("no accounts found with "+searchBySpace+" "+account);
		}

		//Print customer account info
		if (result!=null) {
			log.info(result);
		}
	}
	
	public static List<CustomerTransaction> allAccountTransactions(int accountNumber) {
		//Get customer transactions for both checking and savings accounts
		List<CustomerTransaction> results=new ArrayList<>();
		
		List<CustomerTransaction> temp1=EmployeeService.transactions(accountNumber*10+1);
		List<CustomerTransaction> temp2=EmployeeService.transactions(accountNumber*10+2);
		
		if (temp1!=null) {
			for (CustomerTransaction transaction: temp1) {
				results.add(transaction);
			}
		}
		
		if (temp2!=null) {
			for (CustomerTransaction transaction: temp2) {
				results.add(transaction);
			}
		}
		
		return results;
	}
	
	public static List<CustomerTransaction> transactions(int accountNumber) {
		//Get customer transactions for either checking or savings account
		CustomerDAO DAO=new CustomerDAOImpl();
		List<CustomerTransaction> result=new ArrayList<>();

		//Call the DAO layer to get the customer transactions for the given account		
		try {
			result = DAO.getTransactionsInfo(accountNumber);
		} catch (DatabaseConnectionException e) {
			log.info("no account found with account "+accountNumber);			
			//e.printStackTrace();
		}
		if (result.size()>0) {
			//now handled by transaction class
//			for (CustomerTransaction account: result) {
//				log.info(account);
//			}	
		} else {
			if (accountNumber%10==1) {
				log.info("no checking accounts found with "+accountNumber);
			}else if (accountNumber%10==2){
				log.info("no savings accounts found with "+accountNumber);
			return null;
			}
		}	
		return result;
	}	
}
