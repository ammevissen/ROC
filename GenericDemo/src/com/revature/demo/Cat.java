package com.revature.demo;

public class Cat {
	private String name;

	public Cat() {
		super();
	}
	
	public Cat(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
