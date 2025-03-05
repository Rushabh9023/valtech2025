package sprhib.assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import sprhib.assignment.entity.Order;

public class OrderHibDAOImpl implements OrderHibDAO {

	 private HibernateTemplate hibernateTemplate;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	@Override
	public void save(Order o) {
		hibernateTemplate.save(o);

	}

	@Override
	public void update(Order o) {
		hibernateTemplate.update(o);

	}

	@Override
	public void delete(int id) {
		hibernateTemplate.delete(get(id));

	}

	@Override
	public Order get(int id) {
		return hibernateTemplate.load(Order.class, id);
	}

	@Override
	public List<Order> getAll() {
		return hibernateTemplate.find("from Order o");
	}
}
