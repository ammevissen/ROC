package com.app;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d=new Date();
		System.out.println("date: "+d);
		
		/*
		 *Symbols are case sensitive
		 *dd - date
		 *MM - month in 2 digits MMM short name of month, MMMM - full month name
		 *EEE - day in short, EEEE full day name
		 *yy - last 2 digits of year, yyyy full year
		 *HH - 24 hr
		 *hh - 12 hr
		 *mm - minutes
		 *ss - seconds
		 *z/Z - time zones and GMT
		 *a - am/pm
		 *and there are more 
		 */
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss hh:mm:ss a z");
		System.out.println(sdf.format(d)); //this is a string
		

		
	}

}
