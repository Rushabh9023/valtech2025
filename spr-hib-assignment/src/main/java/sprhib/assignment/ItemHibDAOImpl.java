package sprhib.assignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ItemHibDAOImpl implements ItemHibDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Item i) {
		new HibernateTemplate(sessionFactory).save(i);

	}

	@Override
	public void update(Item i) {
	new HibernateTemplate(sessionFactory).update(i);

	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));

	}

	@Override
	public Item get(int id) {
		return new HibernateTemplate(sessionFactory).load(Item.class, id);
	}

	@Override
	public List<Item> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Item i");
	}

}
