package com.revature.demo;

public class CustomWrapper<T> {

	private T value;
	
	public void setValue(T value) {
		this.value=value;
	}
	
	public T getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "CustomWrapper [value=" + value + "]";
	}
	
	
	
	
	
}
