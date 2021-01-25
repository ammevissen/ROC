package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class FinalVariable {

	public static void main(String[] args) {
		final int i;
		i=10; //cannot change the value of i
		
		final int j=30;//cannot change the value of j
		
		final int[] myFinalArray= {10, 20, 30};//size 3 array
		myFinalArray[0]=100;//we can change the values of the array, but can not assign it to a different array
		//myFinalArray=new int[] {100, 101, 102};
		System.out.println(Arrays.toString(myFinalArray));
		
		final ArrayList<String> listOfStrings=new ArrayList<>();
		listOfStrings.add("Hi");
		listOfStrings.add("Hello");
		System.out.println(listOfStrings);

		//Not Allowed
		//listOfStrings=new ArrayList<>();
		
		
		
		final String s="Hello";//Strings are immutable, with final can not assign string to different string address 
		String s2=s.concat("There!");
		s.concat("There!");
		System.out.println("String s: "+s);
		System.out.println("String s2: "+s2);
		
		
	}

}
