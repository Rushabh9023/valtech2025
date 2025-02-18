package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	// @Test is an annotation Which is an Metadata
	@Test
	void testDog() {
		Dog dog = new Dog();
		showBehaviour(dog);
		
		//this fail method is written to implicitly fail the test case to understand better
//		fail("Should fail....");
	}

	@Test
	void testCat() {
		showBehaviour(new Cat());
	}

	@Test
	void testTiger() {
		showBehaviour(new Tiger());
	}

	private void showBehaviour(Animal a) {
		a.makeSound();
		a.eat();
		a.sleep();
	}
	
}
