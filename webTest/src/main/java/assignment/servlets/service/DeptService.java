package assignment.servlets.service;

import java.util.List;

import assignment.servlets.entity.Employee;

public interface DeptService {

	List<Employee> sortEmployeesByIdAsc(List<Employee> emps);

	List<Employee> sortEmployeesByIdDesc(List<Employee> emps);

	List<Employee> sortEmployeesByNameAsc(List<Employee> emps);

	List<Employee> sortEmployeesByNameDesc(List<Employee> emps);

	List<Employee> sortEmployeesByAgeAsc(List<Employee> emps);

	List<Employee> sortEmployeesByAgeDesc(List<Employee> emps);

	List<Employee> sortEmployeesByGenderAsc(List<Employee> emps);

	List<Employee> sortEmployeesByGenderDesc(List<Employee> emps);

	List<Employee> sortEmployeesBySalaryAsc(List<Employee> emps);

	List<Employee> sortEmployeesBySalaryDesc(List<Employee> emps);

	List<Employee> sortEmployeesByExperienceAsc(List<Employee> emps);

	List<Employee> sortEmployeesByExperienceDesc(List<Employee> emps);

	List<Employee> sortEmployeesByLevelAsc(List<Employee> emps);

	List<Employee> sortEmployeesByLevelDesc(List<Employee> emps);

	List<Employee> serachEmployees(List<Employee> emps, String name, String age, String salary, String level,
			String experience);

}