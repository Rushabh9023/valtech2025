package sprhib.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sprhib.assignment.Customer;
import sprhib.assignment.CustomerService;
import sprhib.assignment.Item;
import sprhib.assignment.ItemHibDAO;

public class Client {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assignment-config.xml");
		CustomerService cs = ctx.getBean(CustomerService.class);
		ItemHibDAO i = ctx.getBean(ItemHibDAO.class);
		
//		i.save(new Item("Laptop", "used by me", 10, 5, 15));
//		i.save(new Item("Mobile", "used by Others", 6, 4, 10));
		
		Item i1 = i.get(2);
         i1.setMaxQuentity(20);
         i1.setReorderQuentity(14);
		 i.update(i1);
		
		
		i.getAll().forEach(it -> System.out.println(it));
//		cs.save(new Customer("Yashvi", 24, "Baroda", "Ahmedabad"));
		
//		Customer ct = cs.get(5);
//		ct.setName("Mehul");
//		ct.setAddress("Pune");
//		ct.setPerAddress("Udaipur");
//		cs.update(ct);
		
//		cs.getAll().forEach(c -> System.out.println(c));
		
		ctx.close();
	}

}
