package com.valtech.training.first.entities;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "autseq")
	@SequenceGenerator(name = "autseq",sequenceName = "author_seq",allocationSize = 1)
	private int id;
	private String name;
	private String address;
	
	
	@ManyToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
	@JoinTable(
	        name = "book_author",
	        joinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id")
	    )
	private Set<Book> books;

	public Author() {} 
	public Author(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	

}
