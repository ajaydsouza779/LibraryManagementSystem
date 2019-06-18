package com.pgdca.lms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pgdca.lms.model.Book;
import com.pgdca.lms.model.PgLists;
import com.pgdca.lms.model.User;
import com.pgdca.lms.repository.BookRepository;
import com.pgdca.lms.repository.NoteRepository;
import com.pgdca.lms.repository.UserRepository;
import com.pgdca.lms.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	BookService bookService;
	
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	  public ModelAndView welcome() {
	    	ModelAndView model = new ModelAndView();
	    	
	       	model.addObject("urlOfImg", "http://localhost:8080/LMSMEDIA/");
	    	
	    	model.setViewName("DashBoard");//Welcome //Dashboard
	    	return model;
	    }
	
	@RequestMapping(value = "/dashboardV2", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		
		modelMap.put("urlOfImg", "http://localhost:8080/LMSMEDIA/");
		
		List<Book> allBooks = (List<Book>) bookService.findAll();
		modelMap.put("allbooks", allBooks);
		
		List<Book> books = (List<Book>) bookService.findLatest();
		System.out.println("---------------------------------------------books ="+books.size());
		PagedListHolder pagedListHolder = new PagedListHolder(books);
		pagedListHolder.setPage(ServletRequestUtils.getIntParameter(request, "p", 0));
		pagedListHolder.setPageSize(4);
		modelMap.put("pagedListHolder", pagedListHolder);
		
		
		/*
		 * List<String> bookCategories = new ArrayList<String>();
		 * bookCategories.add("Comedy"); bookCategories.add("Fiction");
		 * modelMap.put("bookCategories",bookCategories);
		 * 
		 * List<PgLists> pgList = new ArrayList<PgLists>(); for (String bookCatetgory :
		 * bookCategories) { PagedListHolder pagedListHolderByCategory = new
		 * PagedListHolder((List<Book>) bookService.findByCategory(bookCatetgory));
		 * pagedListHolderByCategory.setPage(ServletRequestUtils.getIntParameter(
		 * request, "pageByCategory"+bookCatetgory, 0));
		 * pagedListHolderByCategory.setPageSize(4);
		 * modelMap.put("pagedListHolderByCategory"+bookCatetgory,
		 * pagedListHolderByCategory);
		 * 
		 * 
		 * //PgLists pg = new PgLists(bookCatetgory,
		 * "pagedListHolderByCategory"+bookCatetgory, pagedListHolderByCategory);
		 * //pgList.add(pg); } //modelMap.put("pgList",pgList);
		 */		
		
		List<Book> booksByCategoryComedy = (List<Book>) bookService.findByCategory("Comedy");//findByCategory("Fiction");
		System.out.println("---------------------------------booksByCategory ="+booksByCategoryComedy.size());	
		PagedListHolder pagedListHolderByCategoryComedy = new PagedListHolder(booksByCategoryComedy);
		pagedListHolderByCategoryComedy.setPage(ServletRequestUtils.getIntParameter(request, "pageByCategoryComedy", 0));
		pagedListHolderByCategoryComedy.setPageSize(4);
		modelMap.put("pagedListHolderByCategoryComedy", pagedListHolderByCategoryComedy);

		List<Book> booksByCategoryFiction = (List<Book>) bookService.findByCategory("Fiction");//findByCategory("Fiction");
		System.out.println("---------------------------------booksByCategory ="+booksByCategoryFiction.size());
		PagedListHolder pagedListHolderByCategoryFiction = new PagedListHolder(booksByCategoryFiction);
		pagedListHolderByCategoryFiction.setPage(ServletRequestUtils.getIntParameter(request, "pageByCategoryFiction", 0));
		pagedListHolderByCategoryFiction.setPageSize(4);
		modelMap.put("pagedListHolderByCategoryFiction", pagedListHolderByCategoryFiction);

		List<Book> booksByCategoryNovel = (List<Book>) bookService.findByCategory("Novel");//findByCategory("Fiction");
		System.out.println("---------------------------------booksByCategory ="+booksByCategoryNovel.size());
		log.info(booksByCategoryNovel.toString());
		PagedListHolder pagedListHolderByCategoryNovel = new PagedListHolder(booksByCategoryNovel);
		pagedListHolderByCategoryNovel.setPage(ServletRequestUtils.getIntParameter(request, "pageByCategoryNovel", 0));
		pagedListHolderByCategoryNovel.setPageSize(4);
		modelMap.put("pagedListHolderByCategoryNovel", pagedListHolderByCategoryNovel);
		
		return "DashBoardV2";
	}
	
	
	@GetMapping("/requestToIssue")
	public String requestToIssue(@RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication) {

		User user = null;
		Book book = null;
		
		log.info("bookid="+bookId);
		log.info("user="+userId);
		
		Optional<Book> OpBook; OpBook	= bookId.isPresent() ? bookRepository.findById(Long.parseLong(bookId.get())) 	: null;
		Optional<User> OpUser; OpUser 	= userId.isPresent() ? userRepository.findById(Long.parseLong( userId.get())) 	: null;
				
		if (OpUser == null) {
			log.info("No User from param");
			String fetchedName = authentication.getName();
			log.info("fetchedName"+fetchedName);
			user = userRepository.findByUsername(fetchedName);
		} else {
			user = OpUser.get();
		}

		if (OpBook != null) {			
			user = OpUser.get();
			
			Book bookToIssue = OpBook.get();
			//bookToIssue.setNoOfCopiesIssues(bookToIssue.getNoOfCopiesIssues()+1);
			//bookToIssue.setNoOfCopiesAvailable(bookToIssue.getNoOfCopiesAvailable()-1 < 0 ? 0 :bookToIssue.getNoOfCopiesAvailable()-1);
			
			user.getRequestedBooks().add(bookToIssue);
			userRepository.save(user);
		} 

			
		List<Book> requestedBooks = (List<Book>) user.getRequestedBooks();
		
		log.info("-requestedBooks ="+requestedBooks.size());
		modelMap.put("requestedBooks", requestedBooks);
		
		return "requestToIssue";
	}
	
	@GetMapping("/cancelBookRequest")
	public String cancelBookRequest(@RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication) {
		
		User user = null;
		Book book = null;
		
		log.info("bookid="+bookId);
		
		Optional<Book> OpBook; OpBook	= bookId.isPresent() ? bookRepository.findById(Long.parseLong(bookId.get())) 	: null;

		log.info("No User from param");
		String fetchedName = authentication.getName();
		log.info("fetchedName"+fetchedName);
		user = userRepository.findByUsername(fetchedName);

		if (OpBook != null) {	
			user.getRequestedBooks().remove(OpBook.get());

			userRepository.save(user);
		}
		

			
		List<Book> requestedBooks = (List<Book>) user.getRequestedBooks();
		
		log.info("-requestedBooks ="+requestedBooks.size());
		modelMap.put("requestedBooks", requestedBooks);
		
		return "requestToIssue";
	}
	
	
	
	@GetMapping("/issuedBooks")
	public String issuedBooks(@RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication) {

		User user = null;
		Book book = null;
		
		log.info("bookid="+bookId);
		log.info("user="+userId);
		
		Optional<Book> OpBook; OpBook	= bookId.isPresent() ? bookRepository.findById(Long.parseLong(bookId.get())) 	: null;
		Optional<User> OpUser; OpUser 	= userId.isPresent() ? userRepository.findById(Long.parseLong( userId.get())) 	: null;

				
		if (OpUser == null) {
			log.info("No User from param");
			String fetchedName = authentication.getName();
			log.info("fetchedName"+fetchedName);
			user = userRepository.findByUsername(fetchedName);
		} else {
			user = OpUser.get();
		}
			
		List<Book> issuedBooks = (List<Book>) user.getIssuedBooks();
		log.info("-issuedBooks ="+issuedBooks.size());
		modelMap.put("issuedBooks", issuedBooks);
		
		List<Book> returnBooks = (List<Book>) user.getReturnBooks();
		log.info("-returnBooks ="+returnBooks.size());
		modelMap.put("returnBooks", returnBooks);
		
		return "issuedBooks";
	}
	@GetMapping("/returnBookRequest")
	public String returnBookRequest(@RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication) {
		
		User user = null;
		Book book = null;
		
		log.info("bookid="+bookId);
		log.info("user="+userId);
		
		Optional<Book> OpBook; OpBook	= bookId.isPresent() ? bookRepository.findById(Long.parseLong(bookId.get())) 	: null;
		Optional<User> OpUser; OpUser 	= userId.isPresent() ? userRepository.findById(Long.parseLong( userId.get())) 	: null;

				
		if (OpUser == null) {
			log.info("No User from param");
			String fetchedName = authentication.getName();
			log.info("fetchedName"+fetchedName);
			user = userRepository.findByUsername(fetchedName);
		} else {
			user = OpUser.get();
		}

		if (OpBook != null) {			
			
			user.getReturnBooks().add(OpBook.get());
			user.getIssuedBooks().remove(OpBook.get());
			userRepository.save(user);
		}

			
		/*
		 * List<Book> returnBooks = (List<Book>) user.getReturnBooks();
		 * log.info("-returnBooks ="+returnBooks.size()); modelMap.put("returnBooks",
		 * returnBooks);
		 * 
		 * List<Book> issuedBooks = (List<Book>) user.getIssuedBooks();
		 * log.info("-issuedBooks ="+issuedBooks.size()); modelMap.put("issuedBooks",
		 * issuedBooks);
		 */		
		return "redirect:/issuedBooks";
	}
	@GetMapping("/cancelReturnBookRequest")
	public String cancelReturnBookRequest(@RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication) {
		
		User user = null;
		Book book = null;
		
		log.info("bookid="+bookId);
		
		Optional<Book> OpBook; OpBook	= bookId.isPresent() ? bookRepository.findById(Long.parseLong(bookId.get())) 	: null;

	
		String fetchedName = authentication.getName();
		log.info("fetchedName"+fetchedName);
		user = userRepository.findByUsername(fetchedName);

		if (OpBook != null) {	
		
			user.getReturnBooks().remove(OpBook.get());
			user.getIssuedBooks().add(OpBook.get());
			userRepository.save(user);
			userRepository.save(user);
		}
		

			
		List<Book> requestedBooks = (List<Book>) user.getRequestedBooks();
		
		log.info("-requestedBooks ="+requestedBooks.size());
		modelMap.put("requestedBooks", requestedBooks);
		
		return "redirect:/issuedBooks";
	}
	
}
