package com.revature;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

	
	private static Scanner scanner=new Scanner(System.in); //refers to standard input stream
	
	public static void main(String[] args) {
		
		ArrayList<Person> people=new ArrayList<>();
		String shouldContinue;
//		do {
//			System.out.println("Enter your name, age, salary, and favorite color");
//			String firstName=scanner.nextLine();
//			String lastName=scanner.nextLine();
//		
//			int age=Integer.parseInt(scanner.nextLine());
//			double salary=Integer.parseInt(scanner.nextLine());
//
//			//int age=scanner.nextInt();
//			//double salary=scanner.nextDouble();
//		
//			//If you're transitioning from a number input to string input
//			//you will want some sort of extra .nextLine()
//			//scanner.nextLine();
//			String color=scanner.nextLine();
//		
//			System.out.println("first name: "+firstName);
//			System.out.println("Last name: "+lastName);
//			System.out.println("age: "+age);
//			System.out.println("salary: "+salary);
//			System.out.println("color: "+color);
//
//			Person person=new Person(firstName, lastName, age, salary, color);
//			people.add(person);
//			
//			System.out.println("Should we keep going? (Y/y/N/n)");
//			shouldContinue=scanner.nextLine();
//			
//		}while (shouldContinue.equals("Y") ||shouldContinue.equals("y"));
//		
		//System.out.println(people);

		Object myObj=new Person("Andy", "Mev", 34,0,"blue");
		myObj.toString();
		Object myPerson=new Person("Andy", "Mev", 34,0,"blue");
		System.out.println(myObj==myPerson);
		System.out.println(myObj.equals(myPerson));
		System.out.println(myObj.hashCode());
		System.out.println(myPerson.hashCode());
		System.out.println(myObj);//automatically goes to toString method
		System.out.println(myPerson);//automatically goes to toString method
			
		//hashing intuition
		//%2 as function
		//10%2==0
		//12%2==0
		//11%2==1
		
		//infinite number of values %2==0 and %2==1, but 10!=12
		
		
	}

}
