package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import Assignment.Employee.Gender;
import junit.extensions.TestSetup;

class EmployeeTest {
     @Test
	void setUp() {
    	 List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(101, "Yashvi", 21, 24000.0f, Gender.FEMALE, 2, 2));
		employees.add(new Employee(101, "Yashvi", 21, 24000.0f, Gender.FEMALE, 2, 2));
	    employees.add(new Employee(102, "Devam", 26, 40000.0f, Gender.MALE, 4, 7));
		employees.add(new Employee(103, "Orry", 30, 38000.0f, Gender.OTHER, 3, 9));
		employees.add(new Employee(104, "Rushabh", 23, 50000.0f, Gender.MALE, 5, 15));
	    
		employees.add(Employee.builder().id(105).name("Jeel").age(38)
	    			.salary(52000.0f).gender(Employee.Gender.MALE).level(5)
	    			.experience(15).build());
	    	
		employees.add(Employee.builder().id(106).name("Dhvani").age(27)
	    			.salary(34000.0f).gender(Employee.Gender.FEMALE).level(3)
	    			.experience(4).build());
		
		//Test for Equals method
		assertTrue(employees.get(0).equals(employees.get(1)));
		assertFalse(employees.get(0).equals(employees.get(3)));
		
		//Test for Hashcode method
		assertEquals(employees.get(0).hashCode(), employees.get(1).hashCode());
		assertNotEquals(employees.get(0).hashCode(),employees.get(3).hashCode());
		
		//sort by Level
		 employees.sort(Employee.byLevel());

	        assertEquals(2, employees.get(0).getLevel());
	        assertEquals(2, employees.get(1).getLevel());
	        assertEquals(3, employees.get(2).getLevel());
	        assertEquals(4, employees.get(4).getLevel());
	        
	      //sort by Experience
	        employees.sort(Employee.byExperience());

	        assertEquals(2, employees.get(0).getExperience());
	        assertEquals(2, employees.get(1).getExperience());
	        assertEquals(4, employees.get(2).getExperience());
	        assertEquals(7, employees.get(3).getExperience());
	        
	        //sort by Gender
	        employees.sort(Employee.byGender());

	        assertEquals(Gender.FEMALE, employees.get(0).getGender());
	        assertEquals(Gender.FEMALE, employees.get(1).getGender());
	        assertEquals(Gender.FEMALE, employees.get(2).getGender());
	        assertEquals(Gender.MALE, employees.get(3).getGender());
	        assertEquals(Gender.MALE, employees.get(3).getGender());
	        
	        //Sort by Name
	        employees.sort(Employee.byName());
	        
	        assertEquals("Devam", employees.get(0).getName());
	        assertEquals("Dhvani", employees.get(1).getName());
	        assertEquals("Jeel", employees.get(2).getName());
	        
	        //Salary by Gender
	        double salaryByGender = Employee.getByGender(Gender.MALE);
	    	assertEquals(142000.0, salaryByGender );
	    	
	    	
	    	
	    	//Salary by Level
	    	 double salaryByLevel = getSumOfSalaryByLevel(employees,2);
		    	assertEquals(48000.0, salaryByLevel );

		    	
		    	//Slary by Level and Gender
		    	 double salaryByLevelAndGender = getSumOfSalaryByLevelAndGender(employees,3, Gender.FEMALE);
			    	assertEquals(34000.0, salaryByLevelAndGender );
			    	
			    	
			    	
		    	
	}
     @Test
     public double getSumOfSalaryByLevel(List<Employee>ls,int level) {
    	 double sum=ls.stream().filter(e->e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
    	 return sum;
     }
	
	 @Test
	 public static double getSumOfSalaryByNameContains(List<Employee>ls,String name){
		 double sum = ls.stream().filter(e->e.getName().equalsIgnoreCase(name)).mapToDouble(Employee::getSalary).sum();
		 return sum;
	}
	
	 @Test
	 public static double getSumOfSalaryByLevelAndGender(List<Employee>ls,int level,Gender gender){
		 double sum = ls.stream().filter(e->e.getLevel()==level && e.getGender().equals(gender)).mapToDouble(Employee::getSalary).sum();
		 return sum;
	}
  
    @Test
	 public static Map<Gender, List<Employee>> getEmployeeMap(List<Employee>ls){
		 return ls.stream()
                 .collect(Collectors.groupingBy(e -> e.getGender()));
	}
    
    @Test
    public static Map<Gender, Double> getSumOfSalaryByMap(List<Employee>ls) {
    	  Map<Gender,List<Employee>> mapOfEmployee = getEmployeeMap(ls);
    	    Set<Gender> lsg = mapOfEmployee.keySet();
    	    System.out.println(lsg);
    	    System.out.println("----------------------");
    	    Collection<List<Employee>> lsv = mapOfEmployee.values();
    	    System.out.println(lsv);
    		Map<Gender, Double> totalSalaryByGender = ls.stream()
    	            .collect(Collectors.groupingBy(
    	                Employee::getGender, 
    	                Collectors.summingDouble(Employee::getSalary) 
    	            ));
			return totalSalaryByGender;
    }
  
   
    
}
