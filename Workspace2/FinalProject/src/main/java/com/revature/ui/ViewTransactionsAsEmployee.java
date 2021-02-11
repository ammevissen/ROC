package com.revature.ui;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.CustomerTransaction;
import com.revature.service.EmployeeService;
import com.revature.util.GetAccountNumber;
import com.revature.util.ValidAccount;


public class ViewTransactionsAsEmployee implements MenuSystem {

	private static Logger log=Logger.getLogger(ViewTransactionsAsEmployee.class);

	
	@Override
	public void display() {
		int choice=0;
		log.info("Employee View Transactions Menu");

		do {
			log.info("1.) Exit Employee View Transactions Menu");
			log.info("2.) View by account number");
			log.info("3.) View by checking account number");
			log.info("4.) View by savings account number");


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
					int accNumber=GetAccountNumber.getAccountNumber("Please enter the account number of interest: ");
					log.debug("accNumber: "+accNumber);

					if (!ValidAccount.isNotValidAccount(accNumber)) {
						List<CustomerTransaction> transactions=EmployeeService.allAccountTransactions(accNumber);
						SortingTransactionsMenu sortingTransactionsMenu=new SortingTransactionsMenu();
						sortingTransactionsMenu.display(transactions);
					}else {
						log.info("Invalid account number");
					}
					break;					

				case 3:
					int checkingAccNumber=GetAccountNumber.getAccountNumber("Please enter the checking account number of interest: ");
					log.debug("checkingAccNumber: "+checkingAccNumber);
					
					if (checkingAccNumber%10==1 && !ValidAccount.isNotValidAccount(checkingAccNumber)) {
						List<CustomerTransaction> checkingTransactions=EmployeeService.transactions(checkingAccNumber);
						SortingTransactionsMenu sortingCheckingTransactionsMenu=new SortingTransactionsMenu();
						sortingCheckingTransactionsMenu.display(checkingTransactions);
					}else {
						log.info("Invalid checking account number");
					}
					break;			

				case 4:
					int savingAccNumber=GetAccountNumber.getAccountNumber("Please enter the saving account number of interest: ");
					log.debug("savingAccNumber: "+savingAccNumber);
					
					if (savingAccNumber%10==2 && !ValidAccount.isNotValidAccount(savingAccNumber)) {
						List<CustomerTransaction> savingsTransactions=EmployeeService.transactions(savingAccNumber);
						SortingTransactionsMenu sortingSavingsTransactionsMenu=new SortingTransactionsMenu();
						sortingSavingsTransactionsMenu.display(savingsTransactions);
					}else {
						log.info("Invalid saving account number");
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
