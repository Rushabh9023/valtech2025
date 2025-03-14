package sprhib.assignment.service;

import java.util.List;

import sprhib.assignment.dao.CustomerHibDAO;
import sprhib.assignment.entity.Customer;
import sprhib.assignment.entity.Customer.Status;

public class CustomerServiceImpl implements CustomerService {
	private CustomerHibDAO customerDAO;
	
	public void setCustomerDAO(CustomerHibDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public void save(Customer c) {
		customerDAO.save(c);
	}
	@Override
	public void update(Customer c) {
		customerDAO.update(c);
	}
	@Override
	public void enableCustomer(Customer c) {
		Customer c1 =  customerDAO.get(c.getCustId());
		c1.setStatus(Status.ENABLED);
		customerDAO.update(c1);
	}
	@Override
	public void disableCustomer(Customer c) {
		Customer c1 =  customerDAO.get(c.getCustId());
		c1.setStatus(Status.DISABLED);
		customerDAO.update(c1);
	}
	@Override
	public void delete(int id) {
		customerDAO.delete(id);
	}
	@Override
	public Customer get(int id) {
		return customerDAO.get(id);
	}
	@Override
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

}
