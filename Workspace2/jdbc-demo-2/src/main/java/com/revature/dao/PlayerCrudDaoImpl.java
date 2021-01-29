package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.DatabaseConnectivityException;
import com.revature.exceptions.PlayerNotFoundException;
import com.revature.model.Player;
import com.revature.util.ConnectionUtil;

public class PlayerCrudDaoImpl implements PlayerCrudDao{

	@Override
	public int createPlayer(Player player) throws DatabaseConnectivityException {
		int createCount = 0;
		// Try with resources..
		// After it is done executing it will automatically close the resource
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO jdbc_demo_1.player (player_name, player_position, gender, age, phone_number, team_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, player.getPlayerName());
			preparedStatement.setString(2, player.getPlayerPosition());
			preparedStatement.setString(3, player.getGender());
			preparedStatement.setInt(4, player.getAge());
			preparedStatement.setString(5, player.getPhoneNumber());
			preparedStatement.setInt(6, player.getTeamId());
			
			createCount = preparedStatement.executeUpdate();
			
		} catch (IOException | SQLException e) {
			throw new DatabaseConnectivityException("Something went wrong with establishing a connection");
		} 
		
		return createCount;
	}

	@Override
	public Player getPlayerById(int id) throws PlayerNotFoundException, DatabaseConnectivityException{
		Player player=null;
		try(Connection connection=ConnectionUtil.getConnection()){
			String sql="Select * From jdbc_demo_1.player WHERE id=?";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if (rs.next()) {
				player=new Player();
				player.setId(rs.getInt("id"));
				player.setPlayerName(rs.getString("player_name"));
				player.setPlayerPosition(rs.getString("player_position"));
				player.setGender(rs.getString("gender"));
				player.setAge(rs.getInt("age"));
				player.setPhoneNumber(rs.getString("phone_number"));
				player.setTeamId(rs.getInt("team_id"));
			}else {
				throw new PlayerNotFoundException("No player was found with id"+id);
				
			}
			
			
		}catch (IOException | SQLException e) {
			System.out.println("Something went wrong with the connection");
			e.printStackTrace();
		}
		return(player);
	}

	@Override
	public int updatePlayerPhonenumber(int id, String phoneNumber) throws PlayerNotFoundException, DatabaseConnectivityException{
		PlayerCrudDao PCD=new PlayerCrudDaoImpl();
		
		//https://www.postgresqltutorial.com/postgresql-update/
		try(Connection connection=ConnectionUtil.getConnection()){
			Player player=PCD.getPlayerById(id);
			if (!player.getPhoneNumber().equals(phoneNumber)){
				//String sql = "UPDATE jdbc_demo_1.player SET phone_number= "+phoneNumber+" WHERE id="+id;
				String sql = "UPDATE jdbc_demo_1.player SET phone_number=? WHERE id=?";
				
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, phoneNumber);
				preparedStatement.setInt(2, id);

				preparedStatement.executeUpdate();
		
				}
			}
			catch (IOException | SQLException e) {
				System.out.println("Something went wrong with the connection");
				e.printStackTrace();
			}
		
		
		return 1;
	}

	@Override
	public boolean deletePlayerById(int id) throws DatabaseConnectivityException{
		
		int success=0;
		try(Connection connection=ConnectionUtil.getConnection()){
		
			
			String sql = "DELETE FROM jdbc_demo_1.player WHERE id=?";
				
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				success=preparedStatement.executeUpdate();
		
			}
			catch (IOException | SQLException e) {
				System.out.println("Something went wrong with the connection");
				e.printStackTrace();
			}
		if (success==1) {
			return true;
		}else{
			return(false);
		}
	}

	@Override
	public List<Player>getAllPlayers() throws DatabaseConnectivityException{
		List<Player> playerList=new ArrayList<>();
		
		try(Connection connection=ConnectionUtil.getConnection()){
			String sql="Select * FROM jdbc_demo_1.player";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while (rs.next()) {
				Player player=new Player();
				player.setId(rs.getInt("id"));
				player.setPlayerName(rs.getString("player_name"));
				player.setPlayerPosition(rs.getString("player_position"));
				player.setGender(rs.getString("gender"));
				player.setAge(rs.getInt("age"));
				player.setPhoneNumber(rs.getString("phone_number"));
				player.setTeamId(rs.getInt("team_id"));
				
				playerList.add(player);
			}
			
		
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			throw new DatabaseConnectivityException("Something went wrong with the connection");
			
		}
		return playerList;
	}

}
