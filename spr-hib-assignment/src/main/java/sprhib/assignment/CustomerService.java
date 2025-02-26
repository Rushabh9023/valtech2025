package sprhib.assignment;

import java.util.List;

public interface CustomerService {

	void save(Customer c);

	void update(Customer c);

	void delete(int id);

	Customer get(int id);

	List<Customer> getAll();

}