package com.valtech.training.unittesting;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticImplTest {
	
	private Arithmetic arithmetic;
	
	@BeforeAll
	public static void beforeall() {
		System.out.println("Before All....");
	}
	
	@BeforeEach
	public void some() {
		System.out.println("Init....");
		arithmetic = new ArithmeticImpl();
	}
	
	static Stream<Arguments> addArgumentsProvider(){
		return Stream.of(Arguments.of(2,3,5),
				Arguments.of(-1,2,1),
				Arguments.of(5,3,8)
				);
				
	}
	
	@ParameterizedTest(name = "Add with Method Source A = {0} B = {1} Result = {2}")
	@MethodSource(value = "addArgumentsProvider")
	void testAddWithMethodSource(int a, int b, int res) {
		assertEquals(res, arithmetic.add(a, b));
		}
	
	@ParameterizedTest(name = "Add with CSV File A = {0} B = {1} Result = {2} ")
	@CsvFileSource(files = "data.csv")
	void testAddWithCSVFile(int a, int b, int res) {
		assertEquals(res, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with CSV Source A = {0} B = {1} Result = {2}")
	@CsvSource(value = {"2,3,5","-1,3,2","0,3,3","-1,-1,-2"})
	void testAddWithCSV(int a, int b, int res) {
		assertEquals(res, arithmetic.add(a, b));
	}
	
    @ParameterizedTest(name = "Add With Multiple Values")
    @ValueSource(strings = {"5,3,2","4,2,2","0,3,-3"})
	void testAddAgain(String param) {
		//"5,3,2","4,2,2","0,3,-3"
    	List<Integer> args = Arrays.asList(param.split(","))
    			             .stream().map(it -> Integer.parseInt(it))
    			             .collect(Collectors.toList());
    	assertEquals(args.get(0), arithmetic.add(args.get(1), args.get(2)));
	}

	@Test
	void testAdd() {
		System.out.println("Add...");
		assertEquals(5, arithmetic.add(2, 3));
	}

	@Test
	void testSub() {
		System.out.println("Sub...");
		assertEquals(5, arithmetic.sub(8, 3));
	}

}
