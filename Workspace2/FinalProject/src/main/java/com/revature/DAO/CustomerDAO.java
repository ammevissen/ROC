package com.revature.DAO;

import com.revature.exceptions.DatabaseConnectionException;
//import org.apache.log4j.Logger;


public interface CustomerDAO {

	//private static Logger log=Logger.getLogger(CustomerDAO.class);

	public int CreateCustomerAccount(String firstName, String lastName, String password, double initialChecking, double initialSaving) throws DatabaseConnectionException;
	
	
	
	
}
