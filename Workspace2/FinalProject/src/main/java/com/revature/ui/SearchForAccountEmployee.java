package com.revature.ui;

import org.apache.log4j.Logger;

import com.revature.service.EmployeeService;
import com.revature.util.GetAccountNumber;
import com.revature.util.ValidAccount;


public class SearchForAccountEmployee implements MenuSystem{

	private static Logger log=Logger.getLogger(SearchForAccountEmployee.class);

	
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


			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				choice=0;
			}

			switch(choice){
				case 1:
					log.info("Exiting Employee Search for Account Menu");
					break;

				case 2:
					log.info("Enter the first name of the account to search for:");
					String firstName=MenuSystem.sc.nextLine();
					log.debug("Entering search for account by first name");
					EmployeeService.customer("firstName", firstName);
					break;					
				
				case 3:
					log.info("Enter the last name of the account to search for:");
					String lastName=MenuSystem.sc.nextLine();
					log.debug("Entering search for account by last name");
					EmployeeService.customer("lastName", lastName);
					break;
				
				case 4:
					int acc=GetAccountNumber.getAccountNumber("Enter the account number of the account to search for:");
					log.debug("Entering search for account by account number: "+acc);
					if (!ValidAccount.isNotValidAccount(acc)) {
						EmployeeService.customer("accountNumber", acc);
					}
					
					break;
				
				case 5:
					int accChecking=GetAccountNumber.getAccountNumber("Enter the checking account number of the account to search for:");
					log.debug("Entering search for checking account by checking account number: "+accChecking);
					if (!ValidAccount.isNotValidAccount(accChecking)) {
						EmployeeService.customer("checkingID", accChecking);
					}
					
					break;
				
				case 6:
					int accSaving=GetAccountNumber.getAccountNumber("Enter the savings account number of the account to search for:");
					log.debug("Entering search for savings account by saving account number: "+accSaving);
					if (!ValidAccount.isNotValidAccount(accSaving)) {
						EmployeeService.customer("savnigsID", accSaving);
					}
					break;

				default:
					log.info("Pease enter a value between 1 and 6");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Search for Account as Employee Menu");		
	}

	
	

}
