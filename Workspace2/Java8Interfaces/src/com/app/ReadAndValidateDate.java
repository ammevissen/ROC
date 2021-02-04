package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadAndValidateDate {

	public static void main(String[] args) {
		
		String s="12.10.2000"; //dd.MM.yyyy
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
		sdf.setLenient(false);//prevents a date that can't exist
		
		Date d=null;
		
		try {
			d=sdf.parse(s); //parses String and converts/parses it to date objce
			System.out.println("Date object is "+d);
		}catch (ParseException e) {
			System.out.println("Invalid Date");
		}
		
		s="30.02.2000"; //dd.MM.yyyy

		try {
			d=sdf.parse(s); //parses String and converts/parses it to date objce
			System.out.println("Date object is "+d);
		}catch (ParseException e) {
			System.out.println("Invalid Date");
		}

		
	}


}
