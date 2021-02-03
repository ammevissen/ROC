package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.ui.MainMenu;

public class EmployeeLogin {

	public int attempts=3;
	private static Logger log=Logger.getLogger(EmployeeLogin.class);

	
	public boolean login(int accountNumber, String password) {
		
		//get password from database
//		String dbPassword;
//		//dpPassword=
//		
//		if (password.equals(dbPassword)) {
//			log.debug("correct password");
//			return(true);			
//		}else{
//			log.debug("incorrect password");
//			return(false);
//		}
		return(true);
	}
	
}
