package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.ui.MenuSystem;

public class GetAccountNumber {

	private static Logger log=Logger.getLogger(GetAccountNumber.class);

	
	public static int getAccountNumber(String message) {
		log.info(message);
		int accountNumber;
		try {
			log.info("Please enter employee account number");
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
