package com.revature.DAO;

import com.revature.exceptions.DatabaseConnectionException;

//import org.apache.log4j.Logger;


public interface EmployeeDAO {

	//private static Logger log=Logger.getLogger(EmployeeDAO.class);

	public String getPassword(int accountNumber) throws DatabaseConnectionException;
	
}
