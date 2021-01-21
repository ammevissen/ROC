package com.revature.demo;

public class MethodDriver {

	public int result;
	public double purchaseAmount;
	public double tax;
	
	public static void main(String[] args) {
		int x=add(10, 20);
		System.out.println(x);
		
		double y=add(10, 20.0);
		System.out.println(y);
		
		int z=add(10, 20, 30);
		System.out.println(z);

		//not needed since in same class
		int w=MethodDriver.add(10,  20);
		System.out.println(w);

		MethodDriver driver=new MethodDriver();
		driver.sub(20, 10);
		int subractionResult=driver.getResult();
		System.out.println(subractionResult);
		
		
		MethodDriver shopper=new MethodDriver();
		shopper.purchaseAmount=100;
		shopper.calculateTax();
		System.out.println(shopper.tax);

		MethodDriver shopper2=new MethodDriver();
		shopper2.purchaseAmount=34.5;
		shopper2.calculateTax();
		System.out.println(shopper2.tax);
		
		
	}
	
	public void calculateTax() {
		tax=multiply(purchaseAmount, .15);
	}
	
	public static double multiply(double x, double y) {
		return(x*y);
	}
	//I can have an instance method (non-static)
	public void sub(int x, int y) {
		result=x-y;
	}
	
	public int getResult() {
		return result;
	}
	
	
	
	//static methods
	public static int add(int x, int y) {
		System.out.println("Invoking add method with 2 int parameters");
		return(x+y);
	}
	
	public static double add(int x, double y) {
		System.out.println("Invoking add method with 1 int and 1 double parameters");
		return(x+y);
	}
	
	public static int add(int x, int y, int z) {
		System.out.println("Invoking add method with 3 int parameters");
		return(x+y+z);
	}
}
