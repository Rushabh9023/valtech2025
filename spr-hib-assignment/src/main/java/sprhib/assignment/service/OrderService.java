package sprhib.assignment.service;

import java.util.List;

import sprhib.assignment.entity.Order;

public interface OrderService {

	void placeOrder(Order order);

	void update(Order o);

	void delete(int id);

	Order get(int id);

	List<Order> getAll();



}