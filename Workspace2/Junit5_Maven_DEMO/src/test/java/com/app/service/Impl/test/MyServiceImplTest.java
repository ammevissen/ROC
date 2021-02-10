package com.app.service.Impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.service.MyService;
import com.app.service.Impl.MyServiceImpl;

class MyServiceImplTest {

	private static MyService service;
	
	@BeforeAll
	public static void setUpMyService() {
		service=new MyServiceImpl();
		
	}
	@Test
	void testISValidEvenNumberForTrue() {
		boolean result=service.isValidEvenNumber(10);
		assertTrue(result);
	}
	
	@Test
	void testISValidEvenNumberForFalse() {
		boolean result=service.isValidEvenNumber(101);
		assertFalse(result);
	}

}
