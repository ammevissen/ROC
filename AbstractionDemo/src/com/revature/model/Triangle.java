package com.revature.model;

public class Triangle extends Shape{
	
	private double base;
	private double height;
	
	public Triangle() {
		super(3, "Triangle");
	}
	
	public Triangle(double base, double height) {
		super(3, "Triangle");
		this.base=base;
		this.height=height;
		
	}
	
	@Override 
	public void calculateArea() { 
		this.area=0.5*this.base*this.height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + ", area=" + area + ", edges=" + edges + ", name="
				+ name + "]";
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Triangle");
	}
	
	
	
	
}
