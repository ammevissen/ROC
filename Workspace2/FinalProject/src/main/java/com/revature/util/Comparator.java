package com.revature.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import com.revature.model.CustomerTransaction;

public class Comparator {

	public static List<CustomerTransaction> compareAmount(List<CustomerTransaction> transactions) {
		//sorts based on amount of the transaction
		Collections.sort(transactions, (a1, a2)->{
			Double amount1=a1.getAmount();
			Double amount2=a2.getAmount();
			return amount1.compareTo(amount2);
		});
		CustomerTransaction.print(transactions);
		return(transactions);
	}

	public static List<CustomerTransaction> compareDate(List<CustomerTransaction> transactions) {
		//sorts based on the date of the transaction
		Collections.sort(transactions, (a1, a2)->{
			return a1.getDateCreated().compareTo(a2.getDateCreated());
		});
		CustomerTransaction.print(transactions);
		return(transactions);
	}


	public static List<CustomerTransaction> compareTime(List<CustomerTransaction> transactions) {
		//sorts based on the time of the transaction
		Collections.sort(transactions, (a1, a2)->{
			return a1.getTimeCreated().compareTo(a2.getTimeCreated());
		});
		CustomerTransaction.print(transactions);
		return(transactions);
	}

	public static List<CustomerTransaction> compareTrasanciontPartner(List<CustomerTransaction> transactions) {
		//sorts based on the other account in the transaction
		Collections.sort(transactions, (a1, a2)->{
			Integer getTrasanciontPartner1=a1.getTrasanciontPartner();
			Integer getTrasanciontPartner2=a2.getTrasanciontPartner();
			return getTrasanciontPartner1.compareTo(getTrasanciontPartner2);
		});
		CustomerTransaction.print(transactions);
		return(transactions);
	}

	
}
