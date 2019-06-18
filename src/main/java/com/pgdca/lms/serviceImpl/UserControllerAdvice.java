package com.pgdca.lms.serviceImpl;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pgdca.lms.model.User;
import com.pgdca.lms.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class UserControllerAdvice {

	@Autowired
	UserRepository userRep;
	
	@ModelAttribute("username")
    public String username(Principal principal) {
        return principal == null ? null : principal.getName();
    }
    
    @ModelAttribute("userId")
    public Long userId(Principal principal) {
        
    	String userName=  principal ==null  ?  null :  principal.getName();
    	log.info(userName);
    	
    	User user = userName == null ? null : userRep.findByUsername(userName);
    	
    	return user == null ? null : user.getId();
    }
    @ModelAttribute("firstLastName")
    public String firstLastName(Principal principal) {
        
    	String userName=  principal ==null  ?  null :  principal.getName();
    	log.info(userName);
    	
    	User user = userName == null ? null : userRep.findByUsername(userName);
    	
    	return user == null ? null : user.getFirstName() + user.getLastName();
    }
}