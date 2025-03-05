package assignment.servlets.service;

import java.util.List;

import assignment.servlets.entity.Employee;

public interface DeptService {

	List<Employee> sortEmployeesByIdAsc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByIdDesc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByNameAsc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByNameDesc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByAgeAsc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByAgeDesc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByGenderAsc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByGenderDesc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesBySalaryAsc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesBySalaryDesc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByExperienceAsc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByExperienceDesc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByLevelAsc(String sortOrder,List<Employee> emps);

	List<Employee> sortEmployeesByLevelDesc(String sortOrder,List<Employee> emps);

	List<Employee> serachEmployees(List<Employee> emps, String name, String age, String salary, String level,
			String experience);

}