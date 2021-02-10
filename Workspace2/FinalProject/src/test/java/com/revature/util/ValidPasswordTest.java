package com.revature.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidPasswordTest {

	@Test
	void testValidPassword() {
		assertFalse(ValidPassword.isNotValidPassword("p@55w0rd"));
	}
	
	@Test
	void testShortPassword() {
		assertTrue(ValidPassword.isNotValidPassword("p@5w0rd"));
	}

	@Test
	void testNoPassword() {
		assertTrue(ValidPassword.isNotValidPassword(""));
	}


}
