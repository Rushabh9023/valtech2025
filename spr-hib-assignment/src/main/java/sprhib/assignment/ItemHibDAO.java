package sprhib.assignment;

import java.util.List;

public interface ItemHibDAO {

	void save(Item i);

	void update(Item i);

	void delete(int id);

	Item get(int id);

	List<Item> getAll();

}