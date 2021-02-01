package com.revature.ui;

import com.revature.services.TeamService;

public class TeamMenu implements Menu{

	public TeamService teamService;
	
	
	
	@Override
	public void display() {
		int choice=0;
		
		do {
			System.out.println("TEAM MENU");
			System.out.println("==========");
			System.out.println("1.) Back");
			System.out.println("2.) Create Team");
			System.out.println("Enter a choice between 1 and 2");

			try {
				choice=Integer.parseInt(Menu.sc.nextLine());
			}catch (NumberFormatException e){
				
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				
				
				break;
				
			default:
				System.out.println("No valid choice entered, pleast try again");
			}
			
		}while (choice!=1);
		
	}
	
	public String getCreateTeam() {
		
		System.out.println("Enter a team name");
		String teamName=Menu.sc.nextLine();
		
		return(teamName);
		
	}

}
