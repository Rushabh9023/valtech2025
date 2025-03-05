package sprhib.assignment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
	@SequenceGenerator(name = "itemseq",sequenceName = "item_seq",allocationSize = 1,initialValue = 1)
	private int itemId;
	private String itemName;
	private String itemDesc;
	private int currentQuentity;
	private int reorderQuentity;
	private int maxQuentity;
	
	@OneToMany(targetEntity = LineItems.class,mappedBy = "item",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<LineItems> lineItems;
	
	
	public Item() {}

	public Item(String itemName, String itemDesc, int currentQuentity, int reorderQuentity,
			int maxQuentity) {
		
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.currentQuentity = currentQuentity;
		this.reorderQuentity = reorderQuentity;
		this.maxQuentity = maxQuentity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getCurrentQuentity() {
		return currentQuentity;
	}

	public void setCurrentQuentity(int currentQuentity) {
		this.currentQuentity = currentQuentity;
	}

	public int getReorderQuentity() {
		return reorderQuentity;
	}

	public void setReorderQuentity(int reorderQuentity) {
		this.reorderQuentity = reorderQuentity;
	}

	public int getMaxQuentity() {
		return maxQuentity;
	}

	public void setMaxQuentity(int maxQuentity) {
		this.maxQuentity = maxQuentity;
	}
	

	public List<LineItems> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItems> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", currentQuentity="
				+ currentQuentity + ", reorderQuentity=" + reorderQuentity + ", maxQuentity=" + maxQuentity + "]";
	}

	
	
	

}
