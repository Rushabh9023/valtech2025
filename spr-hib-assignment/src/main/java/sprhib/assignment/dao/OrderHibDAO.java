package sprhib.assignment.dao;

import java.util.List;

import sprhib.assignment.entity.Order;

public interface OrderHibDAO {

	void save(Order o);

	void update(Order o);

	void delete(int id);

	Order get(int id);

	List<Order> getAll();

}