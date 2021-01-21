package com.revature.app;

public class Application {

	public static void main(String[] args) {
		//Print out all prime numbers from range of 1 to 100
		for (int i=1; i<=100; i++) {
			if (MathUtility.isPrime(i)){
				System.out.println(i);
			}
		}

	}

}
