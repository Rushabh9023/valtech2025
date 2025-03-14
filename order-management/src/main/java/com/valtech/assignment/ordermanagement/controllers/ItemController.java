package com.valtech.assignment.ordermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.services.InventoryService;
import com.valtech.assignment.ordermanagement.vos.ItemVO;

@Controller
public class ItemController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/items")
	public String getItem(Model model) {
		model.addAttribute("item",inventoryService.getAllItems());
		return "item";
	}
	
	@PostMapping("/items")
	public String addItem(@ModelAttribute ItemVO itemvo, Model model) {
		inventoryService.saveOrUpdateItem(itemvo);
		model.addAttribute("item", inventoryService.getAllItems());
		return "item";
	}

}
