package com.revature.app;

import com.revature.model.Shopper;

public class Application {

	public static void main(String[] args) {
		
		//declaring a reference 
		Shopper bob=new Shopper();
		
		
		bob.name="Bob";
		//bob.purchaseTotal=50.67;
		bob.setPurchaseTotal(50.67);
		bob.calculateTax();
		bob.printDetails();
		
		
		

	}

}
