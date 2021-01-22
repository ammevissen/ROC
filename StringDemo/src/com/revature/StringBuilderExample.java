package com.revature;

public class StringBuilderExample {

	public static void main(String[] args) {
		String str="apple";
		
		String result="";//we want to reverse apple to elppa
		
		for (int i=str.length()-1; i>=0; i--){
			result+=str.charAt(i);
		}
		
		System.out.println(result);

	}

}
