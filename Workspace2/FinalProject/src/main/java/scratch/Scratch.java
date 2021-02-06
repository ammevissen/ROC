package scratch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.DAO.CustomerDAOImpl;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.CustomerAccount;
import com.revature.model.CustomerTransaction;
import com.revature.ui.MenuSystem;
import com.revature.util.ConnectionUtil;

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
		
		int accountNum=31;
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
				
				
				result.add(tempResult);
			}
		
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		}  

		
		for (CustomerTransaction account: result) {
			log.info(account);
		}
	}

}
