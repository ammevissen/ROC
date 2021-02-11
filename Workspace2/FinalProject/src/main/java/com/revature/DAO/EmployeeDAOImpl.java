package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.exceptions.DatabaseConnectionException;
import com.revature.util.ConnectionUtil;


public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger log=Logger.getLogger(EmployeeDAOImpl.class);

	
	@Override
	public String getPassword(int accountNumber) throws DatabaseConnectionException {
		//Get employee password
		String password;
		
		try(Connection connection=ConnectionUtil.getConnection()){
	
			//Setting the PreparedStatment
			String getPassword="SELECT employeePassword FROM roc_banking.employee WHERE employeeNumber=?";
			PreparedStatement pstmt=connection.prepareStatement(getPassword);		
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
			log.debug("Connection Error");
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
			//return("");
		}

		return(password);
	}
	
}
