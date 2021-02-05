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
		String password;
		
		try(Connection connection=ConnectionUtil.getConnection()){
	
			String getPassword="SELECT employeePassword FROM ROC_Banking.employee WHERE employeeNumber=?";
			PreparedStatement pstmt=connection.prepareStatement(getPassword);		
			pstmt.setInt(1, accountNumber);
				
			ResultSet pswd=pstmt.executeQuery();
			pswd.next();
			password=pswd.getString(1);
		
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		} 

		return(password);
	}
	
}
