package assignment.servlets.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import assignment.servlets.dao.EmployeeDAO;
import assignment.servlets.entity.Employee;

public class DeptServiceImpl implements DeptService {
	
	private EmployeeDAO empDAO;
	
	 public DeptServiceImpl(EmployeeDAO empDAO) {
	        this.empDAO = empDAO;
	    }
	
	
@Override
public List<Employee> sortEmployeesByIdAsc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
			
		}

@Override
public List<Employee> sortEmployeesByIdDesc(String sortOrder,List<Employee> emps) {
	return emps.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
	
}


	@Override
	public List<Employee> sortEmployeesByNameAsc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
	}
	@Override
	public List<Employee> sortEmployeesByNameDesc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
	}



	
	@Override
	public List<Employee> sortEmployeesByAgeAsc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
	}
	@Override
	public List<Employee> sortEmployeesByAgeDesc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
	}



	
	@Override
	public List<Employee> sortEmployeesByGenderAsc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
	}
	@Override
	public List<Employee> sortEmployeesByGenderDesc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getGender).reversed()).collect(Collectors.toList());
	}




	@Override
	public List<Employee> sortEmployeesBySalaryAsc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
	}
	@Override
	public List<Employee> sortEmployeesBySalaryDesc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
	}



	
	@Override
	public List<Employee> sortEmployeesByExperienceAsc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getExperience)).collect(Collectors.toList());
	}
	@Override
	public List<Employee> sortEmployeesByExperienceDesc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getExperience).reversed()).collect(Collectors.toList());
	}



	
	@Override
	public List<Employee> sortEmployeesByLevelAsc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getLevel)).collect(Collectors.toList());
	}
	@Override
	public List<Employee> sortEmployeesByLevelDesc(String sortOrder,List<Employee> emps) {
			return emps.stream().sorted(Comparator.comparing(Employee::getLevel).reversed()).collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> serachEmployees(List<Employee> emps,String name,String age,String salary,String level,String experience){
		return emps
	            .stream()
	            .filter(e -> name == null || name.isEmpty() || e.getName().toLowerCase().contains(name.toLowerCase()))
	            .filter(e -> age == null || age.isEmpty()
	                || (age.startsWith(">") ? e.getAge() >= Integer.parseInt(age.substring(1)) :
	                (age.startsWith("<") ? e.getAge() < Integer.parseInt(age.substring(1)) : e.getAge() == Integer.parseInt(age))))
	            .filter(e -> salary == null || salary.isEmpty()
	                || (salary.startsWith(">") ? e.getSalary() >= Integer.parseInt(salary.substring(1)) :
	                (salary.startsWith("<") ? e.getSalary() < Integer.parseInt(salary.substring(1)) : e.getSalary() == Integer.parseInt(salary))))
	            .filter(e -> level == null || level.isEmpty()
	                || (level.startsWith(">") ? e.getLevel() >= Integer.parseInt(level.substring(1)) :
	                (level.startsWith("<") ? e.getLevel() < Integer.parseInt(level.substring(1)) : e.getLevel() == Integer.parseInt(level))))
	            .filter(e -> experience == null || experience.isEmpty()
	                || (experience.startsWith(">") ? e.getExperience() >= Integer.parseInt(experience.substring(1)) :
	                (experience.startsWith("<") ? e.getExperience() < Integer.parseInt(experience.substring(1)) : e.getExperience() == Integer.parseInt(experience))))
	            .collect(Collectors.toList());
	}


}
