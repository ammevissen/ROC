package com.revature;

//extends object implicitly
public class Animal{
	public Animal() {
		super();
		System.out.println("Calling Animal Constuctor");
	}
	
	public Animal(int numOfLegs) {
		this();
		this.numOfLegs=numOfLegs;
		System.out.println("Calling Animal Constuctor with num of legs: "+ this.numOfLegs);
	}
	
	public int numOfLegs;
	
	public void makeNoises() {
		System.out.println("animal making generic noises");
	}
}
