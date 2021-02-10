package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.ui.MenuSystem;

public class GetName {

	private static Logger log=Logger.getLogger(GetName.class);

	
	
	public static String getName(String message) {;
		//asks the user for a name
	
		log.info(message);
		String name=MenuSystem.sc.nextLine();
		log.debug("last name: "+name);
		return(name);
	}
}
