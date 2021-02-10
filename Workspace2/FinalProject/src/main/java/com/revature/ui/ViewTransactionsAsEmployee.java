package com.revature.ui;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.CustomerTransaction;
import com.revature.service.EmployeeService;
import com.revature.util.GetAccountNumber;


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
				choice=0;
			}

			switch(choice){
				case 1:
					log.info("Exiting Employee View Transactions Menu");
					break;
				case 2:
//					try {
//						log.info("Please enter the Account number of interest: ");
//						int accNumber=Integer.parseInt(MenuSystem.sc.nextLine());
//						log.debug("Account Number checking: "+accNumber);
						
						int accNumber=GetAccountNumber.getAccountNumber("Please enter the Account number of interest: ");
						List<CustomerTransaction> transactions=EmployeeService.allAccountTransactions(accNumber);
						SortingTransactionsMenu sortingTransactionsMenu=new SortingTransactionsMenu();
						sortingTransactionsMenu.display(transactions);
//						new SortingTransactionsMenu().display(transactions);
						
//					}catch (NumberFormatException e) {
//						log.info("Please enter the Account number as an integer");
//					}
					break;					
				case 3:
//					log.debug("Entering View by Checking Account Number");
//					System.out.println("3");
//					try {

						int checkingAccNumber=GetAccountNumber.getAccountNumber("Please enter the Checking Account number of interest: ");
						if (checkingAccNumber%10==1) {
							List<CustomerTransaction> checkingTransactions=EmployeeService.transactions(checkingAccNumber);
							SortingTransactionsMenu sortingCheckingTransactionsMenu=new SortingTransactionsMenu();
							sortingCheckingTransactionsMenu.display(checkingTransactions);
						}else {
							log.info("please enter a valid checking account number");
						}
						
//						log.info("Please enter the Checking Account number of interest: ");
//						int checkingAccNumber=Integer.parseInt(MenuSystem.sc.nextLine());
//						log.debug("Initial checking amount: "+checkingAccNumber);
//						if (checkingAccNumber%10==1) {
//							EmployeeService.transactions(checkingAccNumber);
//						}else {
//							log.info("please enter a valid checking account number");
//						}
//					}catch (NumberFormatException e) {
//						log.info("Please enter the checking account number as an integer");
//					}

					break;			
				case 4:
//					log.debug("Entering View by Savings Account Number");
//					System.out.println("4");
					
					int savingAccNumber=GetAccountNumber.getAccountNumber("Please enter the Saving Account number of interest: ");
					if (savingAccNumber%10==2) {
						List<CustomerTransaction> savingsTransactions=EmployeeService.transactions(savingAccNumber);
						SortingTransactionsMenu sortingSavingsTransactionsMenu=new SortingTransactionsMenu();
						sortingSavingsTransactionsMenu.display(savingsTransactions);
					}else {
						log.info("please enter a valid savings account number");
					}

//					try {
//						log.info("Please enter the Saving Account number of interest: ");
//						int savingAccNumber=Integer.parseInt(MenuSystem.sc.nextLine());
//						log.debug("Initial checking amount: "+savingAccNumber);
//						if (savingAccNumber%10==2) {
//							EmployeeService.transactions(savingAccNumber);
//						}else {
//							log.info("please enter a valid savings account number");
//						}
//					}catch (NumberFormatException e) {
//						log.info("Please enter the savings account number as an integer");
//					}
					
					break;
				default:
					log.info("Pease enter a value between 1 and 4");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting View Transactions as Employee Menu");		
	}


}
