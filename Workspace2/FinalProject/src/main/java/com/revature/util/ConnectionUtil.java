package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	private static Logger log=Logger.getLogger(ConnectionUtil.class);

	
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() throws IOException, SQLException{
		
		DriverManager.registerDriver(new Driver());
		String url="jdbc:postgresql://localhost:5433/postgres"; //on my system the local host is 5433
		String username="postgres";
		String password="2005Twins";
			
		Connection connection=DriverManager.getConnection(url, username, password);
		log.debug("connected: "+connection);
		//System.out.println("connected: "+connection);
		return connection;
	}

	
}
