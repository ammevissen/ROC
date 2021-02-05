package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.ui.MainMenu;
import com.revature.ui.MenuSystem;

public class EmployeeLogin {

	public int attempts=3;
	private static Logger log=Logger.getLogger(EmployeeLogin.class);

	
	public boolean login() {  //int accountNumber, String password) {
		
		log.info("Please enter employee account number");
		int accountNumber=Integer.parseInt(MenuSystem.sc.nextLine());
		log.debug(accountNumber);
		
		log.info("Please enter employee password");  //move to be part of employee login method so not duplicated
		String password=MenuSystem.sc.nextLine();
		log.debug("password entered");
		
		CustomerDAO DAO=new CustomerDAOImpl();
		String dbPassword=null;
		
		try {
			dbPassword = DAO.getPassword(accountNumber);
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		if (dbPassword!=null && password.equals(dbPassword)) {
			log.debug("correct password");
			return(true);			
		}else{
			log.debug("incorrect password");
			return(false);
		}
		
	}
	
}
