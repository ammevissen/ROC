package com.revature.model;

import com.revature.main.Person;

public class Application {

	public static void main(String[] args) {
		Person bill=new Person("Bill", 18, "Student");
		
		System.out.println("Name: "+ bill.getName());
		System.out.println("Name: "+ bill.getAge());
		System.out.println("Name: "+ bill.getOccupation());

		bill.setName("william");
		System.out.println("Name: "+ bill.getName());
		
	}

}
