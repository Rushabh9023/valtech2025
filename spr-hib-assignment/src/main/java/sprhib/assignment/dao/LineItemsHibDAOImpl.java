package sprhib.assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import sprhib.assignment.entity.LineItems;

public class LineItemsHibDAOImpl implements LineItemsHibDAO {
	
	 private HibernateTemplate hibernateTemplate;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	@Override
	public void save(LineItems l) {
		hibernateTemplate.save(l);

	}

	@Override
	public void update(LineItems l) {
		hibernateTemplate.update(l);

	}

	@Override
	public void delete(int id) {
		hibernateTemplate.delete(get(id));

	}

	@Override
	public LineItems get(int id) {
		return hibernateTemplate.load(LineItems.class, id);
	}

	@Override
	public List<LineItems> getAll() {
		return hibernateTemplate.find("from LineItems l");
	}

}
