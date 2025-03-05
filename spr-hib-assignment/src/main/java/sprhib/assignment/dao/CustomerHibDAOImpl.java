package sprhib.assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import sprhib.assignment.entity.Customer;

public class CustomerHibDAOImpl implements CustomerHibDAO {
	
	 private HibernateTemplate hibernateTemplate;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }
	

	@Override
	public void save(Customer c) {
		hibernateTemplate.save(c);

	}

	@Override
	public void update(Customer c) {
		hibernateTemplate.update(c);

	}

	@Override
	public void delete(int id) {
		hibernateTemplate.delete(get(id));

	}

	@Override
	public Customer get(int id) {
		return hibernateTemplate.load(Customer.class, id);
	}

	@Override
	public List<Customer> getAll() {
		return hibernateTemplate.find("from Customer c");
	}

}
