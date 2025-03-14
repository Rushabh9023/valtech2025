package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.entities.Order;
import com.valtech.assignment.ordermanagement.vos.ItemVO;

public interface InventoryService {

	void resetInventory(int itemId);

	void updateInventory(Order order);

	List<ItemVO> getAllItems();

	ItemVO getItem(int itemId);

	ItemVO saveOrUpdateItem(ItemVO itemvo);

	

}