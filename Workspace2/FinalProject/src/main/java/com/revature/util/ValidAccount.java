package com.revature.util;

public class ValidAccount {

	
	public static boolean isNotValidAccount(int accountNumber) {
		//checks that the account number is a valid account number
		if (accountNumber<=0) {
			
			return true;
		}else { 
			return false;
		}
	}
}
