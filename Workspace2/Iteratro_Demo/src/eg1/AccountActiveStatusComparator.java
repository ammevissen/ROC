package eg1;

import java.util.Comparator;

public class AccountActiveStatusComparator implements Comparator<Account>{

	
	//comparable in the class, can only have 1, lang package 
	//Comarator outside of the class, can do with any number

	//Java 7 approach
	@Override
	public int compare(Account o1, Account o2) {
		Boolean b1=o1.isActive();
		Boolean b2=o2.isActive();
		return b2.compareTo(b1);
	}
	
	
}
