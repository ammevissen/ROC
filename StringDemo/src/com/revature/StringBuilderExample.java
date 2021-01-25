package com.revature;

public class StringBuilderExample {

	public static void main(String[] args) {
		String str="apple";
		
		String result=reverseStringInefficient(str);
		System.out.println("result from concatenation:"+result);

		result=reverseStringEfficient(str);
		System.out.println("result from string builder: "+result);

		
		
		
	}

	public static String reverseStringEfficient(String str) {
		StringBuilder sb=new StringBuilder();
		
		//Here we are appending new characters to this String builder object in each iteration of the loop
		for (int i=str.length()-1; i>=0; i--){
			sb.append(str.charAt(i));//""->"e"->"el->......each time making a new string
		}
		
		return(sb.toString());		
	}
		
	
	public static String reverseStringInefficient(String str) {
		String result="";//we want to reverse apple to elppa
		for (int i=str.length()-1; i>=0; i--){
			result+=str.charAt(i);//""->"e"->"el->......each time making a new string
		}
		return(result);
	}
	
}
