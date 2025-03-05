package sprhib.assignment.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Info")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ordseq")
	@SequenceGenerator(name = "ordseq",sequenceName = "ord_seq",allocationSize = 1,initialValue = 101)
	private int orderId;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId",referencedColumnName = "custId")
	private Customer customer;
	
	@OneToMany(targetEntity = LineItems.class, mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LineItems> lineItems;

	
	
	public enum Status {FAILED,PLACED,COMPLETED;}


	
	
	public Order() {}

	public Order(Status status) {
	    this.status = status;
	}

	public void addLineItem(LineItems li) {
		if(lineItems == null ) lineItems = new ArrayList<LineItems>();
		lineItems.add(li);
		li.setOrder(this);
	}
	public void removeLineItem(LineItems li) {
		lineItems.remove(li);
		li.setOrder(null);
	}

	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

public List<LineItems> getLineItems() {
	return lineItems;
}

public void setLineItems(List<LineItems> lineItems) {
	this.lineItems = lineItems;
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
