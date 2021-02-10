package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.ui.MenuSystem;

public class GetCurrencyNumber {

	private static Logger log=Logger.getLogger(GetCurrencyNumber.class);

	
	public static double getCurrencyValue(String message) {
		log.info(message);
		double currency=-1;
		try {
			log.info("Please enter your initial checking acount deposit (enter 0 for none): ");
			currency=Double.parseDouble(MenuSystem.sc.nextLine());
			log.debug("value: "+currency);
		
		}catch (NumberFormatException e) {
			log.info("Please enter a number in the form of 0.00 for initial checking and savings account values");
			log.info("Your account was not succesfully created please try again");
			return(-1);
		}
		return(currency);
	}
	
}
