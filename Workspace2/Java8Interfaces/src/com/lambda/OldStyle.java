package com.lambda;

public class OldStyle implements HelloFunctional{
	
	public static void main(String[] args) {
		HelloFunctional h=new OldStyle();
		h.hello();
		
		HelloFunctional h1=new HelloFunctional() {
			@Override
			public void hello() {
				System.out.println("hello from old sytle lambda");
			}
			
		};
		h1.hello();
		
		
	}
	
	@Override
	public void hello() {
		System.out.println("hello from old sytle");
	}

}
