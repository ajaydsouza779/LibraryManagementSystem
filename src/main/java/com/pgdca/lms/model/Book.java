package com.pgdca.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {

	private @Id @GeneratedValue Long id;
	private String isin;
	private String title;
	private String category;
	private String synopsis;
	private String author;
	private String imageName;
	private Float rate;
	
	private int totalNoOfCopies;
	private int noOfCopiesAvailable;
	private int noOfCopiesIssues;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Long id, String isin, String title, String category, String synopsis, String author, Float rate) {
		super();
		this.id = id;
		this.isin = isin;
		this.title = title;
		this.category = category;
		this.synopsis = synopsis;
		this.author = author;
		this.rate = rate;
	}
	public Book(String isin, String title, String category, String synopsis, String author, Float rate, String imageName) {
		this.isin = isin;
		this.title = title;
		this.category = category;
		this.synopsis = synopsis;
		this.author = author;
		this.rate = rate;
		this.imageName = imageName;
	}
	
	
}
