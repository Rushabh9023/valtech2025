package spring.tx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	private long id;
	private String name;
	private int age;
	private float salary;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int level;
	private int experience;

	public static List<Employee> employees = new ArrayList<Employee>();	
	
	//Enum for gender
	public enum Gender {FEMALE,MALE,OTHER;}
	
	//non Parameterized Constructor
		public Employee() {}

		//parameterized constructor 
		public Employee(long id, String name, int age, float salary, Gender gender, int level, int experience) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.level = level;
		this.experience = experience;
		employees.add(this);
	}


	@Override
	public String toString() {
		return new StringBuilder()
				.append("[")
				.append("EmpId = ")
				.append(id)
				.append(", EmpName = ")
				.append(name)
				.append(", EmpAge = ")
				.append(age)
				.append(", EmpSalary = ")
				.append(salary)
				.append(", EmpGender = ")
				.append(gender)
				.append(", EmpLevel = ")
				.append(level)
				.append(", EmpExperience = ")
				.append(experience).append("years")
				.append("]")
				.toString();
	}

//getters and setters 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public static List<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(List<Employee> employees) {
		Employee.employees = employees;
	}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return age == other.age && experience == other.experience && gender == other.gender && id == other.id
					&& level == other.level && Objects.equals(name, other.name)
					&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
		}
		
		
	@Override
		public int hashCode() {
			return Objects.hash(age, experience, gender, id, level, name, salary);
		}
	
	
    
//    public static Comparator<Employee> byLevel() {
//        return (Employee e1, Employee e2) -> Integer.compare(e1.level, e2.level);
//    }
//
//    public static Comparator<Employee> byExperience() {
//        return (Employee e1, Employee e2) -> Integer.compare(e1.experience, e2.experience);
//    }
//
//    public static Comparator<Employee> byGender() {
//        return (Employee e1, Employee e2) -> e1.gender.compareTo(e2.gender);
//    }
//
//    public static Comparator<Employee> byName() {
//        return (Employee e1, Employee e2) -> e1.name.compareToIgnoreCase(e2.name);
//    }

    
//    public static List<Employee> getByLevel(int level) {
//		return employees;
//    	
//    }
//    
    
    
    
	
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}

	public static class EmployeeBuilder{
		private Employee employee ;
		public EmployeeBuilder(Employee emp) {
			this.employee=emp;
		}
		public Employee build(){
			employees.add(employee);
			return employee;
		}
		
		
		
		
		public EmployeeBuilder id(long id) {
			employee.setId(id);
			return this;
		}
		public EmployeeBuilder name(String name) {
			employee.setName(name);
			return this;
		}
		public EmployeeBuilder age(int age) {
			employee.setAge(age);
			return this;
		}
		public EmployeeBuilder salary(float salary) {
			employee.setSalary(salary);
			return this;
		}
		public EmployeeBuilder gender(Gender gender) {
			employee.setGender(gender);
			return this;
		}
		public EmployeeBuilder level(int level) {
			employee.setLevel(level);
			return this;
		}
		public EmployeeBuilder experience(int experience) {
			employee.setExperience(experience);
			return this;
		}
		
	}
	
	//Stream Api By different Scenarios 
	
	
//	public static double getByGender(Gender gender) {
//		List<Employee> employee = employees.stream().filter(e -> e.gender == gender).collect(Collectors.toList());
//		System.out.println(employee);
//		return employee.stream().mapToDouble(Employee::getSalary).sum();
//	}
//	public static void setEmpByGender(Map<Gender, List<Employee>> empByGender) {
//		Employee.empByGender = empByGender;
//	}

	
	
	

	

	
	

	
	
	
}
