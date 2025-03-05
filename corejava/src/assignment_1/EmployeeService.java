package assignment_1;

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
	
	
     public double getTotalSalaryOfEmployeesByLevel(List<Employee>ls,int level) {
    	 double sum=ls.stream().filter(e->e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
    	 return sum;
     }
	
	 public double getTotalSalaryOfEmployeesByNameContains(List<Employee>ls,String name){
		 double sum = ls.stream().filter(e->e.getName().equalsIgnoreCase(name)).mapToDouble(Employee::getSalary).sum();
		 return sum;
	}
	
	 public double getTotalSalaryOfEmployeesByLevelAndGender(List<Employee>ls,int level,Gender gender){
		 double sum = ls.stream().filter(e->e.getLevel()==level && e.getGender().equals(gender)).mapToDouble(Employee::getSalary).sum();
		 return sum;
	}
  
	 public Map<Gender, List<Employee>> getEmployeeMap(List<Employee>ls){
		 return ls.stream()
                 .collect(Collectors.groupingBy(e -> e.getGender()));
	}
    
	 public double getTotalSalaryOfEmployeesByGender(List<Employee>ls,Gender gender) {
			List<Employee> employee = ls.stream().filter(e -> e.getGender()== gender).collect(Collectors.toList());
			System.out.println(employee);
			return employee.stream().mapToDouble(Employee::getSalary).sum();
		}
    
    public Map<Gender, Double> getTotalSalaryOfEmployeesByGenderUsingMap(List<Employee>ls) {
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
