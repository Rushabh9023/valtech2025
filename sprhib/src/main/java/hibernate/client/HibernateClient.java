package hibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Account;
import hibernate.Address;
import hibernate.AtmTx;
import hibernate.Car;
import hibernate.ChequeTx;
import hibernate.Customer;
import hibernate.Student;
import hibernate.StudentAddress;
import hibernate.StudentId;
import hibernate.TellerTx;
import hibernate.Tx;

public class HibernateClient {
	
	public static void main(String[] args) {
		SessionFactory sesFac = new AnnotationConfiguration()
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(Tx.class)
				.addAnnotatedClass(ChequeTx.class)
				.addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
//		ses.createQuery("from Tx t").list().stream().forEach(t -> System.out.println(t));
		
//		ses.createQuery("from Customer c where c.age > ?")
//		.setInteger(0, 25).list().stream().forEach(c -> System.out.println(c));
		
//		ses.createQuery("select t from Tx t join t.account.customers c where c.age < ?")
//		.setInteger(0, 25).list().stream().forEach(t -> System.out.println(t));
		
//		ses.createQuery("select t.amount from Tx t join t.account.customers c where c.age < ?")
//		.setInteger(0, 25).list().stream().forEach(t -> System.out.println(t));

		ses.createQuery("select t.amount.id, t.amount from Tx t join t.account.customers c where c.age < ?")
		.setInteger(0, 25).list().stream().forEach(t -> System.out.println(t));
		
		
//	StudentId id = (StudentId)	ses.save(new Student(new StudentId(1,2025),"Abc","Def","CS",9898989898L,
//			new StudentAddress("SomeWhere","Ahm",380041)
//			,new StudentAddress("NoWhere","Raj",676767)));
//		System.out.println(ses.load(Student.class, id));
//		
		
		
//		Long id = (Long)ses.save(new Car(0,"Honda","City",2025));
//		System.out.println(id);
//		Car car = (Car)ses.load(Car.class, id);
//		System.out.println(car);
//		car.setName("Civic");
//		Car car1 = (Car)ses.load(Car.class, id);
//		ses.update(car);
//		ses.flush(); //please dont call session.flush on your own...
//		//flush forces the data to go to the database before commit executes
//		System.out.println(car);
//		System.out.println(car.getClass().getName());

		
		
//		Account acc = (Account) ses.load(Account.class, 1L);
//		Customer cus = (Customer) ses.load(Customer.class, 1L);
//		Account acc1 = new Account(50000,"CA");
//		Account acc2 = new Account(20000,"SB");
//		Customer cus1 = new Customer("DEF",32,false);
//		Customer cus2 = new Customer("XYZ",36,false);
//		
//		ses.save(acc1);
//		ses.save(cus1);
//		ses.save(acc2);
//		ses.save(cus2);
//		
//		cus.addAccount(acc);cus.addAccount(acc1);cus.addAccount(acc2);
//        cus1.addAccount(acc);cus1.addAccount(acc1);
//        cus2.addAccount(acc);
		
//		List<Tx> txs = ses.createQuery("from Tx t").list();
//		Account acc = new Account(10000,"SB");
//		ses.save(acc);
//		txs.stream().forEach(t -> acc.addTx(t));
		
//		Customer c = (Customer) ses.load(Customer.class, 1L);
//		System.out.println(c);
//		System.out.println(c.getAddress());
//		Customer c = new Customer("Abc",23,true);
//		ses.save(c);
//		Address a = new Address("Jayanagar","Blr",560078);
//		c.setAddress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		ses.saveOrUpdate(a);
		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000,12345));
//		ses.save(new TellerTx(3000,"Admin","Jaynagar"));
//		ses.save(new AtmTx(4000,123));
//		
//		List<Tx> txs = ses.createQuery("from Tx t").list();
//		System.out.println(txs);
//		
//				
		
		
		tx.commit();
		ses.close();
		sesFac.close();
		
	}

}
