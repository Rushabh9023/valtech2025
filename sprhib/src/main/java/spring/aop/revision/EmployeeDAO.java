package spring.aop.revision;

import org.hibernate.Session;

import spring.tx.Employee;

public interface EmployeeDAO {

	Employee save(Session ses, Employee e);

	Employee get(Session ses, long id);

	Employee update(Session ses, Employee e);

}