package assignment.servlets.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import assignment.servlets.dao.EmployeeDAO;
import assignment.servlets.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeDAO empDAO;

	 public EmployeeServiceImpl(EmployeeDAO empDAO) {
	        this.empDAO = empDAO;
	    }
	
	@Override
	public List<Employee> sortEmployeesById(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
		}
		
	}

	@Override
	public List<Employee> sortEmployeesByName(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortEmployeesByAge(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortEmployeesByGender(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getGender).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortEmployeesBySalary(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortEmployeesByExperience(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getExperience)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getExperience).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortEmployeesByLevel(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getLevel)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getLevel).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortEmployeesByDeptId(String sortOrder) {
		List<Employee> emps = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getDeptId)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getDeptId).reversed()).collect(Collectors.toList());
		}
	}

}
