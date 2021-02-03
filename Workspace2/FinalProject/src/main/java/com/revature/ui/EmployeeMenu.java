package com.revature.ui;

import org.apache.log4j.Logger;


public class EmployeeMenu implements MenuSystem {

	private static Logger log=Logger.getLogger(MainMenu.class);
	
	@Override
	public void display() {
		int choice=0;
		log.info("Employee Menu");

		do {
			log.info("1.) Exit application");
			log.info("2.) Search for account");
			log.info("3.) View transactions log");
			//log.info("4.) Create new employee account");
			choice=Integer.getInteger(MenuSystem.sc.nextLine());
			log.debug("user's choice was "+choice);
			switch(choice){
				case 1:
					log.info("Exiting Employee Menu");
					break;
				case 2:
					log.debug("heading to search for account as employee menu");
					break;					
				case 3:
					log.debug("heading to view transactions as employee menu");
					break;
				//case 4:
				//	break;
				default:
					log.info("Pease enter a value between 1 and 4");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Employee Menu");

	}

}
