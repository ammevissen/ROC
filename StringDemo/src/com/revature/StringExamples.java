package com.revature;

public class StringExamples {

	public static void main(String[] args) {
		
		//Declare and initialize Strings using literals ("literal here")
		
		//"hi" goes into the string pool
		String str1="hi";
		String str2="hi";
		
		//This will go in the normal part of the heal
		String str3=new String("hi");//we have two string objects
		
		System.out.println("str1==str2: "+str1==str2);
		System.out.println("str1==str3: "+str1==str3);
		System.out.println("str1.equals(str3): "+str1.equals(str3));
		
		//concatinate
		String concatExample="h".concat("i");//each "h" and "i" would be in the string pool, even if we don't use it anywhere else
		System.out.println(concatExample);
		System.out.println("str1==concatExample: "+str1==concatExample);
		System.out.println("str1.equals(concatExample): "+str1.equals(concatExample));
		System.out.println("str3==concatExample: "+str3==concatExample);//different objects
		System.out.println("str3.equals(concatExample): "+str3.equals(concatExample));

		//contains
		String str4="Hello, my name is Roger";
		System.out.println("str4 contians name: "+str4.contains("name"));//this string is added to the string pool
		System.out.println("str4 contians 'name is': "+str4.contains("name is"));//this string is also added to the string pool
		
		
		//startsWith
		System.out.println("str4.startsWith: Hello: "+str4.startsWith("Hello"));
		System.out.println("str4.startsWith: , my (offset 5 spaces): "+str4.startsWith(", my", 5));
				
		//endsWith:
		System.out.println("str4.endsWith(Roger): "+str4.endsWith("Roger"));
		
		
		//try to see if a string has only alphabetical characters
		String str5="abcdefgABCDEFG";
		System.out.println("reex: "+str5.matches("[a-zA-Z]+"));//if the string has one or more characters from a-z or A-Z, return true
		
		//compareTo
		System.out.println("a".compareTo("b"));
		System.out.println("a".compareTo("z"));
		System.out.println("d".compareTo("a"));
		System.out.println("apple".compareTo("apricot"));		
		System.out.println("1".compareTo("a"));
		System.out.println("1".compareTo("A"));
		System.out.println("A".compareTo("a"));

		
		
	}

}
