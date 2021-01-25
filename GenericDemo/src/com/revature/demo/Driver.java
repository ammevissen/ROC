package com.revature.demo;

public class Driver {

	public static void main(String[] args) {
		CustomWrapper<Dog> customWrapper=new CustomWrapper<>();
		customWrapper.setValue(new Dog("Sparky"));
		
		System.out.println(customWrapper.getValue());
		System.out.println(customWrapper);
		
	}

}
