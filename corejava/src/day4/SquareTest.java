package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void testSquareNow() {

		// Long way to declare but beacause of functional interface its easy
		Square sq = new Square() {
			public double squareNow(double x) {
				return x*x;
			}
		};
		
		//short way
		Square square = (a) -> a*a;
		
		assertEquals(0, square.squareNow(0));
		assertEquals(0, square.squareNow(-0));
		assertEquals(1, square.squareNow(1));
		assertEquals(1, square.squareNow(-1));
		assertEquals(9, square.squareNow(-3));
	
	}

}
