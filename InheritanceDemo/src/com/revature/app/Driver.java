package com.revature.app;

import com.revature.Dog;
import com.revature.Animal;

public class Driver {

	public static void main(String[] args) {
		Dog dog=new Dog();//Dog() is the constructor
		
		dog.numOfLegs=4; //numOfLegs is defined in the animal class, but dog inheritis it
		dog.name="fido";
		
		Dog dog2=new Dog("Sparky");
		dog2.numOfLegs=3;
		
		Dog[] dogs=new Dog[] {dog, dog2};
		
		
		dog.makeNoises();
		System.out.println(dog2.numOfLegs);
		System.out.println(dog.numOfLegs);
		
		Object myObj=dog;
		Animal myAnimal=dog;
		Dog myDog=dog;
	
	}

}
