package com.valtech.assignment.ordermanagement.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Item;

public record ItemVO(int id,String name,String desc,int currentQty,int reorderQty,int maxQty) {
	

	public Item to() {
		return new Item(id, name, desc, currentQty, reorderQty, maxQty);
		
	}
	
	public static ItemVO from(Item i) {
		return new ItemVO(i.getItemId(), i.getItemName(), i.getItemDesc(), i.getCurrentQuentity(), 
				i.getReorderQuentity(), i.getMaxQuentity());
	}
	public static List<ItemVO> from(List<Item> item){
		return item.stream().map(i -> from(i)).collect(Collectors.toList());
	}
}
