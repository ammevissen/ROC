package com.revature;

public class B {
	
	public static void main(String[] args) {
		A aObj=new A(10, 20, 30, 40);
		System.out.println(aObj.w);
		System.out.println(aObj.x);
		System.out.println(aObj.y);
		//System.out.println(aObj.z); //can not access because private
		
		System.out.println(A.a);
		System.out.println(A.b);
		System.out.println(A.c);
		//System.out.println(A.d); //can not access because private 
	}

}
