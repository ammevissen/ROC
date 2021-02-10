package com.revature.util;

public class ValidPassword {

	public static boolean isNotValidPassword(String password) {
		if (password==null|| password.length()<8) {
			return true;
		}else { 
			return false;
		}
	}
	
}
