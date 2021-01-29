package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.PlayerCrudDao;
import com.revature.dao.PlayerCrudDaoImpl;
import com.revature.exceptions.DatabaseConnectivityException;
import com.revature.exceptions.PlayerNotFoundException;
import com.revature.model.Player;
import com.revature.util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
//		Connection connection=null;
//		
//		try {
//			connection=ConnectionUtil.getConnection();
//			System.out.println("connection commplete");
//			System.out.println("connection: "+connection);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Something went wrong with our properites file");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Something went wrong with getting our connection to the database");
//			e.printStackTrace();
//		}
//		
		
		//Player newPlayer = new Player(0, "Bobby", "SF", "Male", 25, "888-888-8888", 1);
//		Player newPlayer=new Player(0, "ted", "SF", "Male", 25, "999-999-9999", 1);
//		
//		PlayerCrudDao dao = new PlayerCrudDaoImpl();
//		try {
//			int count = dao.createPlayer(newPlayer);
//			System.out.println(count);
//		} catch (DatabaseConnectivityException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		
//		//Player player=new Player(0, "John", "C", "Male", 38, "777-777-7777", 0);
//		Player player=new Player(1, "ted", "SF", "Male", 25, "888-888-8888", 0);
//
//		//System.out.println(player);
//		
//		PlayerCrudDao doa=new PlayerCrudDaoImpl();
//		int count=0;
//		try {
//			count = doa.createPlayer(player);
//		} catch (DatabaseConnectivityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("count: "+count);
		
//		PlayerCrudDao doa=new PlayerCrudDaoImpl();
//		
//		try{
//			Player player=dao.getPlayerByID(1);
//			
//		}catch (PlayerNotFoundException e) {
//			System.out.println(e.message);
//		}
		
		PlayerCrudDao dao = new PlayerCrudDaoImpl();
//		try {
//			Player player = dao.getPlayerById(1);
//			System.out.println(player);
//			
//			List<Player> players = dao.getAllPlayers();
//			System.out.println(players);
//		} catch (PlayerNotFoundException | DatabaseConnectivityException e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			System.out.println(dao.updatePlayerPhonenumber(1, "123-456-7890")+" good");
//		} catch (PlayerNotFoundException | DatabaseConnectivityException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		try {
			System.out.println(dao.deletePlayerById(1));
		} catch (DatabaseConnectivityException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
