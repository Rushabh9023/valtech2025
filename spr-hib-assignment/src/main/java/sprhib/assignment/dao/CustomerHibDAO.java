package sprhib.assignment.dao;

import java.util.List;

import sprhib.assignment.entity.Customer;

public interface CustomerHibDAO {

	void save(Customer c);

	void update(Customer c);

	void delete(int id);

	Customer get(int id);

	List<Customer> getAll();

}