package assignment.servlets.dao;

import java.util.List;

import assignment.servlets.entity.Dept;
import assignment.servlets.entity.Employee;




public interface DeptDAO {
	
	Dept first();
	
	Dept last();
	
	Dept next(int id);
	
	Dept previous(int id);
	
	void save(Dept dept);

	void update(Dept dept);

	Dept getDept(int id);
	

	void delete(int id);

	List<Dept> getAll();
	
	List<Employee> setDept(int id);

}