package com.revature.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidCurrencyTest {

	@Test
	void testValidInt() {
		assertFalse(ValidCurrency.isNotValidCurrency(10));
	}

	
	@Test
	void testValidFloat() {
		assertFalse(ValidCurrency.isNotValidCurrency(10.23));
	}
	
	@Test
	void testInvalidFloat() {
		assertTrue(ValidCurrency.isNotValidCurrency(10.234));
	}
	
	@Test
	void testInvalidInt() {
		assertTrue(ValidCurrency.isNotValidCurrency(-10));
	}

}
