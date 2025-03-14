package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;

public interface CustomerService {

	List<CustomerVO> getAllCustomers();

	CustomerVO getCustomer(int id);

	void disableCustomer(Customer c);

	void enableCustomer(Customer c);

	CustomerVO saveOrUpdateCustomer(CustomerVO cusVO);

	
}