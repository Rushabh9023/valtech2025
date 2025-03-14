package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import com.valtech.assignment.ordermanagement.entities.Order;
import com.valtech.assignment.ordermanagement.vos.OrderVO;
import com.valtech.assignment.ordermanagement.vos.PlaceOrderVO;

public interface OrderService {

	
	List<OrderVO> getAllOrders();

	OrderVO getOrder(int id);

	OrderVO updateOrder(OrderVO orderVO);

	OrderVO placeOrder(PlaceOrderVO pvo);




}