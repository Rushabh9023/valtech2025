package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.Customer.Status;
import com.valtech.assignment.ordermanagement.repos.CustomerRepo;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

   
	@Override
	public CustomerVO saveOrUpdateCustomer(CustomerVO cusVO) {
    	Customer c = cusVO.to();
    	c = customerRepo.save(c);
    	return CustomerVO.from(c);
        
    }
    
	@Override
	public void enableCustomer(Customer c) {
		Customer c1 =  customerRepo.getReferenceById(c.getCustId());
		c1.setStatus(Status.ENABLED);
		customerRepo.save(c1);
	}
	@Override
	public void disableCustomer(Customer c) {
		Customer c1 =  customerRepo.getReferenceById(c.getCustId());
		c1.setStatus(Status.DISABLED);
		customerRepo.save(c1);
	}

  
	@Override
	public CustomerVO getCustomer(int id) {
        return CustomerVO.from(customerRepo.getReferenceById(id));
    }

	@Override
	public List<CustomerVO> getAllCustomers() {
        return CustomerVO.from(customerRepo.findAll());
    }
}
