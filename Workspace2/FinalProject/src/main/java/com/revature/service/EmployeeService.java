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
		CustomerDAO DAO=new CustomerDAOImpl();
		List<CustomerAccount> result=new ArrayList<>();
		
		try {
			result = DAO.getAccountInfo(searchBy, name);
		} catch (DatabaseConnectionException | AccountNotFoundException e) {
			e.printStackTrace();
		}
		if (result.size()>0) {
			for (CustomerAccount account: result) {
				log.info(account);
			}	
		} else {
			log.info("no accounts found with "+searchBy+" "+name);
		}
		
	}

	public static void customer(String searchBy, int account) {
		CustomerDAO DAO=new CustomerDAOImpl();
		CustomerAccount result=null;
		
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
		if (result!=null) {
			log.info(result);
		}
	}
	
	public static void allAccountTransactions(int accountNumber) {
		EmployeeService.transactions(accountNumber*10+1);
		EmployeeService.transactions(accountNumber*10+2);
	}
	
	public static void transactions(int accountNumber) {
		CustomerDAO DAO=new CustomerDAOImpl();
		List<CustomerTransaction> result=new ArrayList<>();
		
		try {
			result = DAO.getTransactionsInfo(accountNumber);
		} catch (DatabaseConnectionException e) {
			e.printStackTrace();
		}
		if (result.size()>0) {
			for (CustomerTransaction account: result) {
				log.info(account);
			}	
		} else {
			if (accountNumber%10==1) {
				log.info("no checking accounts found with "+accountNumber);
			}else if (accountNumber%10==2){
				log.info("no savings accounts found with "+accountNumber);
				
			}
		}
		
	}	
}
