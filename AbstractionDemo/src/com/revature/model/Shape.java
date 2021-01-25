package com.revature.model;

public abstract class Shape implements Drawable, Calculable{

	protected double area;
	protected int edges;
	protected String name;
	
	public Shape() {
		super();
	}
	
	public Shape(int edges, String name) {
		this.edges=edges;
		this.name=name;
	}
	
	//abstract method do not have implementation, they are instead overriden in the child class
	//implementation is provided there
	public abstract void calculateArea();
	
	
	public void printShapeName() {
		System.out.println(this.name);
	}

	public double getArea() {
		return area;
	}

	public int getEdges() {
		return edges;
	}

	public String getName() {
		return name;
	}

}
