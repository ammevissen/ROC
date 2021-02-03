package com.revature.ui;

import java.util.Scanner;
//import org.apache.log4j.Logger;

import com.revature.main.Application;


public interface MenuSystem {


//	private static Logger log=Logger.getLogger(MenuSystem.class);
	public static Scanner sc=new Scanner(System.in);

	
	public void display(); 
	
	public void displaySecure(int accountNumber);
	
}
