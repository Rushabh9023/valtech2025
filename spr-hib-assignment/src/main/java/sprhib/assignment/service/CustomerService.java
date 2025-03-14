package sprhib.assignment.service;

import java.util.List;

import sprhib.assignment.entity.Customer;

public interface CustomerService {

	void save(Customer c);

	void update(Customer c);

	void delete(int id);

	Customer get(int id);

	List<Customer> getAll();

	void disableCustomer(Customer c);

	void enableCustomer(Customer c);

}