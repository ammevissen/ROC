package com.revature.demo;

public class VarargsDriver {

	//Var args are defined by the data type followed by ....
	//the parameter is implicity an array of that data type
	//Here I can actually change String[] args to String ... args
	public static void main(String... args) {
		
		int[] myIntArray= {9, 8, 7, 6, 5};
		
		display("John", 1,2,3,4,5,6,7,10, 50, 70, 20);
		display("Mary", new int[] {1,2,4});
		display("Bill");
		display("Bob", myIntArray);
		
		
		//Precdence
		//if we have a more specific non-varags method, it will be used over the varargs method
		
		sayHi("Bill", "Bob");
		
		System.out.println(add(10, 20, 30, 40, 1232, 3343));
		System.out.println(add(1, 2, 1, 3));		
	}
	//The ... refers to varargs (aka variable arguments)
	//the varags parameter should go last
	public static void display(String strValue, int ... numbers) {
		System.out.println("number is an int array: "+(numbers instanceof int[]));
		
		System.out.println(strValue);
		
		//enhance for loop;
		for (int val : numbers) {
			System.out.println(val);
		}
	}
	
	public static void sayHi(String name, String name2) {
		System.out.println("2 parameter method called");
		System.out.println("Hi, "+name);
		System.out.println("Hi, "+name2);
	}
	
	public static void sayHi(String ... names) {
		for (String name:names) {
			System.out.println("Hi, "+name);
		}
	}
	
	public static int add(int ... numbers) {
		int sum=0;
		for (int i: numbers) {
			sum+=i;
		}
		return(sum);
	}
}
