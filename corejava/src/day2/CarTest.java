package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	void testClone()throws Exception {
		Car car = new Car("Honda","City","VX",2024,7);
		Car car1 = (Car)car.clone();
		// its true since contant is same 
		assertEquals(car, car1);
		//same method is used to compare the Object
		assertNotSame(car, car1);
	}
	
	
	@Test
	void testhashcode() {
		Car car = new Car("Honda","City","VX",2024,7);
		int hash = car .hashCode();
		System.out.println(car+" "+car.hashCode());
		//we are checking weather the hascode of old and new obj is same or not
		assertEquals(hash, car.hashCode());
		assertEquals(hash,new Car("Honda","City","VX",2024,7).hashCode());
		car.setVarient("ZX");
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash, car.hashCode());
		car.setVersion(6);
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash, car.hashCode());
		car.setModel("Jazz");
		
	    hash = car .hashCode();
		System.out.println(car+" "+car.hashCode());
		assertEquals(hash, car.hashCode());
		System.out.println(hash);
		
		
	}
	
	@Test
	void testToString() {
		Car car = new Car("Honda","City","VX",2024,7);
		assertEquals("Honda City VX 2024 Version 7", car.toString());
		car.setVarient("ZX");
		assertEquals("Honda City ZX 2024 Version 7", car.toString());
		car.setVersion(6);
		assertEquals("Honda City ZX 2024 Version 6", car.toString());
		car.setModel("Jazz");
		assertEquals("Honda Jazz ZX 2024 Version 6", car.toString());
		
		
	}

}
