package com.revature.util;

public class ValidName {

	public static boolean isNotValidPassword(String name) {
	//checks that the name is a valid name
	if (name==null|| name.length()<1) {
		return true;
	}else { 
		return false;
		}
	}
}
