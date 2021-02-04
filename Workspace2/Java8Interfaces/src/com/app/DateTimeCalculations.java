package com.app;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//This is Java 8 Date and Time API
public class DateTimeCalculations {

	public static void main(String[] args) {
		LocalDate ld=LocalDate.now();
		System.out.println(ld);
		

		ld=ld.plusYears(7);
		System.out.println(ld);
		ld=ld.plusMonths(22);
		System.out.println(ld);
		
		//not Lenient by default
		LocalDate dob=LocalDate.parse("30/11/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(dob);
		
		
		LocalDate curr=LocalDate.now();
		System.out.println("curr: "+curr);
		
		Period p=Period.between(dob, curr);
		
		System.out.println("your age: " +p.getYears());
		System.out.println("you are  " +p.getYears()+" years "+p.getMonths()+ " months "+p.getDays()+" days old");

		System.out.println(ChronoUnit.DAYS.between(dob, curr));
		System.out.println(ChronoUnit.MONTHS.between(dob, curr));
		System.out.println(ChronoUnit.YEARS.between(dob, curr));
		
		
	}

	
	
}
