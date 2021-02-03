package com.log4j.dem.service;

import org.apache.log4j.Logger;
//import com.log4j.dem.Main;


public class MyService {

	private static Logger log=Logger.getLogger(MyService.class);
	
	
	public void iAmServiceMethod1(String username) {
		
		log.info("hello from iAmServiceMethod1");
		log.debug("User info was entered is"+username);
		log.info("bye from iAmServiceMethod1");
		
	}
	
}
