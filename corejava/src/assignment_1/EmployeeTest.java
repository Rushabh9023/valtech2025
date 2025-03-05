package assignment_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment_1.Employee.Gender;
import junit.extensions.TestSetup;

class EmployeeTest {
	
	List<Employee> employees=new ArrayList<Employee>();
	EmployeeService es = new EmployeeService();
	
	@BeforeEach
	public void initData() {
		employees.add(new Employee(101, "Yashvi", 21, 24000.0f, Gender.FEMALE, 2, 2));
		employees.add(new Employee(101, "Yashvi", 21, 24000.0f, Gender.FEMALE, 2, 2));
	    employees.add(new Employee(102, "Devam", 26, 40000.0f, Gender.MALE, 4, 7));
		employees.add(new Employee(103, "Orry", 30, 38000.0f, Gender.OTHER, 3, 9));
		employees.add(new Employee(104, "Rushabh", 23, 50000.0f, Gender.MALE, 5, 15));
	    
employees.add(Employee.builder().id(105).name("Jeel").age(38).salary(52000.0f).gender(Employee.Gender.MALE).level(5).experience(15).build());
	    	
employees.add(Employee.builder().id(106).name("Dhvani").age(27).salary(34000.0f).gender(Employee.Gender.FEMALE).level(3).experience(4).build());
	}
	
	
	
	@Test
	void testEqualsMethod() {
		//Test for Equals method
				assertTrue(employees.get(0).equals(employees.get(1)));
				assertFalse(employees.get(0).equals(employees.get(3)));
	}
	
	@Test
	void testHashCode() {
		//Test for Hashcode method
				assertEquals(employees.get(0).hashCode(), employees.get(1).hashCode());
				assertNotEquals(employees.get(0).hashCode(),employees.get(3).hashCode());
				
	}
	
	
	@Test
	void testSortEmployeeByGender() {
		  //sort by Gender
		employees.sort(Employee.byGender());

        assertEquals(Gender.FEMALE, employees.get(0).getGender());
        assertEquals(Gender.FEMALE, employees.get(1).getGender());
        assertEquals(Gender.FEMALE, employees.get(2).getGender());
        assertEquals(Gender.MALE, employees.get(3).getGender());
        assertEquals(Gender.MALE, employees.get(3).getGender());
	}
	
	@Test
	void testSortEmployeeByLevel() {
		

		//sort by Level
		 employees.sort(Employee.byLevel());

	        assertEquals(2, employees.get(0).getLevel());
	        assertEquals(2, employees.get(1).getLevel());
	        assertEquals(3, employees.get(2).getLevel());
	        assertEquals(4, employees.get(4).getLevel());
	}
	
	@Test
	void testSortEmployeeByExperience() {
	
		//sort by Experience
        employees.sort(Employee.byExperience());

        assertEquals(2, employees.get(0).getExperience());
        assertEquals(2, employees.get(1).getExperience());
        assertEquals(4, employees.get(2).getExperience());
        assertEquals(7, employees.get(3).getExperience());
	}
	
	@Test
	void testSortEmployeeByName() {
		 //Sort by Name
        employees.sort(Employee.byName());
        
        assertEquals("Devam", employees.get(0).getName());
        assertEquals("Dhvani", employees.get(1).getName());
        assertEquals("Jeel", employees.get(2).getName());
	}
	
	@Test
	void testSortEmployeeList() {
		
		 //Sorting Whole List of Employees
        Collections.sort(employees);
        employees.forEach(e -> System.out.println(e));
        assertEquals("Jeel", employees.get(0).getName());
        assertEquals("Rushabh", employees.get(1).getName());
        assertEquals(106, employees.get(4).getId());
		
	}
	
	@Test
	void testGetTotalSalaryOfEmployeesByGender() {
		//Salary by Gender
    	assertEquals(142000.0, es.getTotalSalaryOfEmployeesByGender(employees,Gender.MALE));
    	assertEquals(82000.0, es.getTotalSalaryOfEmployeesByGender(employees,Gender.FEMALE));
	}
	
	@Test
	void testGetTotalSalaryOfEmployeesByLevel() {
		
		//Sum of Salary by Level
    	assertEquals(48000.0, es.getTotalSalaryOfEmployeesByLevel(employees,2) );
    	assertEquals(72000.0, es.getTotalSalaryOfEmployeesByLevel(employees,3) );
//    	System.out.println(es.getTotalSalaryOfEmployeesByLevel(employees,3));
	}
	
	@Test
	void testGetTotalSalaryOfEmployeesByLevelAndGender() {
		
		//Sum ofSlary by Level and Gender
    	assertEquals(34000.0, es.getTotalSalaryOfEmployeesByLevelAndGender(employees,3, Gender.FEMALE) );
//    	System.out.println(es.getTotalSalaryOfEmployeesByLevelAndGender(employees,3, Gender.OTHER));
    	assertEquals(38000.0, es.getTotalSalaryOfEmployeesByLevelAndGender(employees,3, Gender.OTHER) );
		
	}
	
	
	
     @Test
	void testGetTotalSalaryOfEmployeesByGenderUsingMap() {
			    	
			    	System.out.println(es.getTotalSalaryOfEmployeesByGenderUsingMap(employees));
			    	
			    	
			    	
		    	
	}
    
}
