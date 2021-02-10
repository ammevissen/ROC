package com.revature.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidNameTest {

	@Test
	void testValidNameLetters() {
		assertFalse(ValidName.isNotValidPassword("Andy"));
	}

	
	@Test
	void testValidLeetSpeak() {
		assertFalse(ValidName.isNotValidPassword("R3v@tur3"));
	}

	@Test
	void testNoName() {
		assertTrue(ValidName.isNotValidPassword(""));
	}

	@Test
	void testNullName() {
		assertTrue(ValidName.isNotValidPassword(null));
	}

}
