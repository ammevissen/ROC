package com.revature.ui;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.util.Comparator;
import com.revature.model.CustomerTransaction;

public class SortingTransactionsMenu{

	
	private static Logger log=Logger.getLogger(SortingTransactionsMenu.class);

	public void display(List<CustomerTransaction> transations) {
		
		
		CustomerTransaction.print(transations);
		
		int choice=0;
		log.info("Employee View Transactions Menu");

		do {
			log.info("1.) Exit Transactions Sort Menu");
			log.info("2.) Sort by Account Number");
			log.info("3.) Sort by Date");
			log.info("4.) Sort by Time");
			log.info("5.) Sort by Transaction Partner");

			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				log.info("Please enter an integer between 1 and 4");
			}

			
			switch(choice){
				case 1:
					transations=Comparator.compareAmount(transations);
					break;
				case 2:
					transations=Comparator.compareDate(transations);
					break;
				case 3:
					transations=Comparator.compareTime(transations);
					break;
				case 4:
					transations=Comparator.compareTrasanciontPartner(transations);
					break;

				default:
					log.info("Pease enter a value between 1 and 5");
					break;
			}
	
		}while (choice!=1);
		log.debug("Out of while loop, exiting Sort Transactions");		
}

	
}
