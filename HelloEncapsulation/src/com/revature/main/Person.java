package com.revature.main;

public class Person {
	private String name;
	private int age;
	private String occupation;
	
	public Person() {
		super();
	}
	
	public Person(String name, int age, String occupation) {
		this.name=name;
		this.setAge(age);
		this.occupation=occupation;
	}
	
	//Getters (if only getters (no setters), read only class
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public String getOccupation() {
		return this.occupation;
	}
	
	//Setters
	public void setName(String name) {

		String firstLetter=name.substring(0, 1).toUpperCase();
		String restOfName=name.substring(1);
		this.name=firstLetter+restOfName;
	}
	
	public void setAge(int age) {
		if (age>=0 && age<=120) {
			this.age=age;
		}else {
			System.out.println("Age cannot be set to a number below zero or greater than 120");
		}
	}
	
	public void setOccupation(String occupation) {
		this.occupation=occupation;
	}
	
	
	
}
