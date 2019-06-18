package com.pgdca.lms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pgdca.lms.model.User;
import com.pgdca.lms.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserValidator implements Validator {

	@Autowired
    private UserService userService;

	   @Override
	    public boolean supports(Class<?> aClass) {
	        return User.class.equals(aClass);
	    }
	   
	   @Override
	    public void validate(Object o, Errors errors) {
		   
		   log.info(this.getClass().toString(), "entry");
		   
	        User user = (User) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
	            errors.rejectValue("username", "Size.userForm.username");
	        }
	        
	        
	        if (userService.findByUsername(user.getUsername()) != null) {
	            errors.rejectValue("username", "Duplicate.userForm.username");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size.userForm.password");
	        }

	        if (!user.getPasswordConfirm().equals(user.getPassword())) {
	            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
	        }
	        
	        log.info(this.getClass().toString(), "exit");
			
	    }

}
