package com.pgdca.lms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.pgdca.lms.model.Book;
import com.pgdca.lms.model.BookRequest;
import com.pgdca.lms.model.Role;
import com.pgdca.lms.model.User;
import com.pgdca.lms.repository.BookRepository;
import com.pgdca.lms.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LibrarianController {
 
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
    @GetMapping("/librarianBoard")
    public String librarianBoard( @RequestParam Optional<String> page, @RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication){
    	//@RequestParam Optional<String> page,
 
    	List<User> users = userRepository.findAll();
    	List<BookRequest> bookIssueRequests = new ArrayList<BookRequest>();
    	List<BookRequest> bookReturnRequests = new ArrayList<BookRequest>();
    	List<User> usersToApprove = new ArrayList<User>();
    	
    	for (User user : users) {
			if(user.getRequestedBooks().size()>0) {
				Collection<Book> requestedBooks = user.getRequestedBooks();
				for (Book requestedBook : requestedBooks) {
					log.info(requestedBook.toString());
					bookIssueRequests.add(new BookRequest(requestedBook.getId(), user.getId(), requestedBook.getTitle(), user.getFirstName() + " " +user.getLastName(), user.getUsername(), user.getIsApproved()));
				}
			}
			if(user.getRequestedBooks().size()>0) {
				Collection<Book> returnBooks = user.getReturnBooks();
				for (Book returnBook : returnBooks) {
					log.info(returnBook.toString());
					bookReturnRequests.add(new BookRequest(returnBook.getId(), user.getId(), returnBook.getTitle(), user.getFirstName() + " " +user.getLastName(), user.getUsername(), user.getIsApproved()));
				}
			}
			if(user.getIsApproved()== null || !user.getIsApproved() ) {
				Collection<Role> usrRoles = user.getRoles();
				for (Role usrRole : usrRoles) {
					if(usrRole.getName().equals("ROLE_PUBLIC")) {
						usersToApprove.add(user);
					}
				}
				
			}
		}
    	
		
		log.info("-bookIssueRequests ="+bookIssueRequests.size());
		modelMap.put("bookIssueRequests", bookIssueRequests);
		log.info("-bookReturnRequests ="+bookReturnRequests.size());
		modelMap.put("bookReturnRequests", bookReturnRequests);
		
		  log.info("-usersToApprove ="+usersToApprove.size());
		  log.info("-usersToApprove ="+usersToApprove.toString());
			
		  
		  
		   modelMap.put("usersToApprove", usersToApprove);
		 
		
		
		
		  if (page.isPresent()) { String pageEleId = page.get();
		  modelMap.addAttribute("page", pageEleId); }
		 
		
        return "librarianBoard";
    } 
    
    @GetMapping("/approveBookRequest")
    public String approveBookRequest(@RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication) throws NumberFormatException{
    
    	
		log.info("bookid="+bookId);
		log.info("user="+userId);
    	
    	Optional<Book> OpBook; OpBook	= bookId.isPresent() ? bookRepository.findById(Long.parseLong(bookId.get())) 	: null;
		Optional<User> OpUser; OpUser 	= userId.isPresent() ? userRepository.findById(Long.parseLong( userId.get())) 	: null;

		User user = null;
		Book book = null;
	
		if (OpBook != null && OpUser!= null) {			
			user = OpUser.get();
			book = OpBook.get();
			user.getRequestedBooks().remove(book);
			user.getIssuedBooks().add(book);
			
			Book bookToIssue=book;
			bookToIssue.setNoOfCopiesIssues(bookToIssue.getNoOfCopiesIssues()+1);
			bookToIssue.setNoOfCopiesAvailable(bookToIssue.getNoOfCopiesAvailable()-1 < 0 ? 0 :bookToIssue.getNoOfCopiesAvailable()-1);

			
			userRepository.save(user);
		}

		
    	return "redirect:/librarianBoard?page=approveBookRequest";
    }
    
    
    @GetMapping("/bookReturned")
    public String bookReturned(@RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication) throws NumberFormatException{
    
    	
		log.info("bookid="+bookId);
		log.info("user="+userId);
    	
    	Optional<Book> OpBook; OpBook	= bookId.isPresent() ? bookRepository.findById(Long.parseLong(bookId.get())) 	: null;
		Optional<User> OpUser; OpUser 	= userId.isPresent() ? userRepository.findById(Long.parseLong( userId.get())) 	: null;

		User user = null;
		Book book = null;
	
		if (OpBook != null && OpUser!= null) {			
			user = OpUser.get();
			book = OpBook.get();
			user.getReturnBooks().remove(book);
			
			Book bookToIssue=book;
			bookToIssue.setNoOfCopiesIssues(bookToIssue.getNoOfCopiesIssues()-1);
			bookToIssue.setNoOfCopiesAvailable(bookToIssue.getNoOfCopiesAvailable()+1 );

			
			userRepository.save(user);
		}

		
    	return "redirect:/librarianBoard?page=bookReturned";
    }
    
    @GetMapping("/approveUser")
    public String approveUser(@RequestParam Optional<String> userId, ModelMap modelMap) throws NumberFormatException{
    
    	
		log.info("user="+userId);
    	
    	Optional<User> OpUser; OpUser 	= userId.isPresent() ? userRepository.findById(Long.parseLong( userId.get())) 	: null;

		User user = null;
		
	
		if (OpUser!= null) {			
			user = OpUser.get();
			user.setIsApproved(true);
			userRepository.save(user);
		}


		
    	return "redirect:/librarianBoard?page=ApproveUser";
    }
}
