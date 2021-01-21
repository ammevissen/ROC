package com.revature.demo;

public class ControlDriver {

	public static void main(String[] args) {
		//If statement
		int num=100;
		
		if (num<200) {
			System.out.println("num is less than 200, it is "+num);
		}
		
		//if-else statement
		if (num<100) {
			System.out.println("num is less than 100, it is "+num);
		}else {
			System.out.println("num is not less than 100, it is "+num);
		}
		
		//Chaining if-else statements, (else if) structure
		//The first condition that is true will be the block of code to run (and only that block)
		int age=23;
		if (age<18) {
			System.out.println("You are minor");
		}else if(age<40){
			System.out.println("you are a young adult");
		}else if (age<65) {
			System.out.println("you are a middle age adult");
		}else {
			System.out.println("You are 65 or older");
		}

		
		//Nested if statement
		if (num<101) {
			System.out.println("The variable num is less than 101");
			if (num%2==0) {
				System.out.println("The variable num is even");
			}else {
				System.out.println("The variable num is odd");
			}
		}
		
		
		//Switch statements
		//Works with byte, char, int, enum, String, and "primitive wrapper classes"
		int month=2;
		switch(month) {
			case 1:
				System.out.println("It is Jan");
				break;
			case 2:
				System.out.println("It is Feb");
				break;
			case 3:
				System.out.println("It is Mar");
				break;
			case 4:
				System.out.println("It is April");
				break;
			default: 
				System.out.println("It is not Jan, Feb, Mar, or April");
		}
		
		//Looping statements
		//for loop
		for (int i=0; i<5 ;i++) {
			System.out.println("the vale of i: " + i);

			//if want to exit loop can do:
			if (i==100) {
				break;
			}
		}
		System.out.println("Done with loop");

		int j=-1000;
		for (j=0; j<5 ;j++) {
			System.out.println("the vale of j: " + j);

			//if want to exit loop can do:
			if (j==100) {
				break;
			}
		}
		
		System.out.println("the vale of j: " + j);
		for (int i=5; i>0 ;i--) {
			System.out.println("the vale of i: " + i);

			//if want to exit loop can do:
			if (i==-100) {
				break;
			}
		}
		
		//while loop
		int number=100;
		while (number>0) {
			System.out.println("The value of number is: "+number);
			number--;
		}
		
		//Do-while loop
		//always occures at least once
		number=0;
		System.out.println("do while");
		do {
			System.out.println("The value of number is: "+number);
			number--;
		}while (number>0);
		System.out.println("The value of number is: "+number);

		//break, continue
		for (int i=1; i<10; i++) {
			if (i%5==0) {
				break;
			}
			System.out.println("i: "+i);
		}
		for (int i=1; i<10; i++) {
			if (i%5==0) {
				continue;
			}
			System.out.println("i: "+i);
		}
		
		//print out all even numbers 1 to 100
		for (int i=1; i<=100; i++) {
			if (i%2!=0) {
				continue;
			}
			System.out.println("i: "+i );
		}
		
		//labels:
		helloLabel:
			for (int i=0; i<10; i++) {
				for (int k=0; k<10; k++) {
					if (k==5) {
						break helloLabel;
					}
					System.out.println("i: "+i+", k: " +k);
				}
			}
	}
	
}
