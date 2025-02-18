package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import day2.Car;

class LambdaExpressionTest {

	@Test
	void test() {
		List<Car> cars = new ArrayList<Car>();
		cars.add(Car.builder().make("Honda").model("City")
				.varient("ZX").year(2024).version(7).build());
		
		cars.add(new Car("Benz","EClass","220D",2024,5));
		
		cars.add(Car.builder().make("Honda").model("City")
				.varient("VX").year(2024).version(4).build());
		
		cars.add(Car.builder().make("Honda").model("Jazz")
				.varient("ZX").year(2024).version(6).build());
		
		
		//to get List of cars whose version > 5 larger way using list
		List<Car> newCars = new ArrayList<Car>();
		for (Car car : cars) {
			if(car.getVersion()>5) {
				newCars.add(car);
			}
		}
		System.out.println(newCars);
		
		//to get List of cars whose version > 5 larger way
		for (Car car : cars) {
			if(car.getVersion()>5) {
				System.out.println(car);
			}
		}
		
		//to get List of cars whose version > 5 Shorter using Lambda Expression
		List<Car> myNewCar = cars.stream().filter(car -> car.getVersion()>5)
				.collect(Collectors.toList());
		System.out.println(myNewCar);
		
		//to get the list of Honda cars for string value 
		System.out.println(cars.stream().filter(car -> "Honda".equals(car.getMake()))
				.collect(Collectors.toList()));
		
		//to get the list of other cars for string value 
				System.out.println(cars.stream().filter(car -> !"Honda".equals(car.getMake()))
						.collect(Collectors.toList()));
		// -> is like return after this we write code what we want
		
		// We only want to print make of cars so use map() instead of filter()
		// we use toSet for unique answer so that only Honda and Benze will be Print 
		// If we have used toList then it would have print Honda Benz Honda Honda
				System.out.println(cars.stream().map(car -> car.getMake())
						        .collect(Collectors.toSet()));
				
	}
	

}
