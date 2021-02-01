package com.revature.dao;

import com.revature.models.Player;


public interface PlayerDAO {

	public Player getPlayerById(int Id);
	public Player getPlayerByPhoneNumber(String phoneNumber);
	
}
