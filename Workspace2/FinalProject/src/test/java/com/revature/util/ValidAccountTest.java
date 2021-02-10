package com.revature.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidAccountTest {

	@Test
	void testValidAccountNumber() {
		ValidAccount.isNotValidAccount(1);
	}
	
	@Test
	void testInvalidAccountNumber() {
		ValidAccount.isNotValidAccount(0);
	}

	@Test
	void testInvalidAccountNumber2() {
		ValidAccount.isNotValidAccount(-11);
	}


}
