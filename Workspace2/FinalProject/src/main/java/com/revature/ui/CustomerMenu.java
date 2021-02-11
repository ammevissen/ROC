package com.revature.ui;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.CustomerTransaction;
import com.revature.service.CustomerService;
import com.revature.service.EmployeeService;

//import com.revature.util.CustomerLogin;
//import com.revature.util.EmployeeLogin;


public class CustomerMenu implements MenuSystemSecure {

	private static Logger log=Logger.getLogger(CustomerMenu.class);

	public void displaySecure(int accountNumber) {
		int choice=0;
		log.info("Customer Menu");

		
		do {
			log.info("1.) Exit Customer Menu");
			log.info("2.) View checking account balance");
			log.info("3.) View savings account balance");
			log.info("4.) Deposit money");
			log.info("5.) Withdraw money");
			log.info("6.) View checking account transactions");
			log.info("7.) View savings account transactions");

			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				choice=0;
			}
			
			switch(choice){
				case 1:
					log.info("Exiting Customer Menu");
					break;
				
				case 2:
					log.debug("Getting checking account balance");
					log.info( "Checking account balance "+CustomerService.getAccountBalance("accountNumber", "checking account balance", accountNumber));
					break;					
				
				case 3:
					log.debug("Getting saving account balance");
					log.info( "Saving account balance "+CustomerService.getAccountBalance("accountNumber", "savings account balance", accountNumber));
					break;

				case 4:
					log.debug("Heading to deposit money");
					MenuSystemSecure depositMoney= new DepositMoney(); 
					depositMoney.displaySecure(accountNumber);
					break;

				case 5:
					log.debug("Heading to withdraw money");
					MenuSystemSecure withdrawMoney= new WithdrawMoney(); 
					withdrawMoney.displaySecure(accountNumber);
					break;					

				case 6:
					log.debug("Getting checking account transactions");
					List<CustomerTransaction> checkingTransactions=EmployeeService.transactions(accountNumber*10+1);
					SortingTransactionsMenu sortingCheckingTransactionsMenu=new SortingTransactionsMenu();
					sortingCheckingTransactionsMenu.display(checkingTransactions);
					break;

				case 7:
					log.debug("Getting saving account transactions");
					List<CustomerTransaction> savingsTransactions=EmployeeService.transactions(accountNumber*10+2);
					SortingTransactionsMenu sortingSavingsTransactionsMenu=new SortingTransactionsMenu();
					sortingSavingsTransactionsMenu.display(savingsTransactions);

				default:
					log.info("Pease enter a value between 1 and 7");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Customer Menu");
		
	}

}
