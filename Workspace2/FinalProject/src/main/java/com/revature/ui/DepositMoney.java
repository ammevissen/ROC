package com.revature.ui;

import org.apache.log4j.Logger;


public class DepositMoney implements MenuSystem{

	private static Logger log=Logger.getLogger(MainMenu.class);

	
	@Override
	public void display() {
		log.debug("In Deposit Menu without Account Number");
		log.info("Exiting Customer Menu");		
	}

	@Override
	public void displaySecure(int accountNumber) {
		int choice=0;
		log.info("Deposit Menu");

		
		do {
			log.info("1.) Exit Deposit Menu");
			log.info("2.) Deposit Cash or Check");
			log.info("3.) Deposit from another Account");

			choice=Integer.getInteger(MenuSystem.sc.nextLine());
			log.debug("user's choice was "+choice);
			switch(choice){
				case 1:
					log.info("Exiting Deposit Menu");
					break;
				case 2:
					log.debug("Deposit Cash or Check");
					break;					
				case 3:
					log.debug("Deposit from another Account");
					break;

				default:
					log.info("Pease enter a value between 1 and 3");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Deposit Menu");

		
	}

}
