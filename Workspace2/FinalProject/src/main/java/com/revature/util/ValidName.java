package com.revature.util;

public class ValidName {

	public static boolean isNotValidPassword(String name) {
	if (name==null|| name.length()<1) {
		return true;
	}else { 
		return false;
		}
	}
}
