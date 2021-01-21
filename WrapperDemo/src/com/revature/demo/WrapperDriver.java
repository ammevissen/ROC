package com.revature.demo;

import java.util.ArrayList;

public class WrapperDriver {

	public static void main(String[] args) {
		System.out.println("Max value an interger can have is: "+Integer.MAX_VALUE);
		System.out.println("Min value an interger can have is: "+Integer.MIN_VALUE);
				
		int primitiveInt=5;
		
		//being depreciated
		Integer wrapperIntFromString=new Integer("5");
		Integer wrapperIntFromInt=new Integer(5);
		
		
		
		//This one is better
		Integer wrapperIntAutoboxing=5; //conversion from primitive int 5 to Integer wrapper object
			
		int result=50+wrapperIntAutoboxing; //will unbox automatically the value inside the Integer wrapper object
		//and add it to 50 
		
		System.out.println("result: "+ result);
		
		//I cannot use primitives in these data structures, so I need to use an Object
		//The main difference between an Array and ArrayList is that Array is fixed size
		//ArrayList can have a changing size
		ArrayList<Object> arrayList=new ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(-15);
		arrayList.add("This is a string");
		System.out.println(arrayList);
		
		
		
		Integer[] intArray=new Integer[5];
		
		Character c='a'; //char generic
		ArrayList<Double> arrayListD=new ArrayList<>();
		ArrayList<Float> arrayListF=new ArrayList<>();
		arrayListD.add(10d);
		arrayListD.add(10.0);
		arrayListF.add(10f);
		arrayListF.add(10.0f);
		System.out.println(arrayListD);
		System.out.println(arrayListF);
		
		//Double myDouble =(Double) arrayList.get(2);
		//System.out.println(myDouble);
		
		System.out.println(wrapperIntFromString==wrapperIntFromInt);
		System.out.println(wrapperIntFromString.equals(wrapperIntAutoboxing));

		String s="Hello";
		String s1="Hello";
		System.out.println("s vs s1 "+(s==s1));
		
		String s2=new String("Hello");
		System.out.println("s vs s2 "+(s==s2));

		System.out.println("s.equals(s2): "+(s.equals(s2)));
		
		
		System.out.println("WrapperIntFromString==5: "+(wrapperIntFromString==5));//wrapperIntFromString being unboxed into primitive then primitive comparison
		System.out.println("WrapperIntFromString.equals(5): "+(wrapperIntFromString.equals(5)));//unboxing
		
		
		
		
		
	}

	public static void parsiong() {
		int parsedInt=Integer.parseInt("5");
		System.out.println(parsedInt);
		
		Integer parsedWrapperInt=Integer.valueOf("5");
		System.out.println(parsedWrapperInt);
	}
}
