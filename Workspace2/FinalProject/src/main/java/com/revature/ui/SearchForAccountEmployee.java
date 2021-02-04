package com.revature.ui;

import org.apache.log4j.Logger;


public class SearchForAccountEmployee implements MenuSystem{

	private static Logger log=Logger.getLogger(MainMenu.class);

	
	@Override
	public void display() {
		int choice=0;
		log.info("Search for Account as Employee Menu");

		do {
			log.info("1.) Exit Employee Search for Account Menu");
			log.info("2.) Search for account by first name");
			log.info("3.) Search for account by last name");
			log.info("4.) Search for account by account number");
			log.info("5.) Search for account by checking account number");
			log.info("6.) Search for account by savings account number");

			choice=Integer.parseInt(MenuSystem.sc.nextLine());
			log.debug("user's choice was "+choice);
			switch(choice){
				case 1:
					log.info("Exiting Employee Search for Account Menu");
					break;
				case 2:
					System.out.println("2");
					log.debug("Entering Search for Account by First Name");
					break;					
				case 3:
					System.out.println("3");
					log.debug("Entering Search for Account by Last Name");
					break;
				case 4:
					System.out.println("4");
					log.debug("Entering Search for Account Number");
					break;
				case 5:
					System.out.println("5");
					log.debug("Entering Search for Checking Account Number");
					break;
				case 6:
					System.out.println("6");
					log.debug("Entering Search for Savings Account Number");
					break;

				default:
					log.info("Pease enter a value between 1 and 6");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Search for Account as Employee Menu");		
	}


	@Override
	public void displaySecure(int accountNumber) {
		display();
	}
	
	

}
