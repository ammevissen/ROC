package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.DatabaseConnectionException;


public class CustomerLogin {

	//public int attempts=3;
	private static Logger log=Logger.getLogger(CustomerLogin.class);

	public static boolean login(int accountNumber, String password) {
		
		
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
