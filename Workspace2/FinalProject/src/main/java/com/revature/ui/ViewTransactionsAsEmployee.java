package com.revature.ui;

import org.apache.log4j.Logger;


public class ViewTransactionsAsEmployee implements MenuSystem {

	private static Logger log=Logger.getLogger(MainMenu.class);

	
	@Override
	public void display() {
		int choice=0;
		log.info("Employee View Transactions Menu");

		do {
			log.info("1.) Exit Employee View Transactions Menu");
			log.info("2.) View by Account Number");
			log.info("3.) View by Checking Account Number");
			log.info("4.) View by Savings Account Number");

			choice=Integer.getInteger(MenuSystem.sc.nextLine());
			log.debug("user's choice was "+choice);
			switch(choice){
				case 1:
					log.info("Exiting Employee View Transactions Menu");
					break;
				case 2:
					log.debug("Entering View by Account Number");
					break;					
				case 3:
					log.debug("Entering View by Checking Account Number");
					break;
				case 4:
					log.debug("Entering View by Savings Account Number");
					break;
				default:
					log.info("Pease enter a value between 1 and 4");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting View Transactions as Employee Menu");		
	}
	
	@Override
	public void displaySecure(int accountNumber) {
		display();
	}

}
