package com.pgdca.lms.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.pgdca.lms.model.Book;
import com.pgdca.lms.repository.BookRepository;
public class LoadDatabaseAtStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired BookRepository bookRepository;
	
	  /**
	   * This event is executed as late as conceivably possible to indicate that 
	   * the application is ready to service requests.
	   */
	  @Override
	  public void onApplicationEvent(final ApplicationReadyEvent event) {
	 
		  
		  System.out.println("--------------777777777777777777----------------------");
		  //bookRepository.save(new Book());
		  //bookRepository.save(new Book("123", "test"));
	 
	    return;
	  }
	 
	} 