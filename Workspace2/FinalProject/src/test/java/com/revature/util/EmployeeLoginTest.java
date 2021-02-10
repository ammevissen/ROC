package com.revature.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import com.revature.util.EmployeeLogin;
import org.junit.jupiter.api.Test;

import com.revature.ui.MenuSystem;

class EmployeeLoginTest {

	@Test
	void testISValid() {
		assertTrue(EmployeeLogin.login(1, "p@55w0rd"));
	}
	
	@Test
	void testForNoPassword() {
		assertFalse(EmployeeLogin.login(1, ""));
	}
	
	@Test
	void testForWrongPassword() {
		assertFalse(EmployeeLogin.login(1, "p@66w0rd"));
	}

	@Test
	void testForWrongAccountNumber() {
		assertFalse(EmployeeLogin.login(2, "p@55w0rd"));
	}

}
