package sprhib.test;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sprhib.assignment.entity.Customer;
import sprhib.assignment.entity.Customer.Status;
import sprhib.assignment.entity.Item;
import sprhib.assignment.entity.LineItems;
import sprhib.assignment.entity.Order;
import sprhib.assignment.service.CustomerService;
import sprhib.assignment.service.InventoryService;
import sprhib.assignment.service.OrderService;

class ClientTest {

	
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assignment-config.xml");
	CustomerService customerService = ctx.getBean(CustomerService.class);
    OrderService orderService = ctx.getBean(OrderService.class);
    InventoryService inventoryService = ctx.getBean(InventoryService.class);
    
    @Test
    public void testDisabledCustomerCannotPlaceOrder() {
        Customer customer = customerService.get(2);
        customer.setStatus(Status.DISABLED);
        customerService.update(customer);

        Item item = inventoryService.get(2);
        Order order = new Order();
        order.setCustomer(customer);

        LineItems lineItem = new LineItems();
        lineItem.setItem(item);
        lineItem.setQuentity(item.getCurrentQuentity() - 3);
        lineItem.setOrder(order);

        order.setLineItems(Arrays.asList(lineItem));

        orderService.placeOrder(order);
        

//        assertEquals("Can Not Place Order Since CustomerStatus is DISABLED", order.getStatus());
    }
   
    
    @Test
    public void testEnabledCustomerCanPlaceOrder() {
        Customer customer = customerService.get(3);
        Item item = inventoryService.get(2);
        Order order = new Order();
        order.setCustomer(customer);

        LineItems lineItem = new LineItems();
        lineItem.setItem(item);
        lineItem.setQuentity(item.getCurrentQuentity() - 3);
        lineItem.setOrder(order);

        order.setLineItems(Arrays.asList(lineItem));

        orderService.placeOrder(order);

        assertEquals(Order.Status.PLACED, order.getStatus());
    }

    @Test
    public void testOrderFailsIfQuantityExceedsStock() {
        Customer customer = customerService.get(1);
        Item item = inventoryService.get(1);
        Order order = new Order();
        order.setCustomer(customer);

        LineItems lineItem = new LineItems();
        lineItem.setItem(item);
        lineItem.setQuentity(item.getCurrentQuentity() + 5);
        lineItem.setOrder(order);

        order.setLineItems(Arrays.asList(lineItem));

        orderService.placeOrder(order);

        assertEquals(Order.Status.FAILED, order.getStatus());
    }
	
	
    @Test
    public void testInventoryReset() {
        inventoryService.resetInventory(2);
        Item item = inventoryService.get(2);

        assertEquals(item.getMaxQuentity(), item.getCurrentQuentity());
    }
}
	


