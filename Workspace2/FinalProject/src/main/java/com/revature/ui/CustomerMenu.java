package com.revature.ui;

import org.apache.log4j.Logger;

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
			log.info("4.) Deposit Money");
			log.info("5.) Withdraw Money");
			log.info("6.) View checking account transactions");
			log.info("7.) View savings account transactions");

			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				log.info("Please enter an integer between 1 and 7");
			}
			
			switch(choice){
				case 1:
					log.info("Exiting Customer Menu");
					break;
				case 2:
					//System.out.println("2");
					log.debug("Getting Checking Account Balance");
					log.info( "Checking account balance"+CustomerService.getAccountBalance("accountNumber", "checking account balance", accountNumber));
					break;					
				case 3:
					//System.out.println("3");
					log.debug("Getting Saving Account Balance");
					log.info( "Saving account balance"+CustomerService.getAccountBalance("accountNumber", "savings account balance", accountNumber));

					break;
				case 4:
					System.out.println("4");
					log.debug("Heading to Deposit Money");
					MenuSystemSecure depositMoney= new DepositMoney(); 
					depositMoney.displaySecure(accountNumber);
					break;
				case 5:
					System.out.println("5");
					log.debug("Heading to Withdraw Money");
					MenuSystemSecure withdrawMoney= new WithdrawMoney(); 
					withdrawMoney.displaySecure(accountNumber);
					break;					
				case 6:
					System.out.println("6");
					log.debug("Getting Checking Account Transactions");
					EmployeeService.transactions(accountNumber*10+1);
					break;
				case 7:
					System.out.println("7");
					log.debug("Getting Saving Account Transactions");
					EmployeeService.transactions(accountNumber*10+2);
				default:
					log.info("Pease enter a value between 1 and 7");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Customer Menu");
		
	}

}
