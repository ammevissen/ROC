package com.revature.other;
import com.revature.A;
public class C extends A{

	public C(int w, int x, int y, int z) {
		super(w, x, y, z);
	}
	
	public static void main(String[] args) {
		C aObj=new C(10, 20, 30, 40);
		
		System.out.println(aObj.w);//public
		System.out.println(aObj.x);//protected can access due to subclass
		//System.out.println(aObj.y);//default
		//System.out.println(aObj.z);//private
		
		System.out.println(A.a);//public
		System.out.println(A.b);//protected can access due to subclass
		//System.out.println(A.c);//default
		//System.out.println(A.d);//private
		
	}

}
