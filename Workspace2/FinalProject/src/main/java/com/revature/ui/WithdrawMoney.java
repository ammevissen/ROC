package com.revature.ui;

import org.apache.log4j.Logger;


public class WithdrawMoney implements MenuSystem{

	private static Logger log=Logger.getLogger(MainMenu.class);
	
	@Override
	public void display() {
		log.debug("In Withdraw Menu without Account Number");
		log.info("Exiting Customer Menu");
	}

	@Override
	public void displaySecure(int accountNumber) {
		int choice=0;
		log.info("Withdraw Menu");

		
		do {
			log.info("1.) Exit Withdraw Menu");
			log.info("2.) Withdraw Cash or Check");
			log.info("3.) Withdraw from another Account");

			choice=Integer.getInteger(MenuSystem.sc.nextLine());
			log.debug("user's choice was "+choice);
			switch(choice){
				case 1:
					log.info("Exiting Withdraw Menu");
					break;
				case 2:
					log.debug("Withdraw Cash or Check");
					break;					
				case 3:
					log.debug("Withdraw from another Account");
					break;

				default:
					log.info("Pease enter a value between 1 and 3");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Withdraw Menu");

		
	}

}
