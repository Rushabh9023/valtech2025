package assignment.servlets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import assignment.servlets.entity.Dept;
import assignment.servlets.entity.Employee;
import assignment.servlets.entity.Employee.Gender;
import jakarta.servlet.ServletContext;

public class DeptDAOImpl implements DeptDAO {

	private List<Dept> depts = new ArrayList<Dept>();
	
//	ServletContext sc;
	private String url;
	private String username;
	private String password;
//	public DeptDAOImpl(ServletContext sc) {
//		this.sc=sc;
//	}
	public DeptDAOImpl(String url,String username,String password) {
		
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	private Connection getConnection(String url,String username,String password) throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
//	
//	private Connection getConnection(ServletContext sc) throws SQLException {
//		String url=(String) sc.getAttribute("url");
//		String username=(String) sc.getAttribute("username");
//		String password= (String) sc.getAttribute("password");
//		return DriverManager.getConnection(url, username, password);
//	}

	private void setValuesToPS(Dept dept,PreparedStatement ps) throws SQLException {
		ps.setString(1, dept.getName());
		ps.setString(2, dept.getLocation());
		ps.setInt(3, dept.getId());
	}

	@Override
	public void save(Dept dept) {
		try (Connection conn = getConnection(this.url,this.username,this.password)){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO DEPARTMENT (NAME ,LOCATION, ID) VALUES(?,?,?)");
			setValuesToPS(dept, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted = "+rowsAffected);
		} catch (Exception ex) {
          throw new RuntimeException(ex);
		}
	}
	
	

	@Override
	public void update(Dept dept) {
		try (Connection conn = getConnection(this.url,this.username,this.password)){
			PreparedStatement ps = conn.prepareStatement
					("UPDATE DEPARTMENT SET NAME=?,LOCATION=? WHERE ID = ?");
			setValuesToPS(dept, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = "+rowsAffected);
		} catch (Exception ex) {
          throw new RuntimeException(ex);
		}
	}

	
	@Override
	public void delete(int id) {
		try (Connection conn = getConnection(this.url,this.username,this.password)){
			PreparedStatement ps = conn.prepareStatement
					("DELETE FROM DEPARTMENT WHERE ID = ?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Deleted = "+rowsAffected);
		} catch (Exception ex) {
          throw new RuntimeException(ex);
		}
	}
	
	@Override
	public Dept getDept(int id) {
        try (Connection conn = getConnection(this.url,this.username,this.password)){
        	PreparedStatement ps = conn.prepareStatement
        			("SELECT ID,NAME,LOCATION FROM DEPARTMENT WHERE ID = ?");
        	ps.setInt(1, id);
        	ResultSet rs = ps.executeQuery();
        	if(rs.next()) {
        		Dept de = populateDept(rs);
        		return de;
        	} else {
        		new RuntimeException("No Department with Id "+id+" Found");
        	}
        } catch (Exception e) {
        	throw new RuntimeException(e);
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
	public List<Employee> setDept(int id) {
		List<Employee> employee = new ArrayList<Employee>();
		try(Connection conn = getConnection(this.url,this.username,this.password)){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE WHERE DEPT_ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee.add(populateEmployee(rs));
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		System.out.println(employee);
		return employee;
	}
	

	private Dept populateDept(ResultSet rs) throws SQLException {
		return Dept.builder().id(rs.getInt(1))
				.name(rs.getString(2))
				.location(rs.getString(3))
				.build();
	}
	

	@Override
	public List<Dept> getAll() {
       List<Dept> department = new ArrayList<Dept>();
       try (Connection conn = getConnection(this.url,this.username,this.password)){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,LOCATION FROM DEPARTMENT");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				department.add(populateDept(rs));
				
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return department;
	}
	
	
	@Override
	public Dept first() {
		depts = getAll();
//		System.out.println(depts);
		return depts.stream().min(Comparator.comparingInt(Dept::getId)).orElse(null);
	}

	@Override
	public Dept last() {
           depts = getAll();
		return depts.stream().max(Comparator.comparingInt(Dept::getId)).orElse(null);
	}

	@Override
	public Dept next(int id) {
           depts = getAll();
           if(id == depts.size()) return getDept(id);
		return getDept(id+1);
	}

	@Override
	public Dept previous(int id) {
           if(id==1) return getDept(1); 
		return getDept(id-1);
	}

	
	


}
