package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	
	ServletContext sc;
	public EmployeeDAOImpl(ServletContext sc) {
		this.sc=sc;
	}
	
	private Connection getConnection(ServletContext sc) throws SQLException {
		String url=(String) sc.getAttribute("url");
		String username=(String) sc.getAttribute("username");
		String password= (String) sc.getAttribute("password");
		return DriverManager.getConnection(url, username, password);
	}

	
	
	@Override
	public void save(Employee e) {
       try (Connection conn = getConnection(this.sc)){
		PreparedStatement ps = conn.prepareStatement
				("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID,ID) VALUES(?,?,?,?,?,?,?,?)");
	setValuesToPrepareStatement(e, ps);
	int rowsAffected = ps.executeUpdate();
	System.out.println("Rows Inserted = "+rowsAffected);
       } catch (Exception ex) {
       throw new RuntimeException(ex);
       }
	}



	private void setValuesToPrepareStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, e.getDeptId());
		ps.setLong(8, e.getId());
	}

	@Override
	public void update(Employee e) {
      try(Connection conn = getConnection(this.sc)){
    	  PreparedStatement ps = conn.prepareStatement
  				("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=?,DEPT_ID=? WHERE ID = ?");
     setValuesToPrepareStatement(e, ps);
     int rowsAffected = ps.executeUpdate();
 	System.out.println("Rows Updated = "+rowsAffected);
      }catch (Exception ex) {
    	  throw new RuntimeException(ex);
	}
	}

	@Override
	public void delete(int id) {  
      try(Connection conn = getConnection(this.sc)){
    	  PreparedStatement ps = conn.prepareStatement
    				("DELETE FROM EMPLOYEE WHERE ID = ?");
    	  ps.setInt(1, id);
    	  int rowsAffected = ps.executeUpdate();
    	 	System.out.println("Rows Deleted = "+rowsAffected);
      }catch (Exception ex) {
    	  throw new RuntimeException(ex);
	}
	}

	@Override
	public Employee get(int id) {
		try(Connection conn = getConnection(this.sc)){
			 PreparedStatement ps = conn.prepareStatement
					 ("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				// if next() returns true we have another row, if its false we are at end of the resultset
				Employee e = populateEmployee(rs);
				return e;
			}else {
				new RuntimeException("No Employee with Id "+id +" Found");
			}
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException{

		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2))
				.age(rs.getInt(3)).gender(Gender.valueOf(rs.getString(4)))
				.salary(rs.getFloat(5)).experience(rs.getInt(6))
				.level(rs.getInt(7)).deptId(rs.getInt(8)).build();
	}



	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
				
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return emps;
	}



	@Override
	public List<Employee> sortById(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
		}
		
	}

	@Override
	public List<Employee> sortByName(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortByAge(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortByGender(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getGender).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortBySalary(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortByExperience(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getExperience)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getExperience).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortByLevel(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getLevel)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getLevel).reversed()).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> sortByDeptId(String sortOrder) {
		List<Employee> emps = getAll();
		if("asc".equals(sortOrder)) {
			return emps.stream().sorted(Comparator.comparing(Employee::getDeptId)).collect(Collectors.toList());
		}else {
			return emps.stream().sorted(Comparator.comparing(Employee::getDeptId).reversed()).collect(Collectors.toList());
		}
	}

}
