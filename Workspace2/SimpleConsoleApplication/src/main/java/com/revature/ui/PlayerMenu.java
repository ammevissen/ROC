package com.revature.ui;

import java.util.Scanner;
import com.revature.services.*;

public class PlayerMenu implements Menu{

	public PlayerService playerService;
	
	public PlayerMenu() {
		playerService = new PlayerService();
	}
	
	@Override
	public void display() {
		int choice =0;
		do {
			System.out.println("MAIN MENU");
			System.out.println("=======");
			System.out.println("1.) Back to Main Menu");
			System.out.println("2.) Search for player by Id");
			System.out.println("Enter a choice between 1 and 2");
			
			try {
				choice=Integer.parseInt(Menu.sc.nextLine());
			}catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				int id=getPlayerByIdInput();
				//playerService.getPlayerById(id);
				System.out.println("....getting player: "+id);
			default:
				System.out.println("No valid choice entered, please enter a valid input");
			}
			
		}while (choice!=1);
		
		
		System.out.println("exiting Player Menu");

		
	}
	
	public int getPlayerByIdInput() {
		int id;
		while (true) {
			try {
			System.out.println("Enter the id of the player you would like to look up");
			id=Integer.parseInt(Menu.sc.nextLine());
			}catch (NumberFormatException e){
				System.out.println("Invalid input, please try again");
				continue;
			}
			break;
		}
		return(id);
	}

}
