package com.revature.ui;

import org.apache.log4j.Logger;

import com.revature.service.CustomerService;


public class WithdrawMoney implements MenuSystemSecure{

	private static Logger log=Logger.getLogger(WithdrawMoney.class);
	
	@Override
	public void displaySecure(int accountNumber) {
		int choice=0;
		log.info("Withdraw Menu");

		
		do {
			log.info("1.) Exit Withdraw Menu");
			log.info("2.) Withdraw Cash or Check");
			log.info("3.) Withdraw from another Account");


			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				log.info("Please enter an integer between 1 and 3m");
			}

			switch(choice){
				case 1:
					log.info("Exiting Withdraw Menu");
					break;
				case 2:
					log.debug("Withdraw Cash or Check");
					CustomerService.MoneyExchange(accountNumber, "Withdraw", 0);
					System.out.println("2");
					break;					
				case 3:
					log.debug("Withdraw from another Account");
					CustomerService.MoneyExchange(accountNumber, "Withdraw", -1);
					System.out.println("3");
					break;

				default:
					log.info("Pease enter a value between 1 and 3");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Withdraw Menu");

		
	}

}
