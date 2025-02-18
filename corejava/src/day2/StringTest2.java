package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest2 {

	@Test
	void test() {
		String s = "Hello";
		String s1 = "Hello";
		assertSame(s, s1);
		String s2 = new String ("Hello");
		assertNotSame(s1, s2);
		//Its ex of compile time String like at compile time on both the side of + Constant value is there
		String s3 = "Hell"+"o";
		assertSame(s, s3);
		String s4 = "o";
		//Below case is Runtime String Since we are having one variable on right side of + which is s4
		String s5 = "Hell"+s4;
		assertNotSame(s3, s5);
		final String s6 = "o";
		//in this case we have make String as Final so its Making it constant
		String s7 = "Hell"+s6;
		assertSame(s, s7);
	}

}
