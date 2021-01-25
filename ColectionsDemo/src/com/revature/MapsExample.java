package com.revature;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapsExample {

	public static void main(String[] args) {
		
		//Hashmap is not thread-safe unlike HashTable
		//Hashmap is faster because it is not thread-safe and doesn't need to do thread-checking
		//Hashmap also allows one null key and null values
		//HashTable does not allow any null keys or null values whatsoever
		//HashMaps and HashTables do not preserve order.  We are not guaranteed what order our elements will print out in
		
		//Map is not in anyway related to the Collection interface, but it is part of the collections api
		Map<String, Long> phoneBook=new HashMap<>();
		
		phoneBook.put("Larry", 5032343L);
		phoneBook.put("Bob", 5032344L);
		phoneBook.put("Tom", 5031234L);
		
		//duplicate values are allowed
		phoneBook.put("Dad", 5031111L);
		phoneBook.put("Mom", 5031111L);
		
		//duplicate keys are not allowed
		//this will overwrite previous Tom Key
		phoneBook.put("Tom", 5039875L);

		System.out.println(phoneBook);
		
		Set<String> phoneBookKeys=phoneBook.keySet();
		
		System.out.println("phoneBook keys:");
		for (String e: phoneBookKeys) {
			System.out.println(e);
		}
		
		//We can also iterate over both keys and values:
		Set<Map.Entry<String, Long>> keyValues=phoneBook.entrySet();
		for (Map.Entry<String, Long> entry: keyValues) {
			String key=entry.getKey();
			Long value=entry.getValue();
			
			System.out.println(key+ " : "+value);
		}
		
		//we can also iterate just over every value
		Collection<Long> values=phoneBook.values();
		
		for (Long l: values) {
			System.out.println(l);
		}
		
		System.out.println("Tom's phone number: " + phoneBook.get("Tom"));
		
		//The main key for using different objects as Keys for Maps
		//would be to override the .hashCode() method from the Object class
		//We also want to override the .equals() method as well
		
		
	}

}
