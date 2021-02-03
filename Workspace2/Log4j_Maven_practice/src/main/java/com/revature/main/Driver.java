package com.revature.main;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Driver {

	private static Logger log=Logger.getLogger(Driver.class);
	private static Scanner sc=new Scanner(System.in);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("Hello from Info");
		log.debug("Hello from Debug");

		String inpt;
		
		inpt=sc.nextLine();
		log.debug(inpt);
		log.info("End");
			
		
	}

}
