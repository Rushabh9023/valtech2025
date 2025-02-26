package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;
import spring.tx.EmployeeService;

public class TxClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		EmployeeService es = ctx.getBean(EmployeeService.class);
		es.update(new Employee(10, "Ten", 10, 1000, Gender.FEMALE, 10, 10));
		es.getAll().forEach(t -> System.out.println(t));
		ctx.close();
	}
	
}
