package com.revature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map=new HashMap<>();
		
		map.put(121, "hey");
		map.put(126, null);
		map.put(123, "java");
		map.put(152, "jee");
		map.put(102, "hey");
		map.put(1200, "jme");
		map.put(120, "hibernate");
		map.put(1100, "spring");
		map.put(10, null);
		map.put(22, "graphql");
		map.put(44, "java");
		
		System.out.println("Before Deletion");
		System.out.println(map);
		
		//delete all K, V pairs if any key is multiples of 10 or value is null
//		for (Entry<Integer, String> e:map.entrySet()) {
//			if (e.getKey()%10==0 || e.getValue()==null) {
//				map.remove(e.getKey());
//			}
//		}
// one thing is reading, one thing is modifying so get error, so need to use an iterator
		
		Iterator<Entry<Integer, String>> i=map.entrySet().iterator(); //If it is a list or set or queue the directly assign object.iterator()
		//i is pointing to first record
		//need to use iterator to make sure not pointing to two different things at a time 
		while(i.hasNext()) {
			Entry<Integer, String>e=i.next();
			if(e.getKey()%10==0 || e.getValue()==null) {
				i.remove();
			}
		}
		
		
		System.out.println("\nAfter Deletion");
		System.out.println(map);
		
		//Enumerator ->Ready ->top to bottom
		//Iterator -> Read and remove ->top to bottom
		//ListIterator -> Add, Read, Remove, ->bidirectional, but it is applicable only and only on list interface.
		
		
		//solves the issue of having concurrent operations goint on with the same object
		List<String> list=Arrays.asList("hello", "hi", "java", "jme", "django", "python");
		Iterator<String> i2=list.iterator();
		while(i2.hasNext()) {
			String s=i2.next();
			System.out.println(s.toUpperCase());
		}
		
		
		
		
		
		
	}

}
