package com.revature.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.CustomerAccount;
import com.revature.ui.CustomerMenu;
//import com.revature.ui.EmployeeMenu;
import com.revature.ui.MenuSystem;
import com.revature.util.CustomerLogin;
import com.revature.util.EmployeeLogin;
import com.revature.util.GetCurrencyNumber;
import com.revature.util.GetName;
import com.revature.util.ValidCurrency;
import com.revature.util.ValidName;
import com.revature.util.ValidPassword;


public class CustomerService {

	private static Logger log=Logger.getLogger(CustomerService.class);

	public boolean accountCreation() {
		//New customer account creation

		CustomerDAO DAO=new CustomerDAOImpl();

		//Get first name
		String firstName=GetName.getName("Please enter your first name:");
		
		if (ValidName.isNotValidPassword(firstName)){
			log.info("Your first name cannot be left blank.");
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}

		
		//Get last name		
		String lastName=GetName.getName("Please enter your last name:");

		if (ValidName.isNotValidPassword(lastName)){
			log.info("Your last name cannot be left blank.");
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}

		//Get password
		log.info("Please enter your password: (must be at least 8 characters long)");
		String password=MenuSystem.sc.nextLine();
		log.debug("password entered");
		
		if (ValidPassword.isNotValidPassword(password)){
			log.info("Password cannot be left blank.");
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}

		//Get initial deposit to checking and savings accounts
		double initialChecking=GetCurrencyNumber.getCurrencyValue("Please enter your initial checking acount deposit (enter 0 for none): ");
		double initialSaving=GetCurrencyNumber.getCurrencyValue("Please enter your initial saving acount deposit (enter 0 for none): ");		
		
		if (ValidCurrency.isNotValidCurrency(initialChecking) || ValidCurrency.isNotValidCurrency(initialSaving)) {
			log.info("Initial checking and savings values should be greater and or equal to 0 and contain no more than 2 digits after the decimal");
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}
		
		//Get date of birth
		log.info("Please enter your date of birth: YYYY-MM-DD");
		String dobString=MenuSystem.sc.nextLine();
		log.debug("DOB: "+dobString);
		LocalDate dob;
		
		try {
			dob=LocalDate.parse(dobString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			log.debug("Date of birth is: "+dob);
		}catch (DateTimeParseException e) {
			log.info("Invalid Date");
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}		


		//Print out for employee
		log.info("For employee verifcation:");
		log.info("first name: "+firstName+" last name: "+lastName+" password entered"+" initial checking deposit: "+initialChecking+" initial saving deposit: "+initialSaving+" date of birth "+dob);
		

		//Employee confirmation
		log.info("To approve, login.  To dissaprove, input incorrect login information:");
		if (EmployeeLogin.login(EmployeeLogin.getAccountNumber(), EmployeeLogin.getPassword())) {
			log.debug("Employee has approved");
			
		}else {
			log.info("Incorrect employee account number and/or password");
			log.debug("Employee has not approved");
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}

		//Sending the data to the DAO layer to create account
		int result=0;
		try {
			result=DAO.CreateCustomerAccount(firstName, lastName, password, initialChecking, initialSaving, dob);
		} catch (DatabaseConnectionException e) {
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}
		
		if (result==1) {
		log.info("Your account was succesfully created");
		return(true);
		}else {
			log.info("Your account was not succesfully created.  Please try again");
			return(false);
		}
		
	}

	public static double getAccountBalance(String searchBy, String searchFor, int account) {
		//Get checking or saving account balance
		
		CustomerDAO DAO=new CustomerDAOImpl();
		CustomerAccount result=null;
		
		//Get account from the DAO layer
		try {
			result = DAO.getAccountInfo(searchBy, account);
		} catch (DatabaseConnectionException e){
			e.printStackTrace();
		}catch(AccountNotFoundException e){
			log.debug("customer account not found");
			return(-1);
		}
		
		//Return checking or saving account balance
		if (result!=null) {
			log.debug(result);
			switch (searchFor) {
			case "checking account balance":
				return(result.getCheckingBalance());
			case "savings account balance":
				return(result.getSavingBalance());			
			}
		}else {
			log.debug("getAccountBalance=null");
		}
		return(-1);
	}
		
	public static void MoneyExchange(int accountNumber, String type, int otherAccountNumber) {
		//Money exchanged between two accounts
		
		int choice=0;
		CustomerDAO dao=new CustomerDAOImpl();
		int result=1;
		double amount=0;

		//get other account
		if (otherAccountNumber<0){
			try {
				log.info("Please, enter the other account number (checking accounts should end in a 1 and savings accounts should end in a 2)");
				otherAccountNumber=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("Other account: "+otherAccountNumber);
				if ((otherAccountNumber%10)!=1 && (otherAccountNumber%10)!=2 && (otherAccountNumber)>0) {
					log.info("please enter a valid account number");
					return;	
				}
				
				}catch (NumberFormatException e) {
					//log.info("Please enter a number for the "+type+" amount");
					log.info("please enter a valid account number");
					return;
			}
		}	
		
		//Get if exchange is with checking or savings account
		try {
			log.info("1.) "+type+" to/from checking account");
			log.info("2.) "+type+" to/from savings account");

			choice=Integer.parseInt(MenuSystem.sc.nextLine());
			log.debug("Account type: "+choice);
			if (choice==1 || choice==2) {
				accountNumber=accountNumber*10+choice;
			}else {
				log.info("Please enter a number 1 or a 2 for the account type");
				return;	
			}
		}catch (NumberFormatException e) {
			log.info("Please enter a number 1 or a 2 for the account type");
			return;
		}
			
		//Get transaction amount	
		try {
//			log.info("Please enter the "+type+" amount");
//			amount=Double.parseDouble(MenuSystem.sc.nextLine());
//			log.debug(type+" amount: "+amount);

			amount=GetCurrencyNumber.getCurrencyValue("Please enter the "+type+" amount");
			}catch (NumberFormatException e) {
				log.info("Please enter a number in the form of 0.00 for the "+type+ " value");
				return;
			}
		
			if (ValidCurrency.isNotValidCurrency(amount)){
				log.info("The amount for the "+type+" should be greater and or equal to 0 and contain no more than 2 digits after the decimal");
				return;
			}


		
		//check if withdraw account has enough money
		if (type.equals("Withdraw")) {
			if (accountNumber%10==1) {
				//log.debug("Account balance: "+CustomerService.getAccountBalance("accountNumber", "checking account balance", accountNumber/10));				
				if (amount>CustomerService.getAccountBalance("accountNumber", "checking account balance", accountNumber/10)) {		
					log.info("Insufficient Funds");
					return;
				}
			}else if (accountNumber%10==2){
				//log.debug("Account balance: "+CustomerService.getAccountBalance("accountNumber", "savings account balance", accountNumber/10));
				if (amount>CustomerService.getAccountBalance("accountNumber", "savings account balance", accountNumber/10)) {		
					log.info("Insufficient Funds");
					return;
				}	
			}
		}else {
			if (otherAccountNumber!=0) {
				if (otherAccountNumber%10==1) {
					//log.debug("Other account balance: "+CustomerService.getAccountBalance("accountNumber", "checking account balance", otherAccountNumber/10));
					if (amount>CustomerService.getAccountBalance("accountNumber", "checking account balance", otherAccountNumber/10)) {		
						log.info("Insufficient Funds");
						return;
					}
				}else if(otherAccountNumber%10==2){
					//log.debug("Other account balance: "+CustomerService.getAccountBalance("accountNumber", "savings account balance", otherAccountNumber/10));
					if (amount>CustomerService.getAccountBalance("accountNumber", "savings account balance", otherAccountNumber/10)) {		
						log.info("Insufficient Funds");
						return;
					}
				}	
			}
		}

		
		//Second person verifies acceptance of transaction
		log.info(accountNumber+" will "+type+" "+amount+" to "+otherAccountNumber);		
		//other account verification:
		if (otherAccountNumber>0 && otherAccountNumber/10!=accountNumber/10) {
			log.info("To complete transaction, "+otherAccountNumber+" must enter password");
			log.info("Please enter password");
			String password=MenuSystem.sc.nextLine();
			log.debug("password entered");
			
			CustomerLogin customerLogin=new CustomerLogin();
			if (customerLogin.login(otherAccountNumber/10, password)) {
				log.info("Login successful");
			}else {
				log.info("Incorrect account number and/or password");
				return;
			}
		}
		
		//Call DAO layer to update account amounts and add to transactions		
		if (type=="Deposit") {
			result=dao.exchangeMoney(accountNumber, otherAccountNumber, amount);
		}else {			
			result=dao.exchangeMoney(otherAccountNumber, accountNumber, amount);
		}
		if (result==1) {
			log.info("Transaction succesful");
		}else {
			log.info("Transaction failed");
		}
		
	}
	
	
}
