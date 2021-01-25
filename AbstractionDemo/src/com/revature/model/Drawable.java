package com.revature.model;

public interface Drawable {

	//interfaces can only have abstract methods;
	
	void draw();//abstract keyword is added implicitly
	//all methods in an interface will also be public
	
	//We can have variables inside interfaces, but they will be implicitly 'public static final'
	int testInt=1;//this is a public static final int
	
	//in Java 8, the "default" keyword was added (not to be confused with the default access modifier)
	//The default keyword allows us to provide an implementation of a method in the interface itself
	//Previously, all methods had to be abstract (with no implementation)
	
	//This is mainly for backwards compatibility.  The need arose because, if a lot of developers were using an interface, 
	//and the developer of the interface wanted to add more abstract methods, this would basically break the other classes
	//people already wrote
	
	public default void myNewMethod() {
		System.out.println("This is the default method");
	}
	
	//interfaces can also contain static methods
	//static methods, just like in classes, are not inherited
	//
	
	
	
	
}
