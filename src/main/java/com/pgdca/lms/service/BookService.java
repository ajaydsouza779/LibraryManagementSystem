package com.pgdca.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgdca.lms.model.Book;


public interface BookService {
	
	public Iterable<Book> findAll();

	public List<Book> findByCategory(String string);

	public void addBook(Book bookForm);

	public List<Book> findLatest();
	
}
