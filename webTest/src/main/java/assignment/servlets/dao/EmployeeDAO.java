package assignment.servlets.dao;

import java.util.List;

import assignment.servlets.entity.Employee;


public interface EmployeeDAO {

	void save(Employee e);
	
	void update(Employee e);
	
	void delete(int id);
	
	Employee get(int id);
	
	List<Employee> getAll();
	
}
