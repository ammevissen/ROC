package com.revature.main;

import com.revature.model.Shape;
import com.revature.model.Triangle;
import com.revature.model.Drawable;
import com.revature.model.Rectangle;


public class Driver {

	public static void main(String[] args) {
		Shape shape=new Triangle(5, 10);
		shape.calculateArea();
		System.out.println(shape.getArea());
		System.out.println(shape);
		
		
		shape=new Rectangle(10.5, 20);
		shape.calculateArea();
		System.out.println(shape.getArea());
		System.out.println(shape);
		
		Drawable d=new Triangle(2.5, 5.5);
		d.draw();
		System.out.println(d);
	}

}
