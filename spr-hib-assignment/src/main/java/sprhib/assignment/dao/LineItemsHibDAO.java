package sprhib.assignment.dao;

import java.util.List;

import sprhib.assignment.entity.LineItems;

public interface LineItemsHibDAO {

	void save(LineItems l);

	void update(LineItems l);

	void delete(int id);

	LineItems get(int id);

	List<LineItems> getAll();

}