package com.revature.main;

import org.apache.log4j.Logger;

import com.revature.ui.MainMenu;
import com.revature.ui.MenuSystem;

public class Application {

	private static Logger log=Logger.getLogger(Application.class);

	
	public static void main(String[] args) {
		log.info("Welcome to the bank");
		
		MenuSystem mainMenu=new MainMenu();
		mainMenu.display();
		
		MenuSystem.sc.close();
		log.info("Goodbye!");
		
	}

}
