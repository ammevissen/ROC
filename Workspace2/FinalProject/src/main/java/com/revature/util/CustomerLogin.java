package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.DatabaseConnectionException;


public class CustomerLogin {

	private static Logger log=Logger.getLogger(CustomerLogin.class);

	public static boolean login(int accountNumber, String password) {
		
		
		CustomerDAO DAO=new CustomerDAOImpl();
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
}
