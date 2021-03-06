package eg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		List<Account> accountList = new ArrayList<>();
		
		accountList.add(new Account(1234567890L, "Raj", 1200.22, 3.4f, true));
		accountList.add(new Account(9234567890L, "Giri", 2200.22, 1.4f, true));
		accountList.add(new Account(8234567890L, "Sachin", 5200.22, 3.4f, false));
		accountList.add(new Account(4234567890L, "Megha", 200.22, 4.4f, false));
		accountList.add(new Account(1234567899L, "Jay", 3200.22, 2.4f, true));
		accountList.add(new Account(1234567990L, "Andrew", 4200.22, 3.4f, true));
		accountList.add(new Account(2234567890L, "Virat", 1200.22, 3.4f, false));
		
		System.out.println("printing all of the accounts retrived from DB");
		printAccountDetails(accountList);
		
//		System.out.println("\n Sorting list by default based on accountId");
//		Collections.sort(accountList);//comparable
//		printAccountDetails(accountList);
//		
		System.out.println("\nSorting list  based on account active status");
		Collections.sort(accountList,new AccountActiveStatusComparator()); //Comparator
		printAccountDetails(accountList);
		
		System.out.println("\n Sorting list based on customer names");
		Collections.sort(accountList, (a1, a2)->{
			return a1.getCustomerName().compareTo(a2.getCustomerName());
		});//comparator
		printAccountDetails(accountList);
		
		System.out.println("\nSorting list based on ratings highest to lowest,  same rating highest balance first");
		Collections.sort(accountList, (a1, a2)->{
			Float f2=a2.getRatings();
			Float f1=a1.getRatings();
			int x=f2.compareTo(f1);
			if (x==0) {
				Double d1=a1.getCurrentBalance();
				Double d2=a2.getCurrentBalance();
				x=d2.compareTo(d1);
			}//comparator
			return x;
		});
		printAccountDetails(accountList);
		
		
	}
	
	public static void printAccountDetails(List<Account> accountsList) {
		Iterator<Account> i=accountsList.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	

}
