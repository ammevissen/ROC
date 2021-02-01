package com.revature.services;

import com.revature.dao.TeamDAO;
import com.revature.dao.TeamDAOImpl;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.models.Team;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;




public class TeamService {

	public TeamDAO teamDAO;
	public Connection connection;
	
	
	public TeamService() {
		try {
			connection=ConnectionUtil.getConnection();
			
		}catch (DatabaseConnectionException e) {
			System.out.println(e.getMessage());
		}
		teamDAO=new TeamDAOImpl();
	}
	
	
	public int createTeam(String teamName) {
		int count;
		
		try {
			connection.setAutoCommit(false);
			
			Team team=new Team(0, teamName);
			count=TeamDAO.createTeam(team);
			
		}catch( e){
		}
	}
	
	
	
}
