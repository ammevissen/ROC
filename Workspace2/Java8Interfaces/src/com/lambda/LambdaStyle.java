package com.lambda;

public class LambdaStyle {
	
	public static void main(String[] args) {
		HelloFunctional h=()->System.out.println("Hello from lambda");
		h.hello();
		

		
		HelloFunctional h2=()->System.out.println("Hello from lambda2");
		h2.hello();

		MyFunctional m=(n)->{
			return "Hello....."+n;
		};
		System.out.println(m.hey("Andy"));
		
	
	Sum s=(x, y, z)->{
		return x+y+z;
	};
	
	System.out.println("Result is "+s.add(100, 10, 1));
	
	}
}
