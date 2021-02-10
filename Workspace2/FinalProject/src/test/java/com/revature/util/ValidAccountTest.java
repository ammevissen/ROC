package com.revature.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidAccountTest {

	@Test
	void testValidAccountNumber() {
		assertFalse(ValidAccount.isNotValidAccount(1));
	}
	
	@Test
	void testInvalidAccountNumber() {
		assertTrue(ValidAccount.isNotValidAccount(0));
	}

	@Test
	void testInvalidAccountNumber2() {
		assertTrue(ValidAccount.isNotValidAccount(-11));
	}


}
