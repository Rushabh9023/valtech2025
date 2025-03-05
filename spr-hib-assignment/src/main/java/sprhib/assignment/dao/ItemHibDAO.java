package sprhib.assignment.dao;

import java.util.List;

import sprhib.assignment.entity.Item;

public interface ItemHibDAO {

	void save(Item i);

	void update(Item i);

	void delete(int id);

	Item get(int id);

	List<Item> getAll();

}