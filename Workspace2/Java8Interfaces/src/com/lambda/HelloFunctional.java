package com.lambda;

@FunctionalInterface //one and only one abstract method
public interface HelloFunctional {

	void hello();
	
	
	
}

@FunctionalInterface
interface MyFunctional{
	String hey(String name);
	
}


@FunctionalInterface
interface Sum{
	int add(int a, int b, int c);
}
