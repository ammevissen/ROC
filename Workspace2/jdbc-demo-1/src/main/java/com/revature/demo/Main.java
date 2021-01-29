package com.revature.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class Main {

	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			//step 1 load the driver
			DriverManager.registerDriver(new Driver());
			System.out.println("Driver Loaded Successfully");
		
			//Provide a connection string, username and password
			String url="jdbc:postgresql://localhost:5433/postgres";
			
			//usually don't hardcode username and password into the code itself
			//if pushed to Github (or similar)....then your credentials are essentially leaked
			//for everyone to see
			//And if your database were accessible over the internet, then anyone could just connect to it
			//and that would be bad
			String username="postgres";
			String password="2005Twins";
			//So instead we can uses either a properties file that contains our credentials that the application would look up
			//or we could use environment variables (from edit system environment variables)
			//String url=System.getenv("db_url");
			//String username=System.getenv("db_username");
			//String password=System.getenv("db_password");
			
			//Step 2: Get a connection
			connection=DriverManager.getConnection(url, username, password);
			System.out.println("Successfully connected to the database");
			
			//Step 3: Create a Statement object (Statement is an interface)
			Statement stmt=connection.createStatement();
			String sql ="SELECT *"
					+ "FROM JDBC_DEMO_1.player;";
			
			//Step 4: execute the query
			ResultSet resultSet=stmt.executeQuery(sql);
			
			//resultSet iterates through the database, it does not contain the data itself
			//row_1, row_2......row_count 
			
			
			//Step 5: Process through results
			System.out.println("Successfully created result sets (4)");
			while (resultSet.next()) {
				System.out.println("ID: "+resultSet.getInt("ID"));
				System.out.println("ID: "+resultSet.getInt(1)); //because of course it is 1-based index (index 0 = val 1)
				System.out.println("ID: "+resultSet.getString("player_name"));
				System.out.println("ID: "+resultSet.getString("player_position"));
				System.out.println("ID: "+resultSet.getString("gender"));
				System.out.println("ID: "+resultSet.getInt("age"));
				System.out.println("ID: "+resultSet.getString("phone_number"));
				System.out.println("ID: "+resultSet.getInt("team_id"));
				System.out.println("__________________________________");
				
			}
			
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			
		}finally {
			try {
			connection.close();
			}catch (SQLException e) {
				System.out.println("failed to close");
			}
		}

	}

}
