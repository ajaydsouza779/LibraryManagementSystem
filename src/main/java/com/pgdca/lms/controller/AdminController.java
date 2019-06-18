package com.pgdca.lms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pgdca.lms.model.Book;
import com.pgdca.lms.model.Role;
import com.pgdca.lms.model.User;
import com.pgdca.lms.repository.RoleRepository;
import com.pgdca.lms.service.BookService;
import com.pgdca.lms.service.SecurityService;
import com.pgdca.lms.service.UserService;
import com.pgdca.lms.serviceImpl.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {

 	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private BookService bookService;
    
    
	@RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
	public String adminPage(@RequestParam Optional<String> page,@RequestParam Optional<String> msg,  ModelMap modelMap, Authentication authentication) {
		log.info(this.getClass().getName());
		log.info("---------------------------------------------------");
		if(page.isPresent())
			modelMap.put("page", page.get());
		
		if(msg!=null && msg.isPresent() )
			modelMap.put("msg", msg.get());
		
		log.info("modelMapp"+modelMap.toString());
		log.info("---------------------------------------------------");		
		return "adminPage";
	}
	
	 @GetMapping("/registerLibrarian")
	    public String registerLibrarian( @RequestParam Optional<String> page, @RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication){
		 	return "redirect:/admin?page=registerLibrarian";
	 }
	 
	 @PostMapping("/registerLibrarian")
	 public String registration( @RequestParam Optional<String> page, @ModelAttribute("userForm") User userForm, BindingResult bindingResult, ModelMap modelMap) {
	     
		 log.info("POST");
		 userValidator.validate(userForm, bindingResult);
	        
	    	if (bindingResult.hasErrors()) {
	    		  return "redirect:/admin?page=registerLibrarian";
	        } 
	    	
	    	String regMsg = "Librarian "+userForm.getUsername()+ " is registered successfully.";
	    	
	        userService.saveLibrarian(userForm);

	        //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

	        log.info("regMsg"+regMsg);
	        
	        return "redirect:/admin?page=registerLibrarian&&msg="+regMsg;
	    }
	 
	 @GetMapping("/addBook")
     public String addBookPage( @RequestParam Optional<String> page, @RequestParam Optional<String> bookId, @RequestParam Optional<String> userId, ModelMap modelMap, Authentication authentication){
		 	return "redirect:/admin?page=addBook";
	 }
	 @PostMapping("/addBook")
	 public String addBook( @RequestParam Optional<String> page, @ModelAttribute("bookForm") Book bookForm, BindingResult bindingResult, ModelMap modelMap) {
	     
		 log.info("POST");
		 //userValidator.validate(userForm, bindingResult);
	        
		 //if (bindingResult.hasErrors()) {
	     //		  return "redirect:/admin?page=addBook";
	     //} 
	    	
	    	String regMsg = "Book <b>"+bookForm.getTitle()+ "</b> is added successfully.";
	    	
	        bookService.addBook(bookForm);

	        //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

	        log.info("regMsg"+regMsg);
	        
	        return "redirect:/admin?page=addBook&&msg="+regMsg;
	    }
	 
}
