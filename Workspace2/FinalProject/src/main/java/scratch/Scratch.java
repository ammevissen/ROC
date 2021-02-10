package scratch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.CustomerAccount;
import com.revature.model.CustomerTransaction;
import com.revature.ui.MenuSystem;
import com.revature.util.ConnectionUtil;
import com.revature.util.EmployeeLogin;

import eg1.Account;

import java.math.BigDecimal;

public class Scratch {

	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);
	
	public static void main(String[] args) throws DatabaseConnectionException {
		// TODO Auto-generated method stub
//		System.out.println((long)(Math.E*1000000000000000l));
//		System.out.println((long)(Math.PI*1000000000000000l));
		
		

		
		
		
//		try(Connection connection=ConnectionUtil.getConnection()){
//
//			String getAccNum="SELECT max(accountNumber) FROM ROC_Banking.customer";
//			PreparedStatement stmt=connection.prepareStatement(getAccNum);		
//			ResultSet maxAccNum=stmt.executeQuery();
//			System.out.println(4);
//			//if (maxAccNum.next()) {
//			maxAccNum.next();
//			System.out.println(maxAccNum.getInt(1));
//			int accNum=maxAccNum.getInt(1)+1;
//			//}
//			
//			String firstName="andy";
//			String lastName="mev";
//			String password="p@55w0rd";
//			int checkingID=accNum*10+1;
//			int savingID=accNum*10+2;
//			double checkingBalance=10.0;
//			double savingBalance=100.0;
//			double initialChecking=checkingBalance;
//			double initialSaving=savingBalance;
//			
//			System.out.println("creating acc string");
//			String acc="INSERT INTO ROC_Banking.customer (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID, checkingBalance, savingBalance)"
//						+"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//			
////			String acc="INSERT INTO ROC_Banking.customer (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID)"
////					+"VALUES(?, ?, ?, ?, ?, ?)";
////		
//			
//			PreparedStatement pstmt=connection.prepareStatement(acc);	
//			System.out.println("pstmt");
//			pstmt.setInt(1, accNum);
//			pstmt.setString(2, firstName);
//			pstmt.setString(3, lastName);
//			pstmt.setString(4, password);
//			pstmt.setInt(5, checkingID);
//			pstmt.setInt(6, savingID);
//			pstmt.setDouble(7, checkingBalance);
//			pstmt.setDouble(8, savingBalance);
//			
//			
//			
//			String strChecking="INSERT INTO ROC_Banking.trasactions (accuontID, trasancitonAmount, trasancitonType)"
//						+"VALUES(?, ?, ?)";
//			PreparedStatement pstmtChecking=connection.prepareStatement(strChecking);	
//			pstmtChecking.setInt(1, checkingID);
//			pstmtChecking.setDouble(2, initialChecking);
//			pstmtChecking.setString(3, "Initial Deposit");
//			
//			
//			String strSaving="INSERT INTO ROC_Banking.trasactions (accuontID, trasancitonAmount, trasancitonType)"
//						+"VALUES(?, ?, ?)";
//			PreparedStatement pstmtSavking=connection.prepareStatement(strSaving);	
//			pstmtSavking.setInt(1, savingID);
//			pstmtSavking.setDouble(2, initialSaving);
//			pstmtSavking.setString(3, "Initial Deposit");
//			
//
//			
//			System.out.println("executing");
//			int result=pstmt.executeUpdate();
//			System.out.println("result: "+result);
//			
//			result=pstmtChecking.executeUpdate();
//			System.out.println("result checking: "+result);
//					
//			result=pstmtSavking.executeUpdate();
//			System.out.println("result Saving: "+result);
//				
//			
//			
//		} catch (IOException | SQLException e) {
//			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//		} 

		
		
//		int accountNumber=1;
//		String password;
//		try(Connection connection=ConnectionUtil.getConnection()){
//			//log.debug("getting max account number");
//		String getAccNum="SELECT customerPassword FROM ROC_Banking.customer WHERE accountNumber=?";
//		PreparedStatement pstmt=connection.prepareStatement(getAccNum);		
//		pstmt.setInt(1, accountNumber);
//		
//		
//		ResultSet pswd=pstmt.executeQuery();
//		pswd.next();
//		
//		password=pswd.getString(1);
//		
//		
//		
//		System.out.println("password: "+password);
//		
//		} catch (IOException | SQLException e) {
//		throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//		} 
	

//		log.info("Please enter your first name:");
//		String firstName=MenuSystem.sc.nextLine();
//		log.debug("first name: "+firstName);
//		
//		log.info("Please enter your last name:");
//		String lastName=MenuSystem.sc.nextLine();
//		log.debug("first name: "+lastName);
//		
//		log.info("Please enter your password:");
//		String password=MenuSystem.sc.nextLine();
//		log.debug("password entered");
//		System.out.println("password: "+password);
//		if (password==null || password.equals("/n") || password.equals("")){
//			log.info("Password cannot be left blank.");
//			log.info("Your account was not succesfully created please try again");
//			//return(false);
//		}
//		
//		double initialChecking=0;
//		double initialSaving=0;
//		
//		try {
//			log.info("Please enter your initial checking acount deposit (enter 0 for none): ");
//			initialChecking=Double.parseDouble(MenuSystem.sc.nextLine());
//			log.debug("Initial checking amount: "+initialChecking);
//		
//			log.info("Please enter your initial saving acount deposit (enter 0 for none): ");
//			initialSaving=Double.parseDouble(MenuSystem.sc.nextLine());
//			log.debug("Initial checking amount: "+initialSaving);
//		}catch (NumberFormatException e) {
//			log.info("Please enter a number in the form of 0.00 for initial checking and savings account values");
//			log.info("Your account was not succesfully created please try again");
//		}
//		
//		if ((initialChecking*100)%1!=0.0 || initialChecking<0 || (initialSaving*100)%1!=0.0 || initialSaving<0 ){
//			log.info("Initial checking ans savings values should be greater and or equal to 0 and contain no more than 2 digits after the decimal");
//			log.info("Your account was not succesfully created please try again");
//		}
//		log.info("your account was succesfully created");

//		String searchBy="firstName";
//		String name="andy";
//		
//		List<CustomerAccount> result=new ArrayList<>(); //=new CustomerAccount();
//		
//		try(Connection connection=ConnectionUtil.getConnection()){
//			
//			String getAccount="SELECT * FROM ROC_Banking.customer WHERE "+searchBy+" = ?";
//			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
////			pstmt.setString(1, searchBy);
////			pstmt.setString(2, name);
//			pstmt.setString(1, name);
//
//			
//			System.out.println(pstmt);
//			ResultSet account=pstmt.executeQuery();
//			while (account.next()) {
//				CustomerAccount tempResult= new CustomerAccount();
//				tempResult.setAccountNumber(account.getInt("accountNumber"));
//				tempResult.setFirstName(account.getString("firstName"));
//				tempResult.setLastName(account.getString("lastName"));
//				tempResult.setCheckingID(account.getInt("checkingID"));
//				tempResult.setSavingsID(account.getInt("savnigsID"));
//				tempResult.setCheckingBalance(account.getDouble("checkingBalance"));
//				tempResult.setSavingBalance(account.getDouble("savingBalance"));
//				result.add(tempResult);
//			}
//		
//		} catch (IOException | SQLException e) {
//			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//		} 
//
//		
//		for (CustomerAccount account: result) {
//			log.info(account);
//		}
//		System.out.println("done");
		
//		int accountNum=31;
//		List<CustomerTransaction> result=new ArrayList<>(); //=new CustomerAccount();
//		
//		try(Connection connection=ConnectionUtil.getConnection()){
//			
//			String getAccount="SELECT * FROM ROC_Banking.trasactions WHERE accountID = ?";
//			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
//			pstmt.setInt(1, accountNum);
//
//			
//			log.debug(pstmt);
//			ResultSet account=pstmt.executeQuery();
//			while (account.next()) {
//				CustomerTransaction tempResult= new CustomerTransaction();
//				tempResult.setAccountID(account.getInt("accountID"));
//				tempResult.setAmount(account.getInt("trasancitonAmount"));
//				tempResult.setTrasancitonType(account.getString("trasancitonType"));
//				tempResult.setTrasanciontPartner(account.getInt("trasanciontPartner"));
//				
//				
//				result.add(tempResult);
//			}
//		
//		} catch (IOException | SQLException e) {
//			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//		}  
//
//		
//		for (CustomerTransaction account: result) {
//			log.info(account);
//		}
		
//		int accountNumber=31;
//		int otherAccountNumber=42;
//		double amount=1;
//		
//		try(Connection connection=ConnectionUtil.getConnection()){
//			//log.debug("getting max account number");
//			String deposit="INSERT INTO ROC_Banking.trasactions (accuontID, trasancitonAmount, trasancitonType, trasanciontPartner)"
//					+"VALUES(?, ?, ?, ?)";
//			PreparedStatement pstmtDeposit=connection.prepareStatement(deposit);	
//			pstmtDeposit.setInt(1, accountNumber);
//			pstmtDeposit.setDouble(2, amount);
//			pstmtDeposit.setString(3, "Deposit");
//			pstmtDeposit.setInt(4, otherAccountNumber);
//			
//			String withdraw="INSERT INTO ROC_Banking.trasactions (accuontID, trasancitonAmount, trasancitonType, trasanciontPartner)"
//					+"VALUES(?, ?, ?, ?)";
//			PreparedStatement pstmtWithdraw=connection.prepareStatement(withdraw);	
//			pstmtWithdraw.setInt(1, otherAccountNumber);
//			pstmtWithdraw.setDouble(2, amount);
//			pstmtWithdraw.setString(3, "Withdraw");
//			pstmtWithdraw.setInt(4, accountNumber);
//			
//			
//			double currentDeposit=0;
//			double currentWithdraw=0;
//			double newDeposit=0;
//			double newWithdraw=0;
//			
//			if (accountNumber%10==1 || accountNumber%10==2) {
//				String getDeposit="";
//				if (accountNumber%10==1) {
//					getDeposit="SELECT checkingBalance FROM ROC_Banking.customer WHERE checkingID=?";
//				}else if(accountNumber%10==2){
//					getDeposit="SELECT savingBalance FROM ROC_Banking.customer WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(getDeposit);		
//				pstmt.setInt(1, accountNumber);
//				ResultSet resultCurrentDeposit=pstmt.executeQuery();
//				resultCurrentDeposit.next();
//				currentDeposit=resultCurrentDeposit.getDouble(1);
//				newDeposit=currentDeposit+amount;
//			}
//			
//
//			if (otherAccountNumber%10==1 || otherAccountNumber%10==2) {
//				String getWithdaw="";
//				if (otherAccountNumber%10==1) {
//					getWithdaw="SELECT checkingBalance FROM ROC_Banking.customer WHERE checkingID=?";
//				}else if(otherAccountNumber%10==2){
//					getWithdaw="SELECT savingBalance FROM ROC_Banking.customer WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(getWithdaw);		
//				pstmt.setInt(1, otherAccountNumber);
//				ResultSet resultCurrentWithdraw=pstmt.executeQuery();
//				resultCurrentWithdraw.next();
//				currentWithdraw=resultCurrentWithdraw.getDouble(1);
//				newWithdraw=currentWithdraw-amount;
//			}
//
//			int tempResult;
//			int result=1;
//			
//			if (accountNumber%10==1 || accountNumber%10==2) {
//				String updateDeposit="";
//				if (accountNumber%10==1) {
//					updateDeposit="UPDATE ROC_Banking.customer SET checkingBalance =? WHERE checkingid=?";
//				}else if(accountNumber%10==2){
//					updateDeposit="UPDATE ROC_Banking.customer SET savingBalance =? WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(updateDeposit);		
//				pstmt.setDouble(1, newDeposit);
//				pstmt.setInt(2, accountNumber);
//				tempResult=pstmt.executeUpdate();
//				result=Math.min(result, tempResult);
//				
//			}
//			
//			if (otherAccountNumber%10==1 || otherAccountNumber%10==2) {
//				String updateWithdraw="";
//				if (otherAccountNumber%10==1) {
//					updateWithdraw="UPDATE ROC_Banking.customer SET checkingBalance =? WHERE checkingid=?";
//				}else if(otherAccountNumber%10==2){
//					updateWithdraw="UPDATE ROC_Banking.customer SET savingBalance =? WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(updateWithdraw);		
//				pstmt.setDouble(1, newWithdraw);
//				pstmt.setInt(2, otherAccountNumber);
//				tempResult=pstmt.executeUpdate();
//				result=Math.min(result, tempResult);
//			}
//			
//			
//			tempResult=pstmtDeposit.executeUpdate();
//			result=Math.min(result, tempResult);
//			
//			tempResult=pstmtWithdraw.executeUpdate();
//			result=Math.min(result, tempResult);
//			
//			
//			System.out.println(result);
//		} catch (IOException | SQLException e) {
//			//throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//			e.getMessage();
//		} 
//		
		
//		EmployeeLogin employeeLogin=new EmployeeLogin();
//		log.info("To approve, login.  To dissaprove, input incorrect login information:");
//		
//		if (employeeLogin.login()) {
//			log.debug("employee has approved");
//			
//		}else {
//			log.info("Incorrect employee account number and/or password");
//			log.debug("employee has not approved");
//			log.info("Your account was not succesfully created please try again");
//		}
		
		//public String getPassword(int accountNumber) throws DatabaseConnectionException {
//		int accountNumber=1;	
//		String password;
//			
//			try(Connection connection=ConnectionUtil.getConnection()){
//		
//				String getPassword="SELECT employeePassword FROM roc_banking.employee WHERE employeeNumber=?";
//				PreparedStatement pstmt=connection.prepareStatement(getPassword);		
//				pstmt.setInt(1, accountNumber);
//					
//				ResultSet pswd=pstmt.executeQuery();
//				pswd.next();
//				password=pswd.getString(1);
//			
//			} catch (IOException | SQLException e) {
//				throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//			}
//		System.out.println(password);
//		int accountNumber=11;
//		int otherAccountNumber=21;
//		double amount=1;
//				
//		try(Connection connection=ConnectionUtil.getConnection()){
//			//log.debug("getting max account number");
//			String deposit="INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)"
//					+"VALUES(?, ?, ?, ?)";
//			PreparedStatement pstmtDeposit=connection.prepareStatement(deposit);	
//			pstmtDeposit.setInt(1, accountNumber);
//			pstmtDeposit.setDouble(2, amount);
//			pstmtDeposit.setString(3, "Deposit");
//			pstmtDeposit.setInt(4, otherAccountNumber);
//			
//			
//			String withdraw="INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)"
//					+"VALUES(?, ?, ?, ?)";
//			PreparedStatement pstmtWithdraw=connection.prepareStatement(withdraw);	
//			pstmtWithdraw.setInt(1, otherAccountNumber);
//			pstmtWithdraw.setDouble(2, amount);
//			pstmtWithdraw.setString(3, "Withdraw");
//			pstmtWithdraw.setInt(4, accountNumber);
//			
//			
//			double currentDeposit=0;
//			double currentWithdraw=0;
//			double newDeposit=0;
//			double newWithdraw=0;
//			
//			if (accountNumber%10==1 || accountNumber%10==2) {
//				String getDeposit="";
//				if (accountNumber%10==1) {
//					getDeposit="SELECT checkingBalance FROM roc_banking.customer WHERE checkingID=?";
//				}else if(accountNumber%10==2){
//					getDeposit="SELECT savingBalance FROM roc_banking.customer WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(getDeposit);		
//				pstmt.setInt(1, accountNumber);
//				ResultSet resultCurrentDeposit=pstmt.executeQuery();
//				resultCurrentDeposit.next();
//				currentDeposit=resultCurrentDeposit.getDouble(1);
//				newDeposit=currentDeposit+amount;
//			}
//			
//
//			if (otherAccountNumber%10==1 || otherAccountNumber%10==2) {
//				String getWithdaw="";
//				if (otherAccountNumber%10==1) {
//					getWithdaw="SELECT checkingBalance FROM roc_banking.customer WHERE checkingID=?";
//				}else if(otherAccountNumber%10==2){
//					getWithdaw="SELECT savingBalance FROM roc_banking.customer WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(getWithdaw);		
//				pstmt.setInt(1, otherAccountNumber);
//				ResultSet resultCurrentWithdraw=pstmt.executeQuery();
//				resultCurrentWithdraw.next();
//				currentWithdraw=resultCurrentWithdraw.getDouble(1);
//				newWithdraw=currentWithdraw-amount;
//			}
//
//			int tempResult;
//			int result=1;
//			
//			if (accountNumber%10==1 || accountNumber%10==2) {
//				String updateDeposit="";
//				if (accountNumber%10==1) {
//					updateDeposit="UPDATE ROC_Banking.customer SET checkingBalance =? WHERE checkingid=?";
//				}else if(accountNumber%10==2){
//					updateDeposit="UPDATE ROC_Banking.customer SET savingBalance =? WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(updateDeposit);		
//				pstmt.setDouble(1, newDeposit);
//				pstmt.setInt(2, accountNumber);
//				tempResult=pstmt.executeUpdate();
//				result=Math.min(result, tempResult);
//				
//			}
//			
//			if (otherAccountNumber%10==1 || otherAccountNumber%10==2) {
//				String updateWithdraw="";
//				if (otherAccountNumber%10==1) {
//					updateWithdraw="UPDATE ROC_Banking.customer SET checkingBalance =? WHERE checkingid=?";
//				}else if(otherAccountNumber%10==2){
//					updateWithdraw="UPDATE ROC_Banking.customer SET savingBalance =? WHERE savnigsID=?";				
//				}
//			
//				PreparedStatement pstmt=connection.prepareStatement(updateWithdraw);		
//				pstmt.setDouble(1, newWithdraw);
//				pstmt.setInt(2, otherAccountNumber);
//				tempResult=pstmt.executeUpdate();
//				result=Math.min(result, tempResult);
//			}
//			
//			
//			if (accountNumber!=0) {
//			tempResult=pstmtDeposit.executeUpdate();
//			result=Math.min(result, tempResult);
//			}
//			
//			if (otherAccountNumber!=0) {
//			tempResult=pstmtWithdraw.executeUpdate();
//			result=Math.min(result, tempResult);
//			}
//			
//			System.out.println(result);
//			//return(result);
//
//		} catch (IOException | SQLException e) {
//			//throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//			e.getMessage();
//		}
//		
//		System.out.println("broke out of try");
//		//return(0);
		
		
//		int accountNum=11;
//		
//		List<CustomerTransaction> result=new ArrayList<>(); //=new CustomerAccount();
//		
//		try(Connection connection=ConnectionUtil.getConnection()){
//			
//			String getAccount="SELECT * FROM ROC_Banking.trasactions WHERE accountID = ?";
//			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
//			pstmt.setInt(1, accountNum);
//
//			
//			log.debug(pstmt);
//			ResultSet account=pstmt.executeQuery();
//			while (account.next()) {
//				CustomerTransaction tempResult= new CustomerTransaction();
//				tempResult.setAccountID(account.getInt("accountID"));
//				tempResult.setAmount(account.getInt("trasancitonAmount"));
//				tempResult.setTrasancitonType(account.getString("trasancitonType"));
//				tempResult.setTrasanciontPartner(account.getInt("trasanciontPartner"));
////				System.out.println(account.getDate("dateCreated"));
//				System.out.println("time: "+account.getTime("timeCreated"));
//				
//				LocalDate dob=LocalDate.parse("2021-02-09", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
////				System.out.println("dob: "+dob);
//				
////				System.out.println(account.getDate("dateCreated").equals(dob));
//				System.out.println("last date: "+account.getObject("dateCreated", LocalDate.class).equals(dob));
//				
////				System.out.println("last date: "+LocalDate.parse(account.getString("dateCreated"), DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals(dob));
//				
//				LocalTime time=LocalTime.parse("21:50:20", DateTimeFormatter.ofPattern("HH:mm:ss"));
//				System.out.println("test time: "+time);
//				LocalTime dbTime=account.getObject("timeCreated", LocalTime.class);
//				System.out.println("last time: "+dbTime.equals(time));
//				
//				
//				result.add(tempResult);
//			}
//		} catch (IOException | SQLException e) {
//			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
//		}  
		
//		List<CustomerTransaction> transactionList = new ArrayList<>();
//		Collections.sort(transactionList, (a1, a2)->{
//			return a1.getCustomerName().compareTo(a2.getCustomerName());
//		});//comparator
//		printAccountDetails(transactionList);
//		
		
	}
}