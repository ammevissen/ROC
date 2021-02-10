package com.revature.ui;

import org.apache.log4j.Logger;

import com.revature.service.EmployeeService;


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
				log.info("Please enter an integer between 1 and 6");
			}

			switch(choice){
				case 1:
					log.info("Exiting Employee Search for Account Menu");
					break;
				case 2:
					//System.out.println("2");
					log.info("Enter the first name of the account to search for:");
					String firstName=MenuSystem.sc.nextLine();
					log.debug("Entering Search for Account by First Name");
					EmployeeService.customer("firstName", firstName);
					break;					
				case 3:
					//System.out.println("3");
					log.info("Enter the last name of the account to search for:");
					String lastName=MenuSystem.sc.nextLine();
					log.debug("Entering Search for Account by Last Name");
					EmployeeService.customer("lastName", lastName);
					break;
				case 4:
					//System.out.println("4");
					log.info("Enter the account number of the account to search for:");
					int acc=Integer.parseInt(MenuSystem.sc.nextLine());
					log.debug("Entering Search for Account by Account Number: "+acc);
					EmployeeService.customer("accountNumber", acc);
					break;
				case 5:
					//System.out.println("5");
					log.info("Enter the account number of the account to search for:");
					int accChecking=Integer.parseInt(MenuSystem.sc.nextLine());
					log.debug("Entering Search for Account by Checking Account Number: "+accChecking);
					EmployeeService.customer("checkingID", accChecking);
					break;
				case 6:
					//System.out.println("6");
					log.info("Enter the account number of the account to search for:");
					int accSaving=Integer.parseInt(MenuSystem.sc.nextLine());
					log.debug("Entering Search for Account by Saving Account Number: "+accSaving);
					EmployeeService.customer("savnigsID", accSaving);
					break;

				default:
					log.info("Pease enter a value between 1 and 6");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Search for Account as Employee Menu");		
	}

	
	

}
