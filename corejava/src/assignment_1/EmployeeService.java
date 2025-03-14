package assignment_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import assignment_1.Employee.Gender;

public class EmployeeService {
	
//	public List<Employee> sortEmployeeByGender(List<Employee> emps){
//		return emps.stream()
//	               .sorted(Comparator.comparing(Employee::getGender))
//	               .collect(Collectors.toList());
	
//	}
	
	
	public List<Employee> employees;
	
	public EmployeeService() {}

	public List<Employee> addEmployees(){
		employees = new ArrayList<Employee>();
		employees.add(new Employee(101, "Yashvi", 21, 24000.0f, Gender.FEMALE, 2, 2));
 		employees.add(new Employee(101, "Yashvi", 21, 24000.0f, Gender.FEMALE, 2, 2));
 	    employees.add(new Employee(102, "Devam", 26, 40000.0f, Gender.MALE, 4, 7));
 		employees.add(new Employee(103, "Orry", 30, 38000.0f, Gender.OTHER, 3, 9));
 		employees.add(new Employee(104, "Rushabh", 23, 50000.0f, Gender.MALE, 5, 15));
 	    
 	employees.add(Employee.builder().id(105).name("Jeel").age(38).salary(52000.0f).gender(Employee.Gender.MALE).level(5).experience(15).build());
 	    	
 	employees.add(Employee.builder().id(106).name("Dhvani").age(27).salary(34000.0f).gender(Employee.Gender.FEMALE).level(3).experience(4).build());

return employees;
		
	}
	
     public double getTotalSalaryOfEmployeesByLevel(List<Employee> emps,int level) {
    	 double sum=emps.stream().filter(e->e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
    	 return sum;
     }
	
	 public double getTotalSalaryOfEmployeesByNameContains(List<Employee> emps,String name){
		 
		 double sum = emps.stream().filter(e->e.getName().equalsIgnoreCase(name)).mapToDouble(Employee::getSalary).sum();
		 return sum;
	}
	
	 public double getTotalSalaryOfEmployeesByLevelAndGender(List<Employee> emps,int level,Gender gender){
		 
		 double sum = emps.stream().filter(e->e.getLevel()==level && e.getGender().equals(gender)).mapToDouble(Employee::getSalary).sum();
		 return sum;
	}
  
	 public Map<Gender, List<Employee>> getEmployeeMap(List<Employee> emps){
		
		 return emps.stream()
                 .collect(Collectors.groupingBy(e -> e.getGender()));
	}
    
	 public double getTotalSalaryOfEmployeesByGender(List<Employee> emps,Gender gender) {
		 
		 double sum = emps.stream().filter(e -> e.getGender()== gender).mapToDouble(Employee::getSalary).sum();
		 return sum;
		}
    
    public Map<Gender, Double> getTotalSalaryOfEmployeesByGenderUsingMap(List<Employee> emps) {
    	
    	
    	
    	  Map<Gender,List<Employee>> mapOfEmployee = getEmployeeMap(emps);
    	    Set<Gender> lsg = mapOfEmployee.keySet();
    	    System.out.println(lsg);
    	    System.out.println("----------------------");
    	    Collection<List<Employee>> lsv = mapOfEmployee.values();
    	    System.out.println(lsv);
    		Map<Gender, Double> totalSalaryByGender = emps.stream()
    	            .collect(Collectors.groupingBy(
    	                Employee::getGender, 
    	                Collectors.summingDouble(Employee::getSalary) 
    	            ));
			return totalSalaryByGender;
    }

}
