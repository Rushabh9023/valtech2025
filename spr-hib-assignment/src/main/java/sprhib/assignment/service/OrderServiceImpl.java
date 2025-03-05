package sprhib.assignment.service;

import java.util.List;

import sprhib.assignment.dao.OrderHibDAO;
import sprhib.assignment.entity.Item;
import sprhib.assignment.entity.LineItems;
import sprhib.assignment.entity.Order;
import sprhib.assignment.entity.Order.Status;

public class OrderServiceImpl implements OrderService {
	
	
	private OrderHibDAO orderDAO;
//	private LineItemsHibDAO liDAO;
	private InventoryService inventoryService;
//	   private ItemHibDAO itemDAO;
	
	public void setOrderDAO(OrderHibDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	 
	   public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	 @Override
	 public void placeOrder(Order order) {
		 
		 if(sprhib.assignment.entity.Customer.Status.DISABLED.equals(order.getCustomer().getStatus())) {
			 System.out.println("Can Not Place Order Since CustomerStatus is DISABLED");
		 }else {
	     
		 boolean orderFailed = false;

		 for (LineItems lineItem : order.getLineItems()) {
		        Item item = inventoryService.get(lineItem.getItem().getItemId());

		        // Check if any line item has a quentity greater than its corresponding item's currentquentity
		        if (lineItem.getQuentity() > item.getCurrentQuentity()) {
		            orderFailed = true;
		            inventoryService.resetInventory(item.getItemId()); 
		            break; 
		        }
		    }
		 
	  
	        if (orderFailed) {
	            order.setStatus(Status.FAILED);  
	            System.out.println("Order Failed");
	        } else {
	            order.setStatus(Status.PLACED);

	            // Update item quentities in inventory
	            inventoryService.updateInventory(order);
	            System.out.println("Order Placed");
	        }
	        
	        orderDAO.save(order);
	    }
	 }
	
	
	@Override
	public void update(Order o) {
		orderDAO.update(o);
	}
	@Override
	public void delete(int id) {
		orderDAO.delete(id);
	}
	@Override
	public Order get(int id) {
		return orderDAO.get(id);
	}
	@Override
	public List<Order> getAll() {
		return orderDAO.getAll();
	}

}
