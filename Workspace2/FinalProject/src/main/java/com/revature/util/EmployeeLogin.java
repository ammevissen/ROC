package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAOImpl;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.ui.MenuSystem;

public class EmployeeLogin {

	public int attempts=3;
	private static Logger log=Logger.getLogger(EmployeeLogin.class);

	
	public static boolean login(int accountNumber, String password) { //int accountNumber, String password) {
		
		
		if (accountNumber<0 || password==null || password.equals("")) {
			return false;
		}
		

		EmployeeDAO DAO=new EmployeeDAOImpl();
		String dbPassword=null;
		
		//attempts to get the password		
		try {
			dbPassword = DAO.getPassword(accountNumber);
		} catch (DatabaseConnectionException e) {
			//if the account cannot be found, returns false
			log.info("account not found");
			return(false);
			//e.printStackTrace();
		}
	
		//compares the password entered with the password in the database
		if (dbPassword!=null && password.equals(dbPassword)) {
			log.debug("correct password");
			return(true);			
		}else{
			log.debug("incorrect password");
			return(false);
		}
		
	}
	
	public static int getAccountNumber() {
		int accountNumber;
		try {
			log.info("Please enter employee account number");
			accountNumber=Integer.parseInt(MenuSystem.sc.nextLine());
			log.debug(accountNumber);
		}catch (NumberFormatException e) {
			log.info("Please enter a valid account number");
			return(-1);
		}
		return accountNumber;
	}
	
	public static String getPassword() {
		log.info("Please enter employee password");  //move to be part of employee login method so not duplicated
		String password=MenuSystem.sc.nextLine();
		log.debug("password entered");
		return password;
	}
	
	
}
