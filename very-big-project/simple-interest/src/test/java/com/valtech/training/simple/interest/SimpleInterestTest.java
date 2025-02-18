package com.valtech.training.simple.interest;

import junit.framework.TestCase;

public class SimpleInterestTest extends TestCase {

	public void testSimpleInterest() {
		SimpleInterest s1 = new SimpleInterest();
		assertEquals(500, s1.compute(500, 10, 10));
	}
}
