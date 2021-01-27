package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;


public class ListExample {

	public static void main(String[] args) {
		
		//better to use the interface 
		//consider if later one wanted to switch to linked list, nothing will break later
		List<String> list1=new ArrayList<>();
		List<List<String>> twoDArrayList=new ArrayList<>();//List of lists
		
		list1.add("Peaches");
		list1.add("Avocados");
		list1.add("Apples");
		list1.add("Plums");
		list1.add("Oranges");
		list1.add("Kiwis");
		list1.add("Kiwis");
		list1.add("Kiwis");
		//list1.add(null);
		//list1.add(null);
		
		//toStrings has already been overridden so get nicely formatted output
		System.out.println("list1: "+list1);
		System.out.println("list1 size: "+list1.size());
		
		list1.add(0, "Pears");
		System.out.println("list1: "+list1);
		System.out.println("list1 size: "+list1.size());

		System.out.println("5th element: "+list1.get(4));
		
		//way to remove Kiwis:
		//compares using .equals()
		//"Kiwis".equals("Kiwis")
		//new String("Kiwis").equal("Kiwis");
		list1.remove(new String("Kiwis"));//removes the first occurance
		System.out.println("lists1: "+list1);

//      removeall, needs to use lambdas
//		list1.replaceAll(e->{
//			if (e.equals("Kiwis")) {
//				return null;
//			}else {
//				return e;
//			}
//		});
//		System.out.println("list1: "+list1);
		
		list1.remove(5);
		System.out.println("list1: "+list1);
		System.out.println("list1 size: "+list1.size());
		
		
		//loop through elements
		for (int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		//For each or enhanced for loop
		for (String i: list1) {
			System.out.println(i);
			//list1.remove("Kiwis");//I cannot remove (or add) elements when I am inside an enhanced for loop
		}
		System.out.println("list1: "+list1);
		
		//Using iterators
		//Iterators navigate in one direction
		//Once we finish iterating, we must obtain a new iterator
		//Iterators start before the first element, and in order to obtain the first element, we must then invoke the
		//next() method
	
		System.out.println("===ITERATOR===");
		Iterator<String> iter=list1.iterator();
		
		String element;
		while (iter.hasNext()) {
			element=iter.next();
			if (element.equals("Kiwis")){
				iter.remove();//remove all kiwis
				}
			System.out.println(element);
		}
		System.out.println("list1: "+list1);

		//contains indexOf:
		System.out.println("list1 contains 'Apples': "+list1.contains("Apples"));
		System.out.println("list1 contains 'Apples': "+list1.indexOf("Apples"));//returns index of first element of that value, and -1 if element not in list
		
		System.out.println("============");
		//Collections has a lot of static methods (cannot instantiate) that can be used to perform operations on various Collections
		//This is known as a utility class
		System.out.println(list1);
		Collections.sort(list1);//sort the list in place
		System.out.println(list1);
		
		Collections.reverse(list1);
		System.out.println(list1);
		
	}
	
}
