package scratch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.DatabaseConnectionException;
import com.revature.util.ConnectionUtil;

import java.math.BigDecimal;

public class Scratch {

	public static void main(String[] args) throws DatabaseConnectionException {
		// TODO Auto-generated method stub
//		System.out.println((long)(Math.E*1000000000000000l));
//		System.out.println((long)(Math.PI*1000000000000000l));
		
		

		
		
		
		try(Connection connection=ConnectionUtil.getConnection()){

			String getAccNum="SELECT max(accountNumber) FROM ROC_Banking.customer";
			PreparedStatement stmt=connection.prepareStatement(getAccNum);		
			ResultSet maxAccNum=stmt.executeQuery();
			System.out.println(4);
			//if (maxAccNum.next()) {
			maxAccNum.next();
			System.out.println(maxAccNum.getInt(1));
			int accNum=maxAccNum.getInt(1)+1;
			//}
			
			String firstName="andy";
			String lastName="mev";
			String password="p@55w0rd";
			int checkingID=accNum*10+1;
			int savingID=accNum*10+2;
			double checkingBalance=0.0;
			double savingBalance=0.0;
			
			System.out.println("creating acc string");
			String acc="INSERT INTO ROC_Banking.customer (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID, checkingBalance, savingBalance)"
						+"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
//			String acc="INSERT INTO ROC_Banking.customer (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID)"
//					+"VALUES(?, ?, ?, ?, ?, ?)";
//		
			
			PreparedStatement pstmt=connection.prepareStatement(acc);	
			System.out.println("pstmt");
			pstmt.setInt(1, accNum);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, password);
			pstmt.setInt(5, checkingID);
			pstmt.setInt(6, savingID);
			pstmt.setDouble(7, checkingBalance);
			pstmt.setDouble(8, savingBalance);
			
			System.out.println("executing");
			int result=pstmt.executeUpdate();
			System.out.println("result: "+result);
			
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectionException("Something went wrong with establishing a connection");
		} 

	}

}
