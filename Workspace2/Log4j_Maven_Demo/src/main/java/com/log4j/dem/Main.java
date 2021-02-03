package com.log4j.dem;

import org.apache.log4j.Logger;
import com.log4j.dem.service.*;

public class Main {

	private static Logger log=Logger.getLogger(Main.class);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.trace("Hello from Trace");
		log.debug("Hello from Debug");
		log.info("Hello from Info");
		log.warn("Hello from Warn");
		log.error("Hello from Error");
		log.fatal("Hello from Fatal");

		
		MyService m=new MyService();
		m.iAmServiceMethod1("test Username");
		
	}

}
