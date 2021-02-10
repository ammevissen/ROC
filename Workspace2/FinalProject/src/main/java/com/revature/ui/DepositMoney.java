package com.revature.ui;

import org.apache.log4j.Logger;
import com.revature.service.CustomerService;

public class DepositMoney implements MenuSystemSecure{

	private static Logger log=Logger.getLogger(DepositMoney.class);

	@Override
	public void displaySecure(int accountNumber) {
		int choice=0;
		log.info("Deposit Menu");

		
		do {
			log.info("1.) Exit Deposit Menu");
			log.info("2.) Deposit Cash or Check");
			log.info("3.) Deposit from another Account");

			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				log.info("Please enter an integer between 1 and 3");
			}

			switch(choice){
				case 1:
					log.info("Exiting Deposit Menu");
					break;
				case 2:
					System.out.println("2");
					log.debug("Deposit Cash or Check");
					CustomerService.MoneyExchange(accountNumber, "Deposit", 0);
					break;					
				case 3:
					System.out.println("3");
					log.debug("Deposit from another Account");
					CustomerService.MoneyExchange(accountNumber, "Deposit", -1);
					break;

				default:
					log.info("Pease enter a value between 1 and 3");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Deposit Menu");

		
	}

}
