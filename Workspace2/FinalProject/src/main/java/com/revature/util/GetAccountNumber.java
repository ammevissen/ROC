package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.ui.MenuSystem;

public class GetAccountNumber {

	private static Logger log=Logger.getLogger(GetAccountNumber.class);

	
	public static int getAccountNumber(String message) {
		//asks the user for an account number
		log.info(message);
		int accountNumber;
		
		//gets the account number from the user and verifies that it is a valid account number.
		//returns the account number if it is valid, and returns -1 if it is not a valid account number.
		try {
			accountNumber=Integer.parseInt(MenuSystem.sc.nextLine());
			log.debug(accountNumber);
			
			if (ValidAccount.isNotValidAccount(accountNumber)) {
				log.info("Please enter a valid account number");
				return(-1);
			}
		}catch (NumberFormatException e) {
			log.info("Please enter a valid account number");
			return(-1);
		}
		return accountNumber;
		
	}
	
	
}
