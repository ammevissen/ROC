package com.revature.util;

public class ValidAccount {

	
	public static boolean isNotValidAccount(int value) {
		if (value<0) {
			return true;
		}else { 
			return false;
		}
	}
}
