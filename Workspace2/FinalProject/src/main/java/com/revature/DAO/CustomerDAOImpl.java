package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.revature.util.ConnectionUtil;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.CustomerAccount;
import com.revature.model.CustomerTransaction;


public class CustomerDAOImpl implements CustomerDAO {

	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public int CreateCustomerAccount(String firstName, String lastName, String password, double initialChecking, double initialSaving, LocalDate dob) throws DatabaseConnectionException{
		//Creating the customer account
		
		int result=1;
		int tempResult;
		int accountNumber;
		int checkingID;
		int savingID;
		
		
		try(Connection connection=ConnectionUtil.getConnection()){
			connection.setAutoCommit(false);
			
			//getting the next account number
			log.debug("getting max account number");
			String getAccNum="SELECT max(accountNumber) FROM ROC_Banking.customer";
			PreparedStatement stmt=connection.prepareStatement(getAccNum);		
			ResultSet maxAccNum=stmt.executeQuery();
			maxAccNum.next();
			
			//Setting the account number, checking account number (CheckingID), and saving account number (savingID)
			accountNumber=maxAccNum.getInt(1)+1;
			log.debug("New Account Number: "+accountNumber);
			checkingID=accountNumber*10+1;
			savingID=accountNumber*10+2;
			
			//Setting the PreparedStatment for the new customer account
			log.debug("creating acc string");
			String acc="INSERT INTO ROC_Banking.customer (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID, checkingBalance, savingBalance, DOB)"
						+"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt=connection.prepareStatement(acc);	
			log.debug("pstmt created");
			pstmt.setInt(1, accountNumber);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, password);
			pstmt.setInt(5, checkingID);
			pstmt.setInt(6, savingID);
			pstmt.setDouble(7, initialChecking);
			pstmt.setDouble(8, initialSaving);
			pstmt.setObject(9, dob);
			
			//Setting the PreparedStatment for the initial checking account deposit			
			String strChecking="INSERT INTO ROC_Banking.trasactions (accountID, trasancitonAmount, trasancitonType)"
					+"VALUES(?, ?, ?)";
			PreparedStatement pstmtChecking=connection.prepareStatement(strChecking);	
			log.debug("pstmtChecking created");
			pstmtChecking.setInt(1, checkingID);
			pstmtChecking.setDouble(2, initialChecking);
			pstmtChecking.setString(3, "Initial Deposit");
			
			
			//Setting the PreparedStatment for the initial savings account deposit
			String strSaving="INSERT INTO ROC_Banking.trasactions (accountID, trasancitonAmount, trasancitonType)"
						+"VALUES(?, ?, ?)";
			PreparedStatement pstmtSavking=connection.prepareStatement(strSaving);	
			log.debug("pstmtSavking created");
			pstmtSavking.setInt(1, savingID);
			pstmtSavking.setDouble(2, initialSaving);
			pstmtSavking.setString(3, "Initial Deposit");
			
			//Executing the calls to SQL
			log.debug("account creationg executing");
			
			tempResult=pstmt.executeUpdate();
			result=Math.min(result, tempResult);
			
			tempResult=pstmtChecking.executeUpdate();
			result=Math.min(result, tempResult);
			
			tempResult=pstmtSavking.executeUpdate();
			result=Math.min(result, tempResult);
			log.debug("result of account creation: "+result);
			
			//If any of the calls to SQL return a 0 for failure, rollback the calls
			if (result==1) {
				log.debug("commited");
				connection.commit();
			}else {
				log.debug("rolledback");
				connection.rollback();
			}
			
			
		} catch (IOException | SQLException e) {
			log.debug("Something went wrong with establishing a connection");
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		} 
		
		return(result);
	}

	@Override
	public String getPassword(int accountNumber) throws DatabaseConnectionException {
		//Getting the customer password
		
		String password;
		
		try(Connection connection=ConnectionUtil.getConnection()){
	
			//Setting the PreparedStatment
			String getAccNum="SELECT customerPassword FROM ROC_Banking.customer WHERE accountNumber=?";
			PreparedStatement pstmt=connection.prepareStatement(getAccNum);		
			pstmt.setInt(1, accountNumber);
				
			//Executing the call to SQL
			log.debug("about to execute Query for account: "+accountNumber);
			ResultSet pswd=pstmt.executeQuery();
			log.debug("Query executed");
			
			
			//Retrieving the password from the call to SQL 
			if(pswd.next()){
				log.debug("pswd.next()");
				password=pswd.getString(1);
				//log.debug("password: "+password);
			}else {
				password=null;
			}
		
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		} 

		return(password);
	}

	@Override
	public List<CustomerAccount> getAccountInfo(String searchBy, String name) throws DatabaseConnectionException, AccountNotFoundException{
		//Search for customer by first or last name
		
		List<CustomerAccount> result=new ArrayList<>(); //=new CustomerAccount();
		
		try(Connection connection=ConnectionUtil.getConnection()){
			//Setting the PreparedStatment
			String getAccount="SELECT * FROM ROC_Banking.customer WHERE "+searchBy+" = ?";
			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
			pstmt.setString(1, name);
			
			//Executing the call to SQL
			log.debug(pstmt);
			ResultSet account=pstmt.executeQuery();
			
			//Retrieving the customer(s) from the call to SQL and placing it into list of customers
			while (account.next()) {
				CustomerAccount tempResult= new CustomerAccount();
				tempResult.setAccountNumber(account.getInt("accountNumber"));
				tempResult.setFirstName(account.getString("firstName"));
				tempResult.setLastName(account.getString("lastName"));
				tempResult.setCheckingID(account.getInt("checkingID"));
				tempResult.setSavingsID(account.getInt("savnigsID"));
				tempResult.setCheckingBalance(account.getDouble("checkingBalance"));
				tempResult.setSavingBalance(account.getDouble("savingBalance"));
				tempResult.setDob(account.getObject("DOB", LocalDate.class));;
				result.add(tempResult);
			}
		
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		}  
		
		return(result);
	}
	
	@Override
	public CustomerAccount getAccountInfo(String searchBy, int accountNum) throws DatabaseConnectionException, AccountNotFoundException{
		//Get customer account by account number, checking account number or savings account number
		
		CustomerAccount result=new CustomerAccount();
		
		try(Connection connection=ConnectionUtil.getConnection()){
			
			//Setting the PreparedStatment
			String getAccount="SELECT * FROM ROC_Banking.customer WHERE "+searchBy+" = ?";
			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
			pstmt.setInt(1, accountNum);
			
			//Executing the call to SQL
			log.debug("about to execute Query for account: "+accountNum);
			ResultSet account=pstmt.executeQuery();
			log.debug("Query executed");
			
			//Retrieving the customer information from the call to SQL 
			if (account.next()) {
				result.setAccountNumber(account.getInt("accountNumber"));
				result.setFirstName(account.getString("firstName"));
				result.setLastName(account.getString("lastName"));
				result.setCheckingID(account.getInt("checkingID"));
				result.setSavingsID(account.getInt("savnigsID"));
				result.setCheckingBalance(account.getDouble("checkingBalance"));
				result.setSavingBalance(account.getDouble("savingBalance"));
				result.setDob(account.getObject("DOB", LocalDate.class));

			}else {
				throw new AccountNotFoundException("No account was found with "+searchBy+" "+accountNum);
			}
		
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		} 

		return(result);
	}

	
	@Override
	public List<CustomerTransaction> getTransactionsInfo(int accountNum) throws DatabaseConnectionException{
		//Getting the list of transactions for a given account
		
		List<CustomerTransaction> result=new ArrayList<>(); //=new CustomerAccount();
		
		try(Connection connection=ConnectionUtil.getConnection()){
			
			//Setting the PreparedStatement
			String getAccount="SELECT * FROM ROC_Banking.trasactions WHERE accountID = ?";
			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
			pstmt.setInt(1, accountNum);

			//Executing the call to SQL
			log.debug(pstmt);
			ResultSet account=pstmt.executeQuery();
			log.debug("Query executed");
			
			
			//Retrieving the transactions from the call to SQL and placing them into a list
			while (account.next()) {
				CustomerTransaction tempResult= new CustomerTransaction();
				tempResult.setAccountID(account.getInt("accountID"));
				tempResult.setAmount(account.getInt("trasancitonAmount"));
				tempResult.setTrasancitonType(account.getString("trasancitonType"));
				tempResult.setTrasanciontPartner(account.getInt("trasanciontPartner"));
				tempResult.setDateCreated(account.getObject("dateCreated", LocalDate.class));
				tempResult.setTimeCreated(account.getObject("timeCreated", LocalTime.class));
								
				result.add(tempResult);
			}
		
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		}  
		
		return(result);
	}

	
	public int exchangeMoney(int accountNumber, int otherAccountNumber, double amount) {
		//Money exchanged between two accounts
		
		
		try(Connection connection=ConnectionUtil.getConnection()){
			connection.setAutoCommit(false);
			double currentDeposit=0;
			double currentWithdraw=0;
			double newDeposit=0;
			double newWithdraw=0;

			
			//Setting the transaction's table PreparedStatement for the depositor
			String deposit="INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)"
					+"VALUES(?, ?, ?, ?)";
			PreparedStatement pstmtDeposit=connection.prepareStatement(deposit);	
			pstmtDeposit.setInt(1, accountNumber);
			pstmtDeposit.setDouble(2, amount);
			pstmtDeposit.setString(3, "Deposit");
			pstmtDeposit.setInt(4, otherAccountNumber);
			
			//Setting the transaction's table PreparedStatement for the withdrawer 			
			String withdraw="INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)"
					+"VALUES(?, ?, ?, ?)";
			PreparedStatement pstmtWithdraw=connection.prepareStatement(withdraw);	
			pstmtWithdraw.setInt(1, otherAccountNumber);
			pstmtWithdraw.setDouble(2, amount);
			pstmtWithdraw.setString(3, "Withdraw");
			pstmtWithdraw.setInt(4, accountNumber);
			
			//Getting the amount the depositor's account will be set to
			if (accountNumber%10==1 || accountNumber%10==2) {
				String getDeposit="";
				if (accountNumber%10==1) {
					getDeposit="SELECT checkingBalance FROM roc_banking.customer WHERE checkingID=?";
				}else if(accountNumber%10==2){
					getDeposit="SELECT savingBalance FROM roc_banking.customer WHERE savnigsID=?";				
				}
			
				PreparedStatement pstmt=connection.prepareStatement(getDeposit);		
				pstmt.setInt(1, accountNumber);
				ResultSet resultCurrentDeposit=pstmt.executeQuery();
				resultCurrentDeposit.next();
				currentDeposit=resultCurrentDeposit.getDouble(1);
				newDeposit=currentDeposit+amount;
			}

			//Getting the amount the withdrawer's account will be set to
			if (otherAccountNumber%10==1 || otherAccountNumber%10==2) {
				String getWithdaw="";
				if (otherAccountNumber%10==1) {
					getWithdaw="SELECT checkingBalance FROM roc_banking.customer WHERE checkingID=?";
				}else if(otherAccountNumber%10==2){
					getWithdaw="SELECT savingBalance FROM roc_banking.customer WHERE savnigsID=?";				
				}
			
				PreparedStatement pstmt=connection.prepareStatement(getWithdaw);		
				pstmt.setInt(1, otherAccountNumber);
				ResultSet resultCurrentWithdraw=pstmt.executeQuery();
				resultCurrentWithdraw.next();
				currentWithdraw=resultCurrentWithdraw.getDouble(1);
				newWithdraw=currentWithdraw-amount;
			}

			int tempResult;
			int result=1;

			//Setting and executing the customer's table PreparedStatement for the depositor			
			if (accountNumber%10==1 || accountNumber%10==2) {
				String updateDeposit="";
				if (accountNumber%10==1) {
					updateDeposit="UPDATE ROC_Banking.customer SET checkingBalance =? WHERE checkingid=?";
				}else if(accountNumber%10==2){
					updateDeposit="UPDATE ROC_Banking.customer SET savingBalance =? WHERE savnigsID=?";				
				}
			
				PreparedStatement pstmt=connection.prepareStatement(updateDeposit);		
				pstmt.setDouble(1, newDeposit);
				pstmt.setInt(2, accountNumber);
				tempResult=pstmt.executeUpdate();
				result=Math.min(result, tempResult);
				
			}
			
			//Setting and executing the customer's table PreparedStatement for the withdrawer 						
			if (otherAccountNumber%10==1 || otherAccountNumber%10==2) {
				String updateWithdraw="";
				if (otherAccountNumber%10==1) {
					updateWithdraw="UPDATE ROC_Banking.customer SET checkingBalance =? WHERE checkingid=?";
				}else if(otherAccountNumber%10==2){
					updateWithdraw="UPDATE ROC_Banking.customer SET savingBalance =? WHERE savnigsID=?";				
				}
			
				PreparedStatement pstmt=connection.prepareStatement(updateWithdraw);		
				pstmt.setDouble(1, newWithdraw);
				pstmt.setInt(2, otherAccountNumber);
				tempResult=pstmt.executeUpdate();
				result=Math.min(result, tempResult);
			}
			
			//executing the depositor's transaction call to SQL
			if (accountNumber!=0) {
			tempResult=pstmtDeposit.executeUpdate();
			result=Math.min(result, tempResult);
			}

			//executing the withdrawer's transaction call to SQL
			if (otherAccountNumber!=0) {
			tempResult=pstmtWithdraw.executeUpdate();
			result=Math.min(result, tempResult);
			}
			
			//If any of the calls to SQL return a 0 for failure, rollback the calls
			log.debug("result: "+result);
			if (result==1) {
				log.debug("commited");
				connection.commit();
			}else {
				log.debug("rolledback");
				connection.rollback();
			}

			return(result);
			
		} catch (IOException | SQLException e) {
			//throw new DatabaseConnectionException("Something went wrong with establishing a connection");
			e.getMessage();
		}
		
		//System.out.println("broke out of try");
		return(0);
	}
	
}