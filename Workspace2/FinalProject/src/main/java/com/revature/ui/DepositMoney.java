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
			log.info("2.) Deposit cash or check");
			log.info("3.) Deposit money from another account");

			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				choice=0;
			}

			switch(choice){
				case 1:
					log.info("Exiting Deposit Menu");
					break;

				case 2:
					log.debug("Deposit cash or check");
					CustomerService.MoneyExchange(accountNumber, "Deposit", 0);
					break;					
				
				case 3:
					log.debug("Deposit money from another account");
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
