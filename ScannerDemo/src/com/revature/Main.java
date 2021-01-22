package com.revature;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in); //refers to standard input stream
		
		System.out.println("Enter your name, age, salary, and favorite color");
		//
		String name=scanner.nextLine();
		
		
		int age=Integer.parseInt(scanner.nextLine());
		double salary=Integer.parseInt(scanner.nextLine());

		//int age=scanner.nextInt();
		//double salary=scanner.nextDouble();
		
		//If you're transitioning from a number input to string input
		//you will want some sort of extra .nextLine()
		//scanner.nextLine();
		String color=scanner.nextLine();
		
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		System.out.println("salary: "+salary);
		System.out.println("color: "+color);

		
		

	}

}
