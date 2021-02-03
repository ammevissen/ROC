package com.revature.ui;

import org.apache.log4j.Logger;

import com.revature.util.CustomerLogin;
import com.revature.util.EmployeeLogin;


public class CustomerMenu implements MenuSystem {

	private static Logger log=Logger.getLogger(MainMenu.class);

	
	@Override
	public void display() {
		int choice=0;
		log.info("Customer Menu");

		
		do {
			log.info("1.) Exit application");
			log.info("2.) Login as employee");
			log.info("3.) Login as customer");
			log.info("4.) Create customer account");
			choice=Integer.getInteger(MenuSystem.sc.nextLine());
			log.debug("user's choice was "+choice);
			switch(choice){
				case 1:
					log.info("Exiting Customer Menu");
					break;
				case 2:
					
					break;					
				case 3:
					break;
				case 4:
					break;
				default:
					log.info("Pease enter a value between 1 and 4");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Customer Menu");
		
	}

}
