package com.usingthread;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		//System.out.println("Hello from "+Thread.currentThread().getName()+" id: "+Thread.currentThread().getId()+" group: "+Thread.currentThread().getThreadGroup());
		for (int i=0; i<4; i++) {
			System.out.println();
		}
	}

}
