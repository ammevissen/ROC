package com.revature.ui;

import org.apache.log4j.Logger;

public class CreateAccountMenu implements MenuSystem {

	private static Logger log=Logger.getLogger(MainMenu.class);

	@Override
	public void display() {
		log.debug("heading to create account");
		System.out.println("In account creation");
		
	}

	@Override
	public void displaySecure(int accountNumber) {
		display();
	}
	
}
