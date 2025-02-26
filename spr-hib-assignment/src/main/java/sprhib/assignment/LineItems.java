package sprhib.assignment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LineItems {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineseq")
	@SequenceGenerator(name = "lineseq",sequenceName = "line_seq",allocationSize = 1,initialValue = 1)
	private int lineItemId;
	private int Quentity;
	
	@ManyToOne(targetEntity = Item.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_Id",referencedColumnName = "itemId")
	private Item item;
	@ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "order_Id",referencedColumnName = "orderId")
	private Order order;
	
	public LineItems() {}
	public LineItems(int quentity) {
		Quentity = quentity;
	}
	
	public int getLineItemId() {
		return lineItemId;
	}
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}
	public int getQuentity() {
		return Quentity;
	}
	public void setQuentity(int quentity) {
		Quentity = quentity;
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
	
	
	

}
