package com.valtech.assignment.ordermanagement.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.Customer.Status;

public record CustomerVO(int custId,String name,int age,String address,String perAddress,String status ) {

	public Customer to() {
		Status cStatus = Status.valueOf(status);
		return new Customer(custId, name, age, address, perAddress, cStatus);
	}
	
	public static List<CustomerVO> from(List<Customer> customer){
		return customer.stream().map(c -> from(c)).collect(Collectors.toList());
	}
	
	public static CustomerVO from(Customer c) {
		String cStatus  = c.getStatus().name();
		return new CustomerVO(c.getCustId()	, c.getName() ,c.getAge(), c.getAddress(), c.getPerAddress(), cStatus);
	}
}
