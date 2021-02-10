package com.revature.util;

public class ValidCurrency {

	public static boolean isNotValidCurrency(double value) {
		if ((value*100)%1!=0.0 || value<0) {
			return true;
		}else { 
			return false;
		}
	}
	
}
