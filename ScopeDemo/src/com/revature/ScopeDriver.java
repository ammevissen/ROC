package com.revature;

public class ScopeDriver {

	static int a; //static scope variable, which can be accessed directly from a static method
	int b; //instance variable, can not be access directly from a static method
	int c; //same as b
	
	
	public static void main(String[] args) {
		a=20;
		System.out.println("a: "+a); //can access a directly since they are both static
		System.out.println("a: "+ScopeDriver.a);//if you're in a different class, do it this way
		
		ScopeDriver driver=new ScopeDriver();
		
		driver.b=10;
		driver.c=1000;
		System.out.println("b: "+driver.b);
		System.out.println("c: "+driver.c);
		
		int d;
		d=5;
		System.out.println("d: "+d);
		
		driver.instanceMethod();
		
		staticMethod();
		int[] myInts= {10, 20, 30, 40};
		int sum=calculatorSum(myInts);
		System.out.println("sum of myInts: "+sum);
		
		
	}
	
	public static int calculatorSum(int[] arr) {//arr is also method scoped
		int result=0;//sum here to be properly scoped
		for (int i=0; i<arr.length; i++) {
			result+=arr[i];
		}
		return result;
	}
	
	public void instanceMethod() {
		System.out.println("Inside Instance Method");
		
		sayHi();//Instance methods can access static methods directly, but not the other way around
		System.out.println("a (static): "+ a);//access static variables
		System.out.println("b: "+b);//accessing instance variable
		System.out.println("c: "+c);
		
		int c=100; //variable shadowing 
		System.out.println("method scope c: "+c);
		
		System.out.println("instance c: "+this.c);
		
		
		System.out.println("End of Instance Method");
		
	}
	public static void sayHi() {
		System.out.println("Hello there");
		staticMethod(); 
	}
	
	public static void staticMethod() {
		int a=100;//also shadowing
		System.out.println("a (local)"+a);
		
		System.out.println("a (static)"+ScopeDriver.a);
		
		//block scope can occur in both a static method and instance method
		//Block scope will refer to blocks of code within a method (loops, conditional, etc) 
		{
			int b=100;
			System.out.println("b (block scope): "+b);
			System.out.println("a (Static Method): "+a);
			System.out.println("a (static): "+ScopeDriver.a);
		}
		//can not access b because now outside of the scope b was defined in
		
		//block scope
		for (int i=0; i<10; i++) {
			System.out.println("i in for loop: "+i);
		}
		//i is only scoped to the for loop
		
		//method scope
		int j;
		for (j=0; j<10; j++) {
			System.out.println("j in for loop: "+j);
		}
		//can access j since it was created outside of the for loop
		System.out.println("j outside of for loop: "+j); //will print out 10
		
		if (j==10) {
			int k=899;
			System.out.println("k: "+k);
		}
		//cannot access k as it is not out of scope
		
	}
}
