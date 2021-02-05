package com.revature.ui;

import org.apache.log4j.Logger;

import com.revature.model.CustomerAccount;
import com.revature.service.CustomerService;

public class CreateAccountMenu implements MenuSystem {

	private static Logger log=Logger.getLogger(CreateAccountMenu.class);

	@Override
	public void display() {
		log.debug("heading to create account");		
		CustomerService accountCreation=new CustomerService();	
		accountCreation.accountCreation();
	}

	
}
