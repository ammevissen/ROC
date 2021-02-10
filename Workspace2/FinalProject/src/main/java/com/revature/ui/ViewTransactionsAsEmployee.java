package com.revature.ui;

import org.apache.log4j.Logger;

import com.revature.service.EmployeeService;


public class ViewTransactionsAsEmployee implements MenuSystem {

	private static Logger log=Logger.getLogger(ViewTransactionsAsEmployee.class);

	
	@Override
	public void display() {
		int choice=0;
		log.info("Employee View Transactions Menu");

		do {
			log.info("1.) Exit Employee View Transactions Menu");
			log.info("2.) View by Account Number");
			log.info("3.) View by Checking Account Number");
			log.info("4.) View by Savings Account Number");


			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				log.info("Please enter an integer between 1 and 4");
			}

			switch(choice){
				case 1:
					log.info("Exiting Employee View Transactions Menu");
					break;
				case 2:
					try {
						log.info("Please enter the Account number of interest: ");
						int accNumber=Integer.parseInt(MenuSystem.sc.nextLine());
						log.debug("Account Number checking: "+accNumber);
						EmployeeService.allAccountTransactions(accNumber);
					}catch (NumberFormatException e) {
						log.info("Please enter the Account number as an integer");
					}
					break;					
				case 3:
//					log.debug("Entering View by Checking Account Number");
//					System.out.println("3");
					try {
						log.info("Please enter the Checking Account number of interest: ");
						int checkingAccNumber=Integer.parseInt(MenuSystem.sc.nextLine());
						log.debug("Initial checking amount: "+checkingAccNumber);
						if (checkingAccNumber%10==1) {
							EmployeeService.transactions(checkingAccNumber);
						}else {
							log.info("please enter a valid checking account number");
						}
					}catch (NumberFormatException e) {
						log.info("Please enter the checking account number as an integer");
					}

					break;			case 4:
//					log.debug("Entering View by Savings Account Number");
//					System.out.println("4");
					try {
						log.info("Please enter the Saving Account number of interest: ");
						int savingAccNumber=Integer.parseInt(MenuSystem.sc.nextLine());
						log.debug("Initial checking amount: "+savingAccNumber);
						if (savingAccNumber%10==2) {
							EmployeeService.transactions(savingAccNumber);
						}else {
							log.info("please enter a valid savings account number");
						}
					}catch (NumberFormatException e) {
						log.info("Please enter the savings account number as an integer");
					}
					
					break;
				default:
					log.info("Pease enter a value between 1 and 4");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting View Transactions as Employee Menu");		
	}


}
