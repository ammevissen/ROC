package com.revature;

public class Dog extends Animal {//You cannot extend multiple classes

	public String name;
	
	//default constructor, provided if no other constructors present, 
	public Dog() {
		super();
	}
	
	public Dog(String name) {
		//super() //There is an invisible super 
		this.name=name;
	}
	
	
	
	
	public void playFetch() {
		System.out.println(name+" is playing fetch!");
		
	}
	
	
	
	
}
