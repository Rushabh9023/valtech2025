package sprhib.assignment.service;

import java.util.List;

import sprhib.assignment.entity.Item;
import sprhib.assignment.entity.Order;

public interface InventoryService {

	void resetInventory(int itemId);

	void save(Item item);

	void update(Item item);

	void delete(int itemId);

	Item get(int itemId);

	List<Item> getAll();

	void updateInventory(Order order);

}