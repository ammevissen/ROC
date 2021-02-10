package com.revature.ui;

import org.apache.log4j.Logger;


public class EmployeeMenu implements MenuSystem {

	private static Logger log=Logger.getLogger(EmployeeMenu.class);
	
	@Override
	public void display() {
		int choice=0;
		log.info("Employee Menu");

		do {
			log.info("1.) Exit Employee Menu");
			log.info("2.) Search for account");
			log.info("3.) View transactions log");
			//log.info("4.) Create new employee account");

			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				choice=0;
			}

			switch(choice){
				case 1:
					log.info("Exiting Employee Menu");
					break;
				case 2:
					log.debug("heading to search for account as employee menu");
					MenuSystem searchForAccountEmployee=new SearchForAccountEmployee();
					searchForAccountEmployee.display();
					break;					
				case 3:
					log.debug("heading to view transactions as employee menu");
					MenuSystem viewTransactionsAsEmployee=new ViewTransactionsAsEmployee();
					viewTransactionsAsEmployee.display();
					break;
				//case 4:
				//	break;
				default:
					log.info("Pease enter a value between 1 and 3");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Employee Menu");

	}


}
