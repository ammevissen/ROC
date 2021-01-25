package com.bank.main;

import com.bank.*;

public class CDAccountMain {

	public void cdDriver(){
	//public static void main(String[] args) {
		// TODO Auto-generated method stub		
		CDAccount cdAccount1=new CDAccount("James", "Moriarty", 1000, 334, 0.001);
		CDAccount cdAccount2=new CDAccount("John", "Watson", 500, 580, 0.0015);
		CDAccount cdAccount3=new CDAccount("Sherlock", "Homles", 10000, 823, 0.002);
		CDAccount cdAccount4=new CDAccount("Irene", "Adler", 5000, 1794, 0.005);
		
		System.out.println(cdAccount2.getFirstName()+" "+cdAccount2.getLastName()+"'s CD account number is: "+cdAccount1.getAccountNumber());

		cdAccount1.printBalance();
		cdAccount2.printBalance();
		cdAccount3.printBalance();
		cdAccount4.printBalance();
	}

}
