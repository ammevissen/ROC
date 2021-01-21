package com.revature.app;

public class CalculatorApplication {

	public static void main(String[] args) {
		//instantiate a Calculator object.  The addess to that object is stored in the calculator variable
		Calculator calculator=new Calculator();
		
		//Objects have state and behavior, which I can utilize
		System.out.println(calculator.name);
		System.out.println(calculator.add(10, 20));
		System.out.println(calculator.subtract(20, 10));
		

	}

}
