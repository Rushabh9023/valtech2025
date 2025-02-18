package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmaticTest {

	private Arithmatic ari = new ArithmaticImpl();
	
	@Test
	void testAdd() {
		assertEquals(5, ari.add(3, 2));
		assertNotEquals(4, ari.add(3, 2));
	}
	
	@Test
	void testSub() {
		assertEquals(7, ari.sub(10, 3));
		assertNotEquals(6, ari.sub(10, 5));
	}
	
	@Test
	void testMult() {
		assertEquals(8, ari.mult(4, 2));
		assertNotEquals(6, ari.mult(4, 2));
	}
	
	@Test
	void testDivWithDouble() {
		//  5./3 = 1.6666666...
		//  except 1.666+-0.001
		assertEquals(1.666, ari.div(5.,3),0.001); //correct test case
		assertEquals(Double.POSITIVE_INFINITY, ari.div(5., 0),0.0001);
		
	}
	
	@Test
	void testDivWithInt() {
		assertEquals(2, ari.div(4, 2));
		assertEquals(3, ari.div(7, 2));
	}
	
	@Test
	void testDivWithIntDenomIsZero() {
		try {
//			Failing case were our code was expecting exception 
//			ari.div(3, 1);
			ari.div(3, 0);
			fail("Exception was Expected...");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
