package com.app.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HelloJunit {

	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Hello from @beforeAll-executed only once before creating instance" );
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Hello from @beforeEach- executed before every single test case in this class");
	}

	@Test
	public void testHello1() {
		System.out.println("Hello from testHello1()");
	}
	
	@Test
	public void testHello2() {
		System.out.println("Hello from testHello2()");
	}

	
	@AfterEach
	public void afterEach() {
		System.out.println("Hello from @beforeEach- executed after every single test case in this class");
	}

	
	@AfterAll
	public static void afterAll() {
		System.out.println("Hello from @afterAll-executed only once after creating instance");
	}
	
}
