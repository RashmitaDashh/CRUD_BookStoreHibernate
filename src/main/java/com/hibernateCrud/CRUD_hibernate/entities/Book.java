package com.hibernateCrud.CRUD_hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "bookData")
public class Book {
	@Id
	@Column(name= "bookid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name= "BookTitle")
	private String name;
	private String language;
	private String publisher;
	@Column
	private String author;
	@Column
	private String seller;
	
	//Constructors...........................................
	
	public Book() {
		super();
	}

	public Book(String name, String language, String publisher, String author, String seller) {
		super();
		this.name = name;
		this.language = language;
		this.publisher = publisher;
		this.author = author;
		this.seller = seller;
	}

	public Book(int id, String name, String language, String publisher, String author, String seller) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.publisher = publisher;
		this.author = author;
		this.seller = seller;
	}

	//GETTERS AND SETTERS
	
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", language=" + language + ", publisher=" + publisher + ", author="
				+ author + ", seller=" + seller + "]";
	}

	
}