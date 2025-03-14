package com.valtech.assignment.ordermanagement.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



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
	
	@Enumerated(EnumType.STRING) 
	@Column(nullable = false)
	private Status status = Status.ENABLED;
	
	public enum Status {ENABLED,DISABLED;}
	
	
	@OneToMany(targetEntity = Order.class, mappedBy = "customer", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Order> orders;
	
	
	public Customer() {}
	
	
	public Customer(int custId, String name, int age, String address, String perAddress, Status status) {
		this.custId = custId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = perAddress;
		this.status = status;
	}


	public Customer(String name, int age, String address, String perAddress) {
		
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = perAddress;
		this.status = Status.ENABLED;
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
	public void setStatus(Status status) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", perAddress=" + perAddress + ", status=" + status + "]";
	}


//	@Override
//	public String toString() {
//		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + ", address=" + address
//				+ ", perAddress=" + perAddress + "]";
//	}
	
	
	
	
	
	

}
