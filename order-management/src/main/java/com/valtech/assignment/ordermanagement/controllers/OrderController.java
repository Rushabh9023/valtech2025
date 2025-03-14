package com.valtech.assignment.ordermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.assignment.ordermanagement.services.OrderService;
import com.valtech.assignment.ordermanagement.vos.PlaceOrderVO;

@Controller
public class OrderController {
	

	@Autowired
	private OrderService orderService;
	
	
	
	@PostMapping("/placeOrder")
     public String placeOrder(@ModelAttribute PlaceOrderVO pVO, Model model) {
		orderService.placeOrder(pVO);
		return "placeOrder";
	}
	
	@GetMapping("/placeOrder")
	public String orders(Model model) {
		return "placeOrder";
	}
}
