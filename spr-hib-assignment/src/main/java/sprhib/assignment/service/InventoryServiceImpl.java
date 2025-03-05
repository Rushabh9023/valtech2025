package sprhib.assignment.service;

import java.util.List;
import sprhib.assignment.dao.ItemHibDAO;
import sprhib.assignment.entity.Item;
import sprhib.assignment.entity.Order;

public class InventoryServiceImpl implements InventoryService {
	
	private ItemHibDAO itemDAO;

    public void setItemDAO(ItemHibDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

   
    @Override
	public void resetInventory(int itemId) {
        Item item = itemDAO.get(itemId);
        item.setCurrentQuentity(item.getMaxQuentity());
        item.setReorderQuentity(0);
        itemDAO.update(item);
    }
    @Override
    public void updateInventory(Order order) {
  
    	order.getLineItems().forEach(lineItem -> {
            Item item = itemDAO.get(lineItem.getItem().getItemId());
            item.setCurrentQuentity(item.getCurrentQuentity() - lineItem.getQuentity());
            item.setReorderQuentity(item.getMaxQuentity() - item.getCurrentQuentity());
            itemDAO.update(item);
        });
    }
    
    @Override
	public void save(Item item) {
    	itemDAO.save(item);
    }
    @Override
	public void update(Item item) {
    	itemDAO.update(item);
    }
    @Override
	public void delete(int itemId) {
    	itemDAO.delete(itemId);
    }
    @Override
	public Item get(int itemId) {
    	return itemDAO.get(itemId);
    }
    @Override
	public List<Item> getAll(){
    	return itemDAO.getAll();
    }


}
