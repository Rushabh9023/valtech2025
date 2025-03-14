package com.valtech.assignment.ordermanagement.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineItems {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineseq")
	@SequenceGenerator(name = "lineseq",sequenceName = "line_seq",allocationSize = 1,initialValue = 1)
	private int lineItemId;
	private int quentity;
	
	@ManyToOne(targetEntity = Item.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_Id",referencedColumnName = "itemId")
	private Item item;
	@ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "order_Id",referencedColumnName = "orderId")
	private Order order;
	
	public LineItems() {}
	public LineItems(int quentity) {
		this.quentity = quentity;
	}
	
	public LineItems(int lineItemId, int quentity, Item item, Order order) {
		this.lineItemId = lineItemId;
		this.quentity = quentity;
		this.item = item;
		this.order = order;
	}
	public int getLineItemId() {
		return lineItemId;
	}
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}
	public int getQuentity() {
		return quentity;
	}
	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "LineItems [lineItemId=" + lineItemId + ", quentity=" + quentity + ", item=" + item + ", order=" + order
				+ "]";
	}
	
	
	

}
