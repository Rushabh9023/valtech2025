package sprhib.assignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ordseq")
	@SequenceGenerator(name = "ordseq",sequenceName = "ord_seq",allocationSize = 1,initialValue = 101)
	private int orderId;
	private Status status;
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId",referencedColumnName = "custId")
	private Customer customer;
	
	@OneToMany(targetEntity = LineItems.class,mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<LineItems> getLineItems;

	
	
	public enum Status {PENDING,IN_PROCESS,COMPLETED;}


	
	
	public Order() {}

	public Order(Status status) {
		this.status = status;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public Set<LineItems> getGetLineItems() {
		return getLineItems;
	}


	public void setGetLineItems(Set<LineItems> getLineItems) {
		this.getLineItems = getLineItems;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
