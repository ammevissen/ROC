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
			log.info("2.) Sort by amount");
			log.info("3.) Sort by date");
			log.info("4.) Sort by time");
			log.info("5.) Sort by transaction partner");

			try {
				choice=Integer.parseInt(MenuSystem.sc.nextLine());
				log.debug("user's choice was "+choice);
			}catch (NumberFormatException e){
				choice=0;
			}

			
			switch(choice){
				case 1:
					log.info("Exiting Transactions Sort Menu");
					break;
				case 2:
					log.debug("sorting by amount");
					transations=Comparator.compareAmount(transations);
					break;
				case 3:
					log.debug("sorting by date");
					transations=Comparator.compareDate(transations);
					break;
				case 4:
					log.debug("sorting by time");
					transations=Comparator.compareTime(transations);
					break;
				case 5:
					log.debug("sorting by transaction partner");
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
