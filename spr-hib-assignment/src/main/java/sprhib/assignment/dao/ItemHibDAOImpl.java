package sprhib.assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import sprhib.assignment.entity.Item;

public class ItemHibDAOImpl implements ItemHibDAO {
	
	 private HibernateTemplate hibernateTemplate;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	@Override
	public void save(Item i) {
		hibernateTemplate.save(i);

	}

	@Override
	public void update(Item i) {
		hibernateTemplate.update(i);

	}

	@Override
	public void delete(int id) {
		hibernateTemplate.delete(get(id));

	}

	@Override
	public Item get(int id) {
		return hibernateTemplate.load(Item.class, id);
	}

	@Override
	public List<Item> getAll() {
		return hibernateTemplate.find("from Item i");
	}

}
