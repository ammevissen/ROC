//Naming convention of classes have 
public class Driver {

	public static void main(String[] args) {
		/*
		 * Declaration is where you declare a particular variable.
		 * Initialization is where you assign a value to that variable for the first time.
		 */
		byte myByte;
		myByte=10;
		
		byte mySecondByte =20;
		
		System.out.println("myByte: "+myByte);
		System.out.println("mySecondByte: "+mySecondByte);
		
		myByte=30;
		System.out.println("myByte: "+myByte);

		
		short myShort=25_767;
		System.out.println("myShort: "+ myShort);
		
		int myInt=1_000_000_567;
		long myLong=453432108L;
		long mySecondLong=1_000_000; //within the range o ints

		//type sysout the press ctr + space as a shortcut
		System.out.println("myInt: "+myInt);
		System.out.println("myLong: "+myLong);		
		System.out.println("mySecondLong: "+mySecondLong);
		
		char c='c';
		System.out.println(c);
		char n=1000;
		System.out.println(n);

		//floating Types:
		float myFloat=3.14159f;
		float myOtherFloat=3.14159F;
		double myDouble=31.454;
		
		System.out.println("myFloat: "+myFloat);
		System.out.println("myOtherFloat: " + myOtherFloat);
		System.out.println("myDouble: "+ myDouble);
	
		//char use single quotes, strings use double quotes.
		c='A';
		System.out.println("new value of c: "+ c);
	
		//boolean:
		boolean b=true;
		System.out.println("b: "+b);
		b=false;
		System.out.println("new val of b: "+b);
		
		boolean d= 10==10;
		System.out.println("does 10==10? "+d);
		
		
		boolean isAlive=true;
		
		/*Naming conventions of variables:
		 * don't do really ambiguous names like a, b, or c
		 * Have something descriptive
		 * and do camelCase, have the first word's letter in lowercase and any subsequent first letter uppercase
		 * numOfTires, numOfAnimals
		 */
		
		/*
		 * Strings are not primatives, the are actually objects.  Therefore; there is a String class that is used as the "object reference type"
		 * So since the String class follows the naming convention, it is uppercase.
		 * 
		 */
		
		
		
	}

}
