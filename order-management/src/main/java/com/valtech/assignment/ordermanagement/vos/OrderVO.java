package com.valtech.assignment.ordermanagement.vos;



import java.util.List;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.LineItems;
import com.valtech.assignment.ordermanagement.entities.Order;

public record OrderVO(int orderId,Customer cust, List<LineItems> lineItems) {

    public static OrderVO from(Order order) {
    	
        return new OrderVO(
            order.getOrderId(),
            order.getCustomer(),
            order.getLineItems()
        );
    }

    public Order to() {
       
        return new Order(orderId,cust,lineItems);
    }

	public static List<OrderVO> from(List<Order> orders) {
		return orders.stream().map(o -> OrderVO.from(o)).collect(Collectors.toList());
	}
}

