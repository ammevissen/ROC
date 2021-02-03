package com.revature.ui;


import org.apache.log4j.Logger;
import com.revature.ui.CreateAccountMenu;
import com.revature.ui.CustomerMenu;
import com.revature.ui.EmployeeMenu;
import com.revature.util.CustomerLogin;
import com.revature.util.EmployeeLogin;


public class MainMenu implements MenuSystem {

	private static Logger log=Logger.getLogger(MainMenu.class);

	
	@Override
	public void display() {
		int choice=0;
		int loginNumber;
		String password;
		log.info("Main Menu");
		
		do {
			log.info("1.) Exit application");
			log.info("2.) Login as employee");
			log.info("3.) Login as customer");
			log.info("4.) Create customer account");
			
			choice=Integer.getInteger(MenuSystem.sc.nextLine());
			log.debug("user's choice was "+choice);
			switch(choice){
				case 1:
					log.info("Exiting Main Menu");
					break;
				case 2:
					log.debug("attempting to login to employee menu");
					log.info("Please enter account number");
					loginNumber=Integer.getInteger(MenuSystem.sc.nextLine());
					log.debug(loginNumber);
					
					log.info("Please enter password");
					password=MenuSystem.sc.nextLine();
					log.debug("password entered");
					EmployeeLogin employeeLogin=new EmployeeLogin();
					if (employeeLogin.login(loginNumber, password)) {
						log.debug("heading to employee menu");
						MenuSystem employeeMenu=new EmployeeMenu();
						employeeMenu.display();						
					}else {
						log.info("Incorrect employee account number and/or password");
					}
					
					break;					
				case 3:
					log.debug("attempting to login to customer menu");
					log.info("Please enter account number");
					loginNumber=Integer.getInteger(MenuSystem.sc.nextLine());
					log.debug(loginNumber);
					
					log.info("Please enter password");
					password=MenuSystem.sc.nextLine();
					log.debug("password entered");
					CustomerLogin customerLogin=new CustomerLogin();
					if (customerLogin.login(loginNumber, password)) {
						log.debug("heading to customer menu");
						MenuSystem customerMenu=new CustomerMenu();
						customerMenu.display();
					}else {
						log.info("Incorrect account number and/or password");
					}
					break;
				case 4:
					log.debug("heading to create account menu");
					MenuSystem createAccountMenu=new CreateAccountMenu();
					createAccountMenu.display();
					break;
				default:
					log.info("Pease enter a value between 1 and 4");
					break;
			}
			
		}while (choice!=1);
		log.debug("Out of while loop, exiting Main Menu");
	}

}
