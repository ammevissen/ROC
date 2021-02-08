package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.CustomerAccount;
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

	public static double getAccountBalance(String searchBy, String searchFor, int account) {
		CustomerDAO DAO=new CustomerDAOImpl();
		CustomerAccount result=null;
		
		try {
			result = DAO.getAccountInfo(searchBy, account);
		} catch (DatabaseConnectionException e){
			e.printStackTrace();
		}catch(AccountNotFoundException e){
			log.debug("customer account not found");
			return(0);
		}
		
		if (result!=null) {
			switch (searchFor) {
			case "checking account balance":
				return(result.getCheckingBalance());
			case "savings account balance":
				return(result.getSavingBalance());			
			}
		}
		return(0);
	}
	
//	log.info("2.) View checking account balance");
//	log.info("3.) View savings account balance");
//	log.info("4.) Deposit Money");
//	log.info("5.) Withdraw Money");
//	log.info("6.) View checking account transactions");
//	log.info("7.) View savings account transactions");
	
	public static void MoneyExchange(int accountNumber, String type, int otherAccountNumber) {
		int choice=0;
		//get other account
		if (otherAccountNumber<0){
			try {
				log.info("Please enter the other account number (checking accounts should end in a 1 and savings accounts should end in a 2)");
				otherAccountNumber=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("Account type: "+otherAccountNumber);
				if ((otherAccountNumber%10)!=1 && (otherAccountNumber%10)!=2) {
					log.info("please enter a valid account number");
					return;	
				}
				
			}catch (NumberFormatException e) {
				log.info("Please enter a number for the "+type+" amount");
			}
		}	
		
		//get if exchange with checking or savings account
		try {
			log.info("1.) to "+type+" from checking account");
			log.info("2.) to "+type+" from savings account");

			choice=Integer.parseInt(MenuSystem.sc.nextLine());
			log.debug("Account type: "+choice);
			if (choice==1 || choice==2) {
				accountNumber=accountNumber*10+choice;
			}else {
				log.info("please enter a valid account type");
				return;	
			}
		}catch (NumberFormatException e) {
			log.info("Please enter a number 1 or a 2 for the account type");
			return;
		}
			
		//get transaction amount
		double amount=0;
		
		try {
			log.info("Please enter the "+type+" amount");
			amount=Double.parseDouble(MenuSystem.sc.nextLine());
			log.debug(type+" amount: "+amount);
		
			}catch (NumberFormatException e) {
				log.info("Please enter a number in the form of 0.00 for the "+type+ " value");
				return;
			}
		
			if ((amount*100)%1!=0.0 || amount<0){
				log.info("The amount for the "+type+" should be greater and or equal to 0 and contain no more than 2 digits after the decimal");
				return;
			}
				
		//check if other account has enough money
		if (accountNumber%10==1) {
			if (amount>CustomerService.getAccountBalance("accountNumber", "checking account balance", accountNumber)) {		
				return;
			}
		}else {
			if (amount>CustomerService.getAccountBalance("accountNumber", "saving account balance", accountNumber)) {		
				return;
			}	
		}
		
		//update account amounts and add to transactions
		
		
	}
	
	
}
