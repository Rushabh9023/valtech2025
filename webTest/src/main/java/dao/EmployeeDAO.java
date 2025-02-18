package dao;

import java.util.List;

public interface EmployeeDAO {

	void save(Employee e);
	
	void update(Employee e);
	
	void delete(int id);
	
	List<Employee> sortById(String sortOrder);
//	
	List<Employee> sortByName(String sortOrder);
//	
	List<Employee> sortByAge(String sortOrder);
	
	List<Employee> sortByGender(String sortOrder);
	
	List<Employee> sortBySalary(String sortOrder);
	
	List<Employee> sortByExperience(String sortOrder);
	
	List<Employee> sortByLevel(String sortOrder);
	
	List<Employee> sortByDeptId(String sortOrder);
	
//	void searchByName(String name);
//	
//	void searchBySalary(float salary);
//	
//	void searchByAge(int age);
//	
//	void searchByExperience(int experience);
//	
//	void searchByLevel(int level);
//	
//	void searchBySalaryGreaterThen(float salary);
//	
//	void searchBySalaryLessThen(float salary);
	
	Employee get(int id);
	
	
	
	List<Employee> getAll();
	
}
