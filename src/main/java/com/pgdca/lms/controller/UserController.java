package com.pgdca.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pgdca.lms.model.User;
import com.pgdca.lms.service.SecurityService;
import com.pgdca.lms.service.UserService;
import com.pgdca.lms.serviceImpl.UserValidator;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	 	@Autowired
	    private UserService userService;

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    private UserValidator userValidator;
	    
	    

	    @GetMapping("/registration")
	    public String registration(Model model) {
	        model.addAttribute("userForm", new User());

	        return "auth/registration";
	    } 
	    
	    @PostMapping("/registration")
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
	        userValidator.validate(userForm, bindingResult);
	        
	    	if (bindingResult.hasErrors()) {
	            return "auth/registration";
	        }

	        userService.savePublic(userForm);

	        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

	        return "redirect:/homepage";
	    }
	    @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        
    	log.info(this.getClass() + error);	
    	
    	log.info(model.toString());
    	
	    System.out.println("/login     -----------------" + error);
	    	
	    	if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "auth/login";
	    }
	    

	    
	    @GetMapping({"/", "/homepage"})
	    public String welcome(Model model) {
	    	return "redirect:/dashboardV2";
	    }

}
