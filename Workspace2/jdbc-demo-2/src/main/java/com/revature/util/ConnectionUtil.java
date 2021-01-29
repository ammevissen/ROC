package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class ConnectionUtil {

		//Making private because we never want this class to be instantiated
		//This will be a utility class, which will only contain static methods
		private ConnectionUtil() {
			super();
		}
		
		public static Connection getConnection() throws IOException, SQLException{
			
			DriverManager.registerDriver(new Driver());
			String url="jdbc:postgresql://localhost:5433/postgres";
			String username="postgres";
			String password="2005Twins";
			
			/*
			 * using a properties file
			 */
		
//			FileInputStream fis = new FileInputStream("src/main/resources/Connection.properties");
//			Properties p=new Properties();
//			p.load(fis);
//			
//			String url=(String) p.getProperty("url");
//			String username=(String) p.getProperty("username");
//			String password=(String) p.getProperty("password");
//					
			Connection connection=DriverManager.getConnection(url, username, password);
			System.out.println("connected: "+connection);
			return connection;
		}
	
}
