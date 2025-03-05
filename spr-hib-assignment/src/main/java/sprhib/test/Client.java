package sprhib.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sprhib.assignment.entity.Customer;
import sprhib.assignment.entity.Customer.Status;
import sprhib.assignment.entity.Item;
import sprhib.assignment.entity.LineItems;
import sprhib.assignment.entity.Order;
import sprhib.assignment.service.CustomerService;
import sprhib.assignment.service.InventoryService;
import sprhib.assignment.service.OrderService;


public class Client {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assignment-config.xml");
		CustomerService customerService = ctx.getBean(CustomerService.class);
        OrderService orderService = ctx.getBean(OrderService.class);
        InventoryService inventoryService = ctx.getBean(InventoryService.class);
		

        
        
        // Data to check for DISABLED Status in customer
        
        Customer c2 = customerService.get(2);
        c2.setStatus(Status.DISABLED);
        customerService.update(c2);
        Item item3 = inventoryService.get(2); 
        Order order3 = new Order();
        order3.setCustomer(c2);
        LineItems lineItem1 = new LineItems();
        lineItem1.setItem(item3);
        lineItem1.setQuentity(item3.getCurrentQuentity() - 3);  
        lineItem1.setOrder(order3); 
        order3.setLineItems(Arrays.asList(lineItem1));
        orderService.placeOrder(order3);
        
  
        //Data to check ENABLED field in Customer
        
//      Customer c3 = customerService.get(3);
//      Item item3 = inventoryService.get(2); 
//      Order order3 = new Order();
//      order3.setCustomer(c3);
//      LineItems lineItem1 = new LineItems();
//      lineItem1.setItem(item3);
//      lineItem1.setQuentity(item3.getCurrentQuentity() - 3);  
//      lineItem1.setOrder(order3); 
//      order3.setLineItems(Arrays.asList(lineItem1));
//      orderService.placeOrder(order3);
        
//      customerService.getAll().forEach(c -> System.out.println(c));
        
      
      
      
//		Customer c1 = customerService.get(1);
//		Item item1 = inventoryService.get(1); 
//        Item item2 = inventoryService.get(2); 
        
//        item1.setCurrentQuentity(6);
//        item1.setReorderQuentity(9);
//        item1.setMaxQuentity(15);
//        inventoryService.update(item1);
//        
//        item2.setCurrentQuentity(9);
//        item2.setReorderQuentity(11);
//        item2.setMaxQuentity(20);
//        inventoryService.update(item2);
        
//      
        
      
    //Data to check FAILED order Status
      
//        Order order1 = new Order();
//        order1.setCustomer(c1);
//        
//        LineItems lineItem1 = new LineItems();
//        lineItem1.setItem(item1);
//        lineItem1.setQuentity(item1.getCurrentQuentity() + 5);  
//        lineItem1.setOrder(order1); 
//        
//        LineItems lineItem2 = new LineItems();
//        lineItem2.setItem(item2);
//        lineItem2.setQuentity(item2.getCurrentQuentity() + 10);  
//        lineItem2.setOrder(order1); 
//        order1.setLineItems(Arrays.asList(lineItem1, lineItem2));
//        orderService.placeOrder(order1);
//        System.out.println("Failed Order Status : " + order1.getStatus()); 
      
      
      
      //Data to check PLACED status of Order
      
//        Order order2 = new Order();
//        order2.setCustomer(c1);
//        LineItems lineItem3 = new LineItems();
//        lineItem3.setItem(item1);
//        lineItem3.setQuentity(item1.getCurrentQuentity() - 1);  
//        lineItem3.setOrder(order2); 
//        order2.setLineItems(Arrays.asList(lineItem3));
//        orderService.placeOrder(order2);
//        System.out.println("Placed Order Status : " + order2.getStatus()); 
        
        
      
      
        //resetInventory
//        inventoryService.resetInventory(2);
        
        
  	
		
//		i.save(new Item("Laptop", "used by me", 10, 5, 15));
//		i.save(new Item("Mobile", "used by Others", 6, 4, 10));
		
//		Item i1 = i.get(2);
//         i1.setMaxQuentity(20);
//         i1.setReorderQuentity(14);
//		 i.update(i1);
//		
//		
//		i.getAll().forEach(it -> System.out.println(it));
//		cs.save(new Customer("Yashvi", 24, "Baroda", "Ahmedabad"));
		
//		Customer ct = cs.get(5);
//		ct.setName("Mehul");
//		ct.setAddress("Pune");
//		ct.setPerAddress("Udaipur");
//		cs.update(ct);
		
		
		ctx.close();
	}

}
