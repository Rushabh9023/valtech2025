package com.valtech.assignment.ordermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.services.CustomerService;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public String getCustomer(Model model) {
		model.addAttribute("customer",customerService.getAllCustomers());
		return "customer";
	}
	@PostMapping("/customers")
	public String addCustomer(@ModelAttribute CustomerVO customerVO, Model model) {
		customerService.saveOrUpdateCustomer(customerVO);
		model.addAttribute("customer",customerService.getAllCustomers());
		return "customer";
	}
	
	
}
