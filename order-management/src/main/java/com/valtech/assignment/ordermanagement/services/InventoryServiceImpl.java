package com.valtech.assignment.ordermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.entities.Order;
import com.valtech.assignment.ordermanagement.repos.ItemRepo;
import com.valtech.assignment.ordermanagement.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
	public void resetInventory(int itemId) {
    	  Item item = itemRepo.getReferenceById(itemId);
          item.setCurrentQuentity(item.getMaxQuentity());
          item.setReorderQuentity(0);
          itemRepo.save(item);
        
    }

    @Override
	public void updateInventory(Order order) {
    	order.getLineItems().forEach(lineItem -> {
            Item item = itemRepo.getReferenceById(lineItem.getItem().getItemId());
            item.setCurrentQuentity(item.getCurrentQuentity() - lineItem.getQuentity());
            item.setReorderQuentity(item.getMaxQuentity() - item.getCurrentQuentity());
            itemRepo.save(item);
        });
    }

	@Override
	public ItemVO saveOrUpdateItem(ItemVO itemvo) {
        Item i = itemvo.to();
        i = itemRepo.save(i);
        return ItemVO.from(i);
    }


	@Override
	public ItemVO getItem(int itemId) {
        return ItemVO.from(itemRepo.getReferenceById(itemId));
    }

	@Override
	public List<ItemVO> getAllItems() {
        return ItemVO.from(itemRepo.findAll());
    }
}
