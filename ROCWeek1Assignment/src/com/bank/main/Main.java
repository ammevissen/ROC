package com.bank.main;

//import com.bank.*;

public class Main {

	public static void main(String[] args) {
		
		CDAccountMain cdAccount=new CDAccountMain();
		InvestingAccountMain investingAccountMain=new InvestingAccountMain();
		SavingsCheckingAccountMain savingCheckingAccountMain=new SavingsCheckingAccountMain();
		
		cdAccount.cdDriver();
		investingAccountMain.investingDriver();
		savingCheckingAccountMain.scDriver();
	}

}
