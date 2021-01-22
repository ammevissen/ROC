package com.revature.simple;

public class Cat extends Animal {

	
		public void makeNoise() {
			System.out.println("Nyaa! HISSSSSSS!");
		}
		
		public static void invokeMakeNoise(Animal animal) {
			animal.makeNoise();
		}
}
