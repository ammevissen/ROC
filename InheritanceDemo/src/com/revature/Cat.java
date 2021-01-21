package com.revature;

public class Cat extends Animal{
	public String name;
	public String eyeColor;
	public String favoriteFood;
	
	public Cat() {
		super(4);
	}
	
	public Cat(String name) {
		this();
		this.name=name;
		System.out.println(name);
	}
	
	public Cat(String name, String eyeColor) {
		this(name); //Constructor chaining (chaining together overloaded constructors)
		this.eyeColor=eyeColor;
		System.out.println(name+" "+eyeColor);
	}
	
	public Cat(String name, String eyeColor, String favoriteFood) {
		this(name, eyeColor); //Constructor chaining (chaining together overloaded constructors)
		this.favoriteFood=favoriteFood;
		System.out.println(name+" "+eyeColor+" "+favoriteFood);
	}
	
	public void catchMice() {
		System.out.println(this.name + "is catching mice");
	}
	
}
