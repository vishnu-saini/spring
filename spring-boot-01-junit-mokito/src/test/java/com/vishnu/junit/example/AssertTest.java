package com.vishnu.junit.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertTest {

	@Test
	public void test() {
		boolean condn = true;
		assertEquals(true, condn);
		assertTrue(condn);
		// assertFalse(condn);
	}

}