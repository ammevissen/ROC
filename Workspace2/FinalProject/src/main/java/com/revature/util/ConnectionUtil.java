package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ConnectionUtil {

	
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() throws IOException, SQLException{
		
		DriverManager.registerDriver(new Driver());
		String url="jdbc:postgresql://localhost:5433/postgres";
		String username="postgres";
		String password="2005Twins";
			
		Connection connection=DriverManager.getConnection(url, username, password);
		//System.out.println("connected: "+connection);
		return connection;
	}

	
}
