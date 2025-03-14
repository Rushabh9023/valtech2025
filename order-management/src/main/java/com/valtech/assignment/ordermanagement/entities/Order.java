package com.valtech.assignment.ordermanagement.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name = "Order_Info")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ordseq")
	@SequenceGenerator(name = "ordseq",sequenceName = "ord_seq",allocationSize = 1,initialValue = 101)
	private int orderId;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId",referencedColumnName = "custId")
	private Customer customer;
	
	@OneToMany(targetEntity = LineItems.class, mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<LineItems> lineItems;

	
	
	public enum Status {FAILED,PLACED,COMPLETED;}


	
	public Order() {}

	public Order(Status status) {
	    this.status = status;
	}

	

	public Order(int orderId, Customer customer, List<LineItems> lineItems) {
		this.orderId = orderId;
		this.customer = customer;
		this.lineItems = lineItems;
	}

	public void addLineItem(LineItems li) {
		System.out.println("oooooooooooooooooooooooooooooooo"+li.getQuentity());
		if (lineItems == null) lineItems = new ArrayList<LineItems>();
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
