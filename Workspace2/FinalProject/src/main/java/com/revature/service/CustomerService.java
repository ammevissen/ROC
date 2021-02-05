package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.DatabaseConnectionException;
//import com.revature.ui.EmployeeMenu;
import com.revature.ui.MenuSystem;
import com.revature.util.EmployeeLogin;


public class CustomerService {

	private static Logger log=Logger.getLogger(CustomerService.class);

	public boolean accountCreation() {
		
		CustomerDAO DAO=new CustomerDAOImpl();
		
		log.info("Please enter your first name:");
		String firstName=MenuSystem.sc.nextLine();
		log.debug("first name: "+firstName);
		
		if (firstName==null || firstName.equals("/n") || firstName.equals("")){
			log.info("Your first name cannot be left blank.");
			log.info("Your account was not succesfully created please try again");
			return(false);
		}

		
		log.info("Please enter your last name:");
		String lastName=MenuSystem.sc.nextLine();
		log.debug("first name: "+lastName);

		if (lastName==null || lastName.equals("/n") || lastName.equals("")){
			log.info("Your last name cannot be left blank.");
			log.info("Your account was not succesfully created please try again");
			return(false);
		}

		log.info("Please enter your password:");
		String password=MenuSystem.sc.nextLine();
		log.debug("password entered");
		if (password==null || password.equals("/n") || password.equals("")){
			log.info("Password cannot be left blank.");
			log.info("Your account was not succesfully created please try again");
			return(false);
		}
		
		double initialChecking=0;
		double initialSaving=0;
		
		try {
			log.info("Please enter your initial checking acount deposit (enter 0 for none): ");
			initialChecking=Double.parseDouble(MenuSystem.sc.nextLine());
			log.debug("Initial checking amount: "+initialChecking);
		
			log.info("Please enter your initial saving acount deposit (enter 0 for none): ");
			initialSaving=Double.parseDouble(MenuSystem.sc.nextLine());
			log.debug("Initial checking amount: "+initialSaving);
		}catch (NumberFormatException e) {
			log.info("Please enter a number in the form of 0.00 for initial checking and savings account values");
			log.info("Your account was not succesfully created please try again");
			return(false);
		}
		
		if ((initialChecking*100)%1!=0.0 || initialChecking<0 || (initialSaving*100)%1!=0.0 || initialSaving<0 ){
			log.info("Initial checking ans savings values should be greater and or equal to 0 and contain no more than 2 digits after the decimal");
			log.info("Your account was not succesfully created please try again");
			return(false);
		}
		
		log.info("for employee verifcation:");
		log.info("first name: "+firstName+" last name: "+lastName+" password entered"+" initial checking deposit: "+initialChecking+" initial saving deposit: "+initialSaving);
		
//		log.info("Please enter employee account number");
//		int loginNumber=Integer.parseInt(MenuSystem.sc.nextLine());
//		log.debug(loginNumber);
//		
//		log.info("Please enter employee password");  //move to be part of employee login method so not duplicated
//		String passwordemployee=MenuSystem.sc.nextLine();
//		log.debug("password entered");
		EmployeeLogin employeeLogin=new EmployeeLogin();
		
		
		log.info("To approve, login.  To dissaprove, input incorrect login information:");
		
		if (employeeLogin.login()) {
			log.debug("employee has approved");
			
		}else {
			log.info("Incorrect employee account number and/or password");
			log.debug("employee has not approved");
			log.info("Your account was not succesfully created please try again");
			return(false);
		}
		
		int result=0;
		try {
			result=DAO.CreateCustomerAccount(firstName, lastName, password, initialChecking, initialSaving);
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result==1) {
		log.info("your account was succesfully created");
		return(true);
		}else {
			log.info("Your account was not succesfully created please try again");
			return(false);
		}
		
	}
	
	
}
