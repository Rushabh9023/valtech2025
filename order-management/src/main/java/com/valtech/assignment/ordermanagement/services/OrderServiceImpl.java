package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.entities.LineItems;
import com.valtech.assignment.ordermanagement.entities.Order;
import com.valtech.assignment.ordermanagement.entities.Order.Status;
import com.valtech.assignment.ordermanagement.repos.CustomerRepo;
import com.valtech.assignment.ordermanagement.repos.ItemRepo;
import com.valtech.assignment.ordermanagement.repos.OrderRepo;
import com.valtech.assignment.ordermanagement.vos.OrderVO;
import com.valtech.assignment.ordermanagement.vos.PlaceOrderVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private InventoryService inventoryService;
    
    @Autowired
    private ItemRepo itemRepo;
    
    @Autowired
    private CustomerRepo custRepo;

	@Override
	public OrderVO placeOrder(PlaceOrderVO pvo) {
		int custId = pvo.customerId();
		int itemId = pvo.itemId();
		int quentity = pvo.quentity();
		
		LineItems li = new LineItems();
		li.setItem(inventoryService.getItem(itemId).to());
		li.setQuentity(quentity);
		
		
		
		
    	Order order = new Order();
    	System.out.println("LIIIIIIIIIIIII"+li);
    	order.addLineItem(li);
    	order.setCustomer(custRepo.getReferenceById(custId));
        if (Customer.Status.DISABLED.equals(order.getCustomer().getStatus())) {
            System.out.println("Cannot Place Order Since Customer Status is DISABLED");
            return null;
        }

        boolean orderFailed = false;

        for (LineItems lineItem : order.getLineItems()) {
            Item item = itemRepo.getReferenceById(lineItem.getItem().getItemId());

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
            inventoryService.updateInventory(order);
            System.out.println("Order Placed");
        }

        return OrderVO.from(orderRepo.save(order));
    }

	@Override
	public OrderVO updateOrder(OrderVO orderVO) {
        return OrderVO.from(orderRepo.save(orderVO.to()));
    }

//	public void deleteOrder(int id) {
//        orderRepo.deleteById(id);
//    }

	@Override
	public OrderVO getOrder(int id) {
        return OrderVO.from(orderRepo.getReferenceById(id));
    }

	@Override
	public List<OrderVO> getAllOrders() {
        return OrderVO.from(orderRepo.findAll());
    }
}
