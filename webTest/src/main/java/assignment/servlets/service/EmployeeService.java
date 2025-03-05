package assignment.servlets.service;

import java.util.List;

import assignment.servlets.entity.Employee;

public interface EmployeeService {
	
	List<Employee> sortEmployeesById(String sortOrder);
	
	List<Employee> sortEmployeesByName(String sortOrder);
	
	List<Employee> sortEmployeesByAge(String sortOrder);
	
	List<Employee> sortEmployeesByGender(String sortOrder);
	
	List<Employee> sortEmployeesBySalary(String sortOrder);
	
	List<Employee> sortEmployeesByExperience(String sortOrder);
	
	List<Employee> sortEmployeesByLevel(String sortOrder);
	
	List<Employee> sortEmployeesByDeptId(String sortOrder);

}