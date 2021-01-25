package com.revature.main;

import com.revature.model.Shape;
import com.revature.model.Triangle;
import com.revature.model.Drawable;
import com.revature.model.Rectangle;
import com.revature.model.Calculable;

public class Driver {

	public static void main(String[] args) {
//		Shape shape=new Triangle(5, 10);
//		shape.calculateArea();
//		shape.draw();
//		System.out.println(shape.getArea());
//		System.out.println(shape);
		
		
//		shape=new Rectangle(10.5, 20);
//		shape.draw();
//		shape.calculateArea();
//		System.out.println(shape.getArea());
//		System.out.println(shape);
		
		Drawable d=new Triangle(2.5, 5.5);
		d.draw();
		
		//printing out, the area is 0
		System.out.println(d);		
		
		//variable c and d referring to the same object
		Calculable c=(Calculable) d;
		c.calculateArea();
		
		System.out.println(d);
		
	}

}
