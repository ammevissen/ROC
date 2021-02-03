package com.revature.ui;

import org.apache.log4j.Logger;

import com.revature.util.CustomerLogin;
import com.revature.util.EmployeeLogin;


public class CustomerMenu implements MenuSystem {

	private static Logger log=Logger.getLogger(MainMenu.class);

	@Override
	public void display() {
		log.debug("In Customer Menu without Account Number");
		log.info("Exiting Customer Menu");
		
	}
	
	public void displaySecure(int accountNumber) {
		int choice=0;
		log.info("Customer Menu");

		
		do {
			log.info("1.) Exit Customer Menu");
			log.info("2.) View checking account balance");
			log.info("3.) View savings account balance");
			log.info("4.) Deposit Money");
			log.info("5.) Withdraw Money");
			log.info("6.) View checking account transactions");
			log.info("7.) View savings account transactions");

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
