package com.revature.demo;

import com.revature.exceptions.*;
import java.util.Scanner;

public class ExceptionDriver {

	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
//		try {
//			method1();
//		}catch(RuntimeException e){
//			System.out.println("An unchecked exception, "+e.getClass()+" was caught");
//		}
		//method1();
		//while (true) {
			try {
				method1();
			}catch (DenominatorIsZeroException e) {
				System.out.println(e.getMessage());
			}catch(ArithmeticException e) {
				System.out.println("Please enter a non-zero denominator");
			}catch(NumberFormatException e) {
				System.out.println("please enter a valid number");
			}catch(RuntimeException e){
				System.out.println("Please enter a non-zero denominator");
				//System.out.println("An unchecked exception, "+e.getClass()+" was caught");
			}finally {
				//will always execute, whether an exception ws caught or not, or even if the method returns
				//in either the try or catch block
				//Only in extreme conditions does finally not execute, such as if the JVM exits early
				//Or if we are caught in an infinite loop
				System.out.println("This will always run");
				sc.close();//will free up the Scanner memory
			}
		//}
		System.out.println("program execution continued normally");
		//This runs into the debate over whether custom exceptions should be checked or unchecked
		//checked exceptions are clearly made visible to a developer who is using some methods that were coded by soeone eles
		//However, they will need to handle the exception
		
		//In the case of RuntimeExceptions, this forces you to go through and read documentation about what exceptions
		//might be thrown
		
		//So it is really a matter of your own preference
		
		
		
	}
	
	public static void method1() throws DenominatorIsZeroException{
		System.out.println("Enter the numerator: ");
		int numerator=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter the denominator: ");
		int denominator=Integer.parseInt(sc.nextLine());
		
		if (denominator==0) {
				throw new DenominatorIsZeroException("You cannot have a denominator of Zero!");
		}
		System.out.println(numerator/denominator);
		
		//System.out.println(10/0);//the RuntimeException, ArithmeticException is being thrown here
		//new ArithmeticException();
		//ArithmeticException is extending RuntimeException, so therefore it is an unchecked exception
		//unchecked exceptions are not required to be caught
		
		//System.out.println("This code doesn't print, because the exception interrupts the normal execution flow");
		
	}
	
	
	
}
