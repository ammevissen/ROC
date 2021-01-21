package com.revature.demo;

import java.util.ArrayList;
import java.util.List;

public class OperatorDriver {

	public static void main(String[] args) {
		//negative number
		int x=-100;
		//positive number
		int y=+10; //the plus is optional
		
		// prefix and postfix 
		 
		//add 1 then evaluate
		System.out.println(++x); //-99
		
		//evaluate then add 1
		System.out.println(x++); //-99
		System.out.println(x); //-98
		
		//prefix decrement
		System.out.println(--y);
		
		//postfix decrement
		System.out.println(y--);
		System.out.println(y);
		
		//Binary arithmetic operators
		
		//addition
		int mySum=x+26;
		System.out.println(mySum);
		
		//subtraction
		int myDifference=mySum-y;
		System.out.println(myDifference);
		
		//mulitplication
		int myProduct=mySum*myDifference;
		System.out.println(myProduct);
		
		//division
		int num1=16;
		int num2=6;
		double myQuotient=num1/num2; //because num1 is an int and num2 is an int, we're basically dividing
		//an int by an int, and there our result is an int
		//After we evaluate to the int, we are also having an implicit widening conversion rom int to double
		//which gets us that 2.0
		//But we already lost the information about the decimal
		System.out.println(myQuotient);
		
		myQuotient=2/9;
		System.out.println(myQuotient);
		
		myQuotient=2.0/9;//here we're doing double divided by int
		//What happens when you use binary operators such as division is that the narrower primitive will be
		//automatically promoted to the largest primitive
		//So the 9 int is being promoted to a double, because 2.0 is a double literal
		System.out.println(myQuotient);
		//This is the same as:
		myQuotient=2.0/9.0;
		System.out.println(myQuotient);
		
		//also valid
		myQuotient=2./9;
		System.out.println(myQuotient);
		//Look into the concept of numeric promotion with arithmetic operators
		
		
		//Modulus
		int myRemainder=15%6;
		System.out.println(myRemainder);
		
		//Even numbers have a remainder of 0, and odd a remainder of 1 if we are doing mod 2
		myRemainder=15%2;
		System.out.println(myRemainder);
		
		myRemainder=14%2;
		System.out.println(myRemainder);
		//Mod should only be used with integers (not floats)
		
		
		//Numeric promotion
		//This is the idea for binary operators such as addition, subtraction, multiplication, division, that
		//the primitive variables will be promoted to the highest level operand.  If all operands are of
		//lower level than int, they will all be promoted to int.  This leads to some interesting cases
		
		byte myByte;
		byte myByte1=10;
		byte myByte2=11;
		myByte=(byte)(myByte1+myByte2);//doesn't work, because for primitives being added together of a size smaller than int 
		//they wil automatically be promoted to an int for binary operators
		//a is being promoted to an int
		System.out.println(myByte);
		
		double myOtherDouble=10.0+1; // 1 will be promoted to a double
		System.out.println(myOtherDouble);
		
		
		//simple assignment
		int z=54;
		System.out.println("z: "+z);
		
		//plus-equals
		z+=5;
		System.out.println(z);
		
		
		//minus-equals
		z-=20;
		System.out.println(z);		
		
		
		//mulitply-equals
		z*=5;
		System.out.println(z);
		
		//divide-equals
		z/=5;
		System.out.println(z);
		
		//mod-equals
		z%=2;
		System.out.println(z);
		
		//Logical operators
		boolean value1=true;
		boolean value2=false;
		boolean value3=true;
		boolean value4=false;
		
		//AND
		boolean result=value1 && value2; //true && false -> false
		System.out.println("True && False: " + result );
		
		result=value1 && value3; //true && true;
		System.out.println("true && true: " + result );
		
		//or
		result=value1 || value2;//true||false ->true
		System.out.println("True || False: " + result );
		
		result=value2 || value4; //false || false ->false
		System.out.println("true || true: " + result );
		
		result=value1 || value3; //true || true -> true;
		System.out.println("true || true: " + result );
		
		//Short circuiting in action
		//& or | can be used as logical operators as well, not just bitwise operators
		//They differ from && and || by the idea of short-circuiting
		
		
		//AND
		result=getFalse() && getTrue(); //false && true -> false
		System.out.println(result);
		
		result=getTrue() && getFalse(); //true && false -> false
		System.out.println(result);
		
		result=getFalse() & getTrue(); //false && true -> false
		System.out.println(result);
	
		
		result=getFalse() || getTrue(); //false || true -> false
		System.out.println(result);
		
		result=getTrue() || getFalse(); //true || false -> false
		System.out.println(result);
		
		result=getFalse() | getTrue(); //false || true -> false
		System.out.println(result);
		
		
		// relational operators
		System.out.println("relational operators");
		int a=0;
		int b=1;
		int c=2;
		int d=2;
		String myStr="hello";
		Object myArrayList=new ArrayList<>();
		
		//Equal to
		System.out.println("------");
		System.out.println("==:" + (c==d));
		
		//Not Equal to
		System.out.println("------");
		System.out.println("==:" + (c!=d));
		
		//Greater than
		System.out.println("------");
		System.out.println(">:" + (b>a));
		
		//Greater than or equal to 
		System.out.println("------");
		System.out.println(">=:" + (d>a));
				
		
		//less than
		System.out.println("------");
		System.out.println("<:" + (c<d));
		
		//Less than or equal to
		System.out.println("------");
		System.out.println("<=:" + (c<=d));
		
		//instanceof
		System.out.println("------");
		System.out.println("myStr is a Stirng: " + (myStr instanceof String)); 
		System.out.println("myStr is a Object: " + (myStr instanceof Object));				
		System.out.println("myArrayList is a Object: " + (myArrayList instanceof Object)); 
		System.out.println("myArrayList is a String: " + (myArrayList instanceof String));				
		System.out.println("myArrayList is a List: " + (myArrayList instanceof List));				
		
	}

	public static boolean getTrue() {
		System.out.println("getTrue() invoked");
		return true;
	}
	
	public static boolean getFalse() {
		System.out.println("getFalse() invoked");
		return false;
	}

}
