package sprhib.assignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer_t")
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusseq")
	@SequenceGenerator(name = "cusseq",sequenceName = "cus_seq",allocationSize = 1,initialValue = 1)
	private int custId;
	private String name;
	private int age;
	private String address;
	private String perAddress;
	
	
	
	
	
	public Customer() {}
	
	
	public Customer(String name, int age, String address, String perAddress) {
		
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = perAddress;
	}




	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPerAddress() {
		return perAddress;
	}
	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", perAddress=" + perAddress + "]";
	}
	
	
	
	

}
