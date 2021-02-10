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
import com.revature.model.CustomerTransactions;


public class CustomerDAOImpl implements CustomerDAO {

	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public int CreateCustomerAccount(String firstName, String lastName, String password, double initialChecking, double initialSaving, LocalDate dob) throws DatabaseConnectionException{
		int result=1;
		int tempResult;
		int accountNumber;
		int checkingID;
		int savingID;
		
		
		try(Connection connection=ConnectionUtil.getConnection()){
			connection.setAutoCommit(false);
			
			log.debug("getting max account number");
			String getAccNum="SELECT max(accountNumber) FROM ROC_Banking.customer";
			PreparedStatement stmt=connection.prepareStatement(getAccNum);		
			ResultSet maxAccNum=stmt.executeQuery();
			maxAccNum.next();
			
			accountNumber=maxAccNum.getInt(1)+1;
			log.debug("New Account Number: "+accountNumber);
			
			checkingID=accountNumber*10+1;
			savingID=accountNumber*10+2;
			
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
			
			
			String strChecking="INSERT INTO ROC_Banking.trasactions (accountID, trasancitonAmount, trasancitonType)"
					+"VALUES(?, ?, ?)";
			PreparedStatement pstmtChecking=connection.prepareStatement(strChecking);	
			log.debug("pstmtChecking created");
			pstmtChecking.setInt(1, checkingID);
			pstmtChecking.setDouble(2, initialChecking);
			pstmtChecking.setString(3, "Initial Deposit");
			
			

			String strSaving="INSERT INTO ROC_Banking.trasactions (accountID, trasancitonAmount, trasancitonType)"
						+"VALUES(?, ?, ?)";
			PreparedStatement pstmtSavking=connection.prepareStatement(strSaving);	
			log.debug("pstmtSavking created");
			pstmtSavking.setInt(1, savingID);
			pstmtSavking.setDouble(2, initialSaving);
			pstmtSavking.setString(3, "Initial Deposit");
			
			
			log.debug("account creationg executing");
			
			tempResult=pstmt.executeUpdate();
			result=Math.min(result, tempResult);
			
			tempResult=pstmtChecking.executeUpdate();
			result=Math.min(result, tempResult);
			
			tempResult=pstmtSavking.executeUpdate();
			result=Math.min(result, tempResult);
			log.debug("result of account creation: "+result);
			
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
		String password;
		
		try(Connection connection=ConnectionUtil.getConnection()){
	
			String getAccNum="SELECT customerPassword FROM ROC_Banking.customer WHERE accountNumber=?";
			PreparedStatement pstmt=connection.prepareStatement(getAccNum);		
			pstmt.setInt(1, accountNumber);
				
			ResultSet pswd=pstmt.executeQuery();
			pswd.next();
			password=pswd.getString(1);
		
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		} 

		return(password);
	}

	@Override
	public List<CustomerAccount> getAccountInfo(String searchBy, String name) throws DatabaseConnectionException, AccountNotFoundException{
		List<CustomerAccount> result=new ArrayList<>(); //=new CustomerAccount();
		
		try(Connection connection=ConnectionUtil.getConnection()){
			
			String getAccount="SELECT * FROM ROC_Banking.customer WHERE "+searchBy+" = ?";
			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
			pstmt.setString(1, name);

			
			log.debug(pstmt);
			ResultSet account=pstmt.executeQuery();
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
		CustomerAccount result=new CustomerAccount();
		
		try(Connection connection=ConnectionUtil.getConnection()){
			
			String getAccount="SELECT * FROM ROC_Banking.customer WHERE "+searchBy+" = ?";
			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
			pstmt.setInt(1, accountNum);
			
			ResultSet account=pstmt.executeQuery();
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
		
		List<CustomerTransaction> result=new ArrayList<>(); //=new CustomerAccount();
		
		try(Connection connection=ConnectionUtil.getConnection()){
			
			String getAccount="SELECT * FROM ROC_Banking.trasactions WHERE accountID = ?";
			PreparedStatement pstmt=connection.prepareStatement(getAccount);		
			pstmt.setInt(1, accountNum);

			
			log.debug(pstmt);
			ResultSet account=pstmt.executeQuery();
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
		
		try(Connection connection=ConnectionUtil.getConnection()){
			connection.setAutoCommit(false);
			//log.debug("getting max account number");
			String deposit="INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)"
					+"VALUES(?, ?, ?, ?)";
			PreparedStatement pstmtDeposit=connection.prepareStatement(deposit);	
			pstmtDeposit.setInt(1, accountNumber);
			pstmtDeposit.setDouble(2, amount);
			pstmtDeposit.setString(3, "Deposit");
			pstmtDeposit.setInt(4, otherAccountNumber);
			
			
			String withdraw="INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)"
					+"VALUES(?, ?, ?, ?)";
			PreparedStatement pstmtWithdraw=connection.prepareStatement(withdraw);	
			pstmtWithdraw.setInt(1, otherAccountNumber);
			pstmtWithdraw.setDouble(2, amount);
			pstmtWithdraw.setString(3, "Withdraw");
			pstmtWithdraw.setInt(4, accountNumber);
			
			
			double currentDeposit=0;
			double currentWithdraw=0;
			double newDeposit=0;
			double newWithdraw=0;
			
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
			
			
			if (accountNumber!=0) {
			tempResult=pstmtDeposit.executeUpdate();
			result=Math.min(result, tempResult);
			}
			
			if (otherAccountNumber!=0) {
			tempResult=pstmtWithdraw.executeUpdate();
			result=Math.min(result, tempResult);
			}
			

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