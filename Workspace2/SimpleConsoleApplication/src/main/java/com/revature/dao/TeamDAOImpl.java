package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.exceptions.DatabaseConnectionException;
import com.revature.models.Team;
import com.revature.util.ConnectionUtil;


public class TeamDAOImpl implements TeamDAO{

	public Connection connection;
	
	public TeamDAOImpl(Connection connection) {
		this.connection=connection;
	}
	
	
	@Override
	public int createTeam(Team team) {
		
		int count=0;
		
		try(Connection connection=ConnectionUtil.getConnection()){
			//Autocommit is on be default, but I can turn it off
			connection.setAutoCommit(false);
			
			String sql="INSERT INTO jdbc_demo_1.team (team_name) VALUES(?)";
			
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, team.getTeamName());
			
			count=pstmt.executeUpdate();
			
		}catch (SQLException | DatabaseConnectionException e) {
			System.out.println(e.getMessage());
		}
		
		return count;
		
		
		
		
		
		
	}
	
}
