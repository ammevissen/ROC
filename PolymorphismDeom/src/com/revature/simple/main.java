package com.revature.simple;

public class main {

	public static void main(String[] args) {

		Animal someAnimal=new Animal();
		someAnimal.makeNoise();
		
		
		Animal anotherAnimal=new Dog();//implicit upcastiong
		anotherAnimal.makeNoise();
		((Dog) anotherAnimal).playFetch(); 
		anotherAnimal.Name="David";
		
		Dog dog=(Dog) anotherAnimal;
		System.out.println("dog name: "+dog.Name);
		
		
		Animal yetAnotherAnimal=new Cat();
		yetAnotherAnimal.makeNoise();
		
		Cat.invokeMakeNoise(yetAnotherAnimal);
		
		

	}

}
