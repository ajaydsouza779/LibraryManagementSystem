package com.pgdca.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgdca.lms.model.Book;
import com.pgdca.lms.repository.BookRepository;
import com.pgdca.lms.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service("bookService")
@Slf4j
public class BookServiceImpl implements BookService  {

	@Autowired
	private BookRepository bookrepository;

	@Override
	public Iterable<Book> findAll() {
		return bookrepository.findAll();
	}

	@Override
	public List<Book> findByCategory(String category) {		
		List<Book> b =  bookrepository.findByCategory(category);
		log.info("category - ",b.size());
		return b;
	}

	@Override
	public void addBook(Book bookForm) {
		bookForm.setNoOfCopiesAvailable(bookForm.getTotalNoOfCopies());		
		Book a = bookrepository.save(bookForm);
		log.info("book saved- ",a);
		
	}

	@Override
	public List<Book> findLatest() {
		List<Book> books =  bookrepository.findLatest();
		log.info("category - ",books.size());
		return books;
	}
	
	
}