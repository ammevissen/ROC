package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import com.revature.util.ConnectionUtil;
import com.revature.exceptions.DatabaseConnectionException;


public class CustomerDAOImpl implements CustomerDAO {

	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public int CreateCustomerAccount(String firstName, String lastName, String password, double initialChecking, double initialSaving) throws DatabaseConnectionException{
		int result=0;
		int accountNumber;
		int checkingID;
		int savingID;
		//double checkingBalance=0.0;
		//double savingBalance=0.0;
		
		
		try(Connection connection=ConnectionUtil.getConnection()){
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
			String acc="INSERT INTO ROC_Banking.customer (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID, checkingBalance, savingBalance)"
						+"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
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
			
			log.debug("account creationg executing");
			result=pstmt.executeUpdate();
			log.debug("result of account creation: "+result);
			
		} catch (IOException | SQLException e) {
			log.debug("Something went wrong with establishing a connection");
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		} 
		
		return(result);
	}

	
}